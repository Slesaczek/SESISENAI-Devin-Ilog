

let peso = parseInt(window.prompt("Digite seu peso:"));
let altura = parseFloat(window.prompt("Digite sua altura:(Exemplo 1.90)"));
let imc;


function IMC(peso, altura){  
    imc = peso / (altura * altura);    
}

IMC(peso, altura);


if (imc >= 25){
    window.alert(`Seu IMC é de ${imc.toFixed(2)}, você está acima do peso, procure um nutricionista.`)
} else if ( imc <=24.9 &&  imc >= 18.5){
    window.alert(`Seu IMC é de ${imc}, PARABÉNS! Você está no peso ideal.`)
} else if (imc > 0 && imc < 18.5){
    window.alert(`Seu IMC é de ${imc}, você está abaixo do peso, procure um nutricionista.`)
} else if (imc < 0){
    window.alert(`Refaça o teste novamente. Seu IMC abaixo de 0.`)
}


