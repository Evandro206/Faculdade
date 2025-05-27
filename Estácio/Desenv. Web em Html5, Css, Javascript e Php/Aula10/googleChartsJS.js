google.charts.load('current', {'packages':['corechart']});
let valores = [];

const addValor = (x) => valores.push([valores.length + 1, x]);

const media = () => {
    let soma = 0;
    for(x of valores)
        soma += x[1];
    return soma / valores.length;
}

const drawBasic = () => {
    let data = new google.visualization.DataTable();
    data.addColumn('number', 'pos');
    data.addColumn('number', 'x');
    data.addRows(valores);
    let options = {hAxis: {title: 'Posição'}, vAxis: {title: 'Valor de X'}};

    let chart = new google.visualization.LineChart(document.getElementById("chart_div"));

    chart.draw(data, options);
}

const executar = () => {
    const x = eval(document.getElementById("v1").value)
    addValor(x);
    google.charts.setOnLoadCallback(drawBasic);
    document.getElementById("media").innerHTML = `Média: ${media()}`;
}