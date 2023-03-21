var nomeAluno;
let array =[];
var i = 1;
var  media = 0;

while (i <= 4) {
    if(!nomeAluno){
        nomeAluno = window.prompt("Informe o nome do aluno:");        
    }
    let nota = parseInt(window.prompt(`Informe a nota do ${i}° bimestre:`));
    array.push(nota);
    i++;
}

for(i = 0; i<array.length; i++){
    media+=array[i];  
}

document.write(`Nome: ${nomeAluno}<br>`);
document.write(`Média:${media/array.length}<br>`);

if(media / array.length>=7){    
    document.write("Aprovado");
} else{
    document.write("Reprovado");
}
