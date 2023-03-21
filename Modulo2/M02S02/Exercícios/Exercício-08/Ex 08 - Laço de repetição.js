let numero;
let vezes;


numero = parseInt(prompt("Digite um número para construir uma tabuada:"));
vezes = parseInt(prompt("Até quantas vezes:"));


for(let i = 1; i <= vezes; i++){
    document.write(`${numero} x ${i} = ${numero*i}<br>`);    
}