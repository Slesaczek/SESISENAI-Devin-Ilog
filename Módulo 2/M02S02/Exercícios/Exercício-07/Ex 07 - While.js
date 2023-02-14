let avaliacao;
let avaliacaoRuins = 0;
let i = 0;

while (i < 4) {
    avaliacao = window.prompt("Qual sua nota para a série Stranger Things (Ruim, Bom ou Excelente)?");
  if(avaliacao=="ruim"){
    avaliacaoRuins++;
  }
  i++;
}
document.write(`Foram dadas ${avaliacaoRuins} avaliações ruins.`);

