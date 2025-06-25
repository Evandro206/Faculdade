// Evandro Machado - 202405306147
// Paulo Otavio Duarte Rocha - 202402265385

const vetorTarefas = [];

const adicionarTarefa = () =>{
    const containerTarefa = document.getElementById("novaTarefa").value;
    if(containerTarefa == ""){
        alert("O campo de adcionar tarefas não pode estar em branco, digite algo valido! ");
        return;
    };
    vetorTarefas.push(containerTarefa); 
    printdastarefas();  
}

const excluirTarefa = () =>{
    const numero = prompt("Digite o índice da tarefa a ser removida: ");
    if(numero == ""){
        alert("Digite um numero, o campo não pode estar em branco ");
        return;
    };
    if(isNaN(numero)){
        alert("Digite um numero, não pode ser uma letra ");
        return;
    };
    if(numero > vetorTarefas.length){
        alert("O numero digitado, não corresponde a um indice ");
        return;
    };
    vetorTarefas.splice(numero-1,1);
    printdastarefas();
}


const excluirTodasTarefas = () =>{
    vetorTarefas.splice(0,vetorTarefas.length);
    printdastarefas();
}

const printdastarefas = () =>{
    const listasTarefas = document.getElementById("listaDeTarefas");
    listasTarefas.innerHTML = "";
    for (let i = 0; i < vetorTarefas.length;i++) {
        listasTarefas.innerHTML +=`${i+1} - ${vetorTarefas[i]} <br>`;
    };
}