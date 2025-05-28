document.addEventListener("DOMContentLoaded", () => {
  carregarID();
  carregarSelects();

  const form = document.getElementById("travel-form");
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    await submitViagem();
  });
});

function carregarID() {
  fetch("http://localhost/LTD/TravelRegistration/endpoint_id.php")
    .then(response => response.json())
    .then(data => {
      if (data.proximo_id) {
        document.getElementById("id_viagem").value = data.proximo_id;
      }
    })
    .catch(error => console.error("Erro ao obter próximo ID:", error));
}

// Função genérica para carregar dados de um endpoint e popular um select
async function carregarSelect(url, selectId) {
  try {
    const response = await fetch(url);
    const registros = await response.json();
    const select = document.getElementById(selectId);
    if (select) {
      select.innerHTML = '<option value="">Selecione</option>';
      registros.forEach(reg => {
        const option = document.createElement("option");
        option.value = reg.id;
        option.textContent = reg.descricao || reg.nome; // adapte conforme o campo retornado
        select.appendChild(option);
      });
    }
  } catch (error) {
    console.error("Erro ao carregar select " + selectId, error);
  }
}

// Chama os endpoints para popular cada select (ajuste as URLs conforme sua aplicação)
function carregarSelects() {
  carregarSelect("http://localhost/LTD/TravelRegistration/endpoint_motorista.php", "motorista");
  carregarSelect("http://localhost/LTD/TravelRegistration/endpoint_deposito.php", "deposito");
  carregarSelect("http://localhost/LTD/TravelRegistration/endpoint_fabrica.php", "fabrica");
  carregarSelect("http://localhost/LTD/TravelRegistration/endpoint_cavalo.php", "cavalo");
  carregarSelect("http://localhost/LTD/TravelRegistration/endpoint_carreta.php", "carreta");
}

// Função para calcular os trechos (segmentos) baseado no horário de início, paradas e término
function calcularTrechos(inicio, paradas, termino) {
  const trechos = [];
  if (paradas.length > 0) {
    // Primeiro trecho: do início da viagem até o início da 1ª parada
    trechos.push({ inicio: inicio, fim: paradas[0].inicio });
    // Trechos intermediários entre paradas
    for (let i = 1; i < paradas.length; i++) {
      trechos.push({ inicio: paradas[i - 1].fim, fim: paradas[i].inicio });
    }
    // Último trecho: do fim da última parada até o término da viagem
    trechos.push({ inicio: paradas[paradas.length - 1].fim, fim: termino });
  }
  return trechos;
}

