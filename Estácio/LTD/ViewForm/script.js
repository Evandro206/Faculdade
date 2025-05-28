document.addEventListener("DOMContentLoaded", function() {
  document.getElementById('ok').addEventListener('click', function(event) {
    event.preventDefault(); // Evita redirecionamento indesejado
    const option = document.getElementById('option').value;
    let days;

    if (option === "") {
      alert('Selecione uma opção válida.');
      return;
    }

    switch(option) {
      case '1':
        days = 45;
        break;
      case '2':
        days = 30;
        break;
      case '3':
        days = 15;
        break;
      case '4':
        days = 0;
        break;
      default:
        alert('Selecione uma opção válida.');
        return;
    }

    fetch(`http://localhost/LTD/ViewForm/form.php?days=${days}`)
      .then(response => {
        if (!response.ok) {
          throw new Error(`Erro na resposta do servidor: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        console.log(data); // Processa os dados recebidos
        displayData(data);
      })
      .catch(error => console.error('Erro ao buscar dados:', error));
  });
});

function displayData(data) {
  // Remove tabela anterior se existir
  const oldTable = document.getElementById('dataTable');
  if (oldTable) {
    oldTable.remove();
  }
  
  // Cria a nova tabela
  const table = document.createElement('table');
  table.id = 'dataTable';
  table.innerHTML = `
    <tr>
      <th>ID_VIAGEM</th>
      <th>ID_MOTORISTA</th>
      <th>ID_CAVALO</th>
      <th>ID_CARRETA</th>
      <th>ID_DEPOSITO</th>
      <th>ID_FABRICA</th>
      <th>DATA_SAIDA</th>
      <th>HORA_SAIDA</th>
      <th>DATA_CHEGADA</th>
      <th>HORA_CHEGADA</th>
      <th>DIARIA</th>
      <th>ATUALIZADO</th>
      <th>TRECHOS</th>
      <th>PARADAS</th>
    </tr>
  `;

  data.forEach(row => {
    const tr = document.createElement('tr');
    Object.values(row).forEach(value => {
      const td = document.createElement('td');
      td.textContent = value;
      tr.appendChild(td);
    });
    table.appendChild(tr);
  });

  document.body.appendChild(table);
}