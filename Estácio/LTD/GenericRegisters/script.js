document.addEventListener("DOMContentLoaded", function () {
  const registroSelect = document.getElementById("registro");
  const formSections = document.querySelectorAll(".form-section");

  // Alterar a exibição das seções conforme o tipo de registro selecionado
  registroSelect.addEventListener("change", function () {
    formSections.forEach(section => section.style.display = "none");
    const tipoSelecionado = registroSelect.value;
    if (tipoSelecionado) {
      const section = document.getElementById(`form-${tipoSelecionado}`);
      if (section) section.style.display = "block";
    }
  });

  const form = document.getElementById("form");
  form.addEventListener("submit", function (e) {
    e.preventDefault();
    cadastrar();
  });
});

function cadastrar() {
  const registro = document.getElementById("registro").value;
  if (!registro) {
    document.getElementById("mensagem").textContent = "Selecione um tipo de registro.";
    return;
  }

  let dados = { registro };

  // Coleta dos dados de acordo com o tipo de registro
  switch (registro) {
    case "cidade":
      dados.descricao = document.getElementById("cidadeDescricao").value.trim();
      break;
    case "setor":
      dados.descricao = document.getElementById("setorDescricao").value.trim();
      break;
    case "carreta":
      dados.descricao = document.getElementById("carretaDescricao").value.trim();
      dados.placa = document.getElementById("carretaPlaca").value.trim();
      break;
    case "motorista":
      dados.descricao = document.getElementById("motoristaDescricao").value.trim();
      dados.id_setor = document.getElementById("motoristaSetor").value.trim();
      dados.id_cidade = document.getElementById("motoristaCidade").value.trim();
      break;
    case "cavalo":
      dados.tipo = document.getElementById("cavaloTipo").value.trim();
      dados.descricao = document.getElementById("cavaloDescricao").value.trim();
      dados.placa = document.getElementById("cavaloPlaca").value.trim();
      break;
    case "deposito":
      dados.descricao = document.getElementById("depositoDescricao").value.trim();
      break;
    case "fabrica":
      dados.descricao = document.getElementById("fabricaDescricao").value.trim();
      break;
    default:
      document.getElementById("mensagem").textContent = "Tipo de registro inválido.";
      return;
  }

  // Validação simples: verifica se todos os campos obrigatórios estão preenchidos
  for (let key in dados) {
    if (!dados[key]) {
      document.getElementById("mensagem").textContent = "Todos os campos são obrigatórios!";
      return;
    }
  }

  console.log("Enviando dados:", dados);

  fetch("http://localhost/LTD/GenericRegisters/cadastra.php", {
    method: "POST",
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json"
    },
    body: JSON.stringify(dados)
  })
    .then((response) => {
      if (!response.ok) throw new Error("Erro ao enviar dados para o servidor.");
      return response.json();
    })
    .then((data) => {
      console.log("Resposta do servidor:", data);
      document.getElementById("mensagem").textContent = data.mensagem;
      // Opcional: limpar o formulário e ocultar as seções
      document.getElementById("form").reset();
      document.querySelectorAll(".form-section").forEach(section => section.style.display = "none");
    })
    .catch((error) => {
      console.error("Erro:", error);
      document.getElementById("mensagem").textContent = "Erro: " + error.message;
    });
}