// Função para coletar os dados do formulário e enviá-los ao backend
async function submitViagem() {
  const viagem = {};

  // Dados gerais
  viagem.data_viagem = document.getElementById("data_viagem").value;
  viagem.inicio = document.getElementById("inicio").value;
  viagem.motorista = document.getElementById("motorista").value;
  viagem.deposito = document.getElementById("deposito").value;
  viagem.fabrica = document.getElementById("fabrica").value;
  viagem.cavalo = document.getElementById("cavalo").value;
  viagem.carreta = document.getElementById("carreta").value;

  // Trajeto de Ida – coleta das paradas
  const idaParadas = [];
  // Parada 1 (obrigatória)
  if (
    document.getElementById("parada1").value &&
    document.getElementById("parada1_inicio").value &&
    document.getElementById("parada1_fim").value
  ) {
    idaParadas.push({
      tipo: document.getElementById("parada1").value,
      inicio: document.getElementById("parada1_inicio").value,
      fim: document.getElementById("parada1_fim").value
    });
  }
  // Paradas opcionais
  if (
    document.getElementById("parada2").value &&
    document.getElementById("parada2_inicio").value &&
    document.getElementById("parada2_fim").value
  ) {
    idaParadas.push({
      tipo: document.getElementById("parada2").value,
      inicio: document.getElementById("parada2_inicio").value,
      fim: document.getElementById("parada2_fim").value
    });
  }
  if (
    document.getElementById("parada3").value &&
    document.getElementById("parada3_inicio").value &&
    document.getElementById("parada3_fim").value
  ) {
    idaParadas.push({
      tipo: document.getElementById("parada3").value,
      inicio: document.getElementById("parada3_inicio").value,
      fim: document.getElementById("parada3_fim").value
    });
  }
  if (
    document.getElementById("parada4").value &&
    document.getElementById("parada4_inicio").value &&
    document.getElementById("parada4_fim").value
  ) {
    idaParadas.push({
      tipo: document.getElementById("parada4").value,
      inicio: document.getElementById("parada4_inicio").value,
      fim: document.getElementById("parada4_fim").value
    });
  }
  // Definindo o término da ida – usamos o horário de início da refeição como referência
  viagem.ida = {
    paradas: idaParadas,
    termino: document.getElementById("refeicao_inicio").value
  };
  viagem.ida.trechos = calcularTrechos(viagem.inicio, idaParadas, viagem.ida.termino);

  // Dados da Chegada
  viagem.chegada = {
    refeicao: {
      id: document.getElementById("refeicao").value,
      inicio: document.getElementById("refeicao_inicio").value,
      fim: document.getElementById("refeicao_fim").value
    },
    tempo_espera: {
      id: document.getElementById("tempo_espera").value,
      inicio: document.getElementById("tempo_inicio").value,
      fim: document.getElementById("tempo_fim").value
    },
    encerramento: {
      data: document.getElementById("retorno").value,
      hora: document.getElementById("hora_encerramento").value
    }
  };

  // Trajeto de Volta – coleta das paradas
  const voltaParadas = [];
  // Volta: Parada 1 (obrigatória)
  if (
    document.getElementById("volta_parada1").value &&
    document.getElementById("volta_parada1_inicio").value &&
    document.getElementById("volta_parada1_fim").value
  ) {
    voltaParadas.push({
      tipo: document.getElementById("volta_parada1").value,
      inicio: document.getElementById("volta_parada1_inicio").value,
      fim: document.getElementById("volta_parada1_fim").value
    });
  }
  // Paradas opcionais na volta
  if (
    document.getElementById("volta_parada2").value &&
    document.getElementById("volta_parada2_inicio").value &&
    document.getElementById("volta_parada2_fim").value
  ) {
    voltaParadas.push({
      tipo: document.getElementById("volta_parada2").value,
      inicio: document.getElementById("volta_parada2_inicio").value,
      fim: document.getElementById("volta_parada2_fim").value
    });
  }
  if (
    document.getElementById("volta_parada3").value &&
    document.getElementById("volta_parada3_inicio").value &&
    document.getElementById("volta_parada3_fim").value
  ) {
    voltaParadas.push({
      tipo: document.getElementById("volta_parada3").value,
      inicio: document.getElementById("volta_parada3_inicio").value,
      fim: document.getElementById("volta_parada3_fim").value
    });
  }
  if (
    document.getElementById("volta_parada4").value &&
    document.getElementById("volta_parada4_inicio").value &&
    document.getElementById("volta_parada4_fim").value
  ) {
    voltaParadas.push({
      tipo: document.getElementById("volta_parada4").value,
      inicio: document.getElementById("volta_parada4_inicio").value,
      fim: document.getElementById("volta_parada4_fim").value
    });
  }
  // Definindo os limites da volta: usaremos o fim do tempo de espera como início e o horário de encerramento como término
  viagem.volta = {
    paradas: voltaParadas,
    inicio: document.getElementById("tempo_fim").value,
    termino: document.getElementById("hora_encerramento").value
  };
  viagem.volta.trechos = calcularTrechos(viagem.volta.inicio, voltaParadas, viagem.volta.termino);

  // Debug: exibe os dados no console
  console.log("Dados da Viagem:", viagem);

  // Envia os dados para o PHP
  try {
    const response = await fetch("http://localhost/LTD/TravelRegistration/main.php", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json"
      },
      body: JSON.stringify(viagem)
    });
    const result = await response.json();
    if (result.id_viagem) {
      document.getElementById("id_viagem").value = result.id_viagem;
    }
    alert(result.mensagem);
  } catch (error) {
    console.error("Erro ao enviar os dados da viagem:", error);
    alert("Erro ao enviar os dados da viagem.");
  }
}
