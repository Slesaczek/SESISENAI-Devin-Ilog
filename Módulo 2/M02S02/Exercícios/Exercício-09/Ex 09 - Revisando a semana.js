let opcao = 0;
let quantidade = 0;
let quantidadeHorti = 0;
let quantidadeLaticinios = 0;
let quantidadeCarnes = 0;
let quantidadeAves = 0;
let quantidadePeixes = 0;
let maiorQuantidade = 0;
let produtocomMaiorQuantidade;

function informarQuantidade(qtd){
    let quantidade = parseInt(window.prompt("Informe a quantidade desejada:"))
    return quantidade;
}

while (opcao != 6){
opcao = parseInt(window.prompt(`Bem vindo, digite o NÚMERO do produto informado:
(1)Hortifruti
(2)Laticínios
(3)Carnes
(4)Peixes
(5)Aves
(6)Fechar pedido`))

switch (opcao){
    case 1:
        quantidadeHorti += parseInt(informarQuantidade(quantidade));
        break;
    case 2:
        quantidadeLaticinios += parseInt(informarQuantidade(quantidade));
        break;
    case 3:
        quantidadeCarnes += parseInt(informarQuantidade(quantidade));
        break;
    case 4:
        quantidadePeixes += parseInt(informarQuantidade(quantidade));
        break;
    case 5:
        quantidadeAves += parseInt(informarQuantidade(quantidade));
        break;
    }
}
let cestaDeCompras = [
    {produto:"HortiFruti", quantidade:(quantidadeHorti)},
    {produto: "Laticinios", quantidade:(quantidadeLaticinios)},
    {produto: "Carnes", quantidade:(quantidadeCarnes)},
    {produto: "Peixes", quantidade:(quantidadePeixes)},
    {produto: "Aves", quantidade:(quantidadeAves)},
]
for (const produto of cestaDeCompras) { 
    if (produto.quantidade > maiorQuantidade){
        produtocomMaiorQuantidade = produto.produto;
        maiorQuantidade = produto.quantidade;
    }
}
document.write(`O produto com maior quantidade foi ${produtocomMaiorQuantidade}, foi solicitado ${maiorQuantidade} unidades.`);