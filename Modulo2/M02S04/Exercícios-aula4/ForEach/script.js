//ForEach
const numeros = [1,3,5,7,9,11,13,15];

for(let index = 0; index < numeros.length; index++){
    console.log(numeros[index]);
}

for (const numero of numeros) {
    console.log("For of:",numero);
}

numeros.forEach(function (numero){
    console.log('For each:',numero);
})

const pessoas = [{ nome: 'Luis', idade: 45 }, { nome: 'Karina', idade: 43 }, { nome: 'Pedro', idade: 12 }, { nome: 'João', idade: 6 }]

for (let index = 0; index < pessoas.length; index++) {
    console.log('for convencional:', `Meu nome é ${pessoas[index].nome} e tenho ${pessoas[index].idade} anos`);
}

for (const pessoa of pessoas) {
    console.log('for of:', `Meu nome é ${pessoa.nome} e tenho ${pessoa.idade} anos`);
}

pessoas.forEach(function (pessoa) {
    console.log('forEach function:', `Meu nome é ${pessoa.nome} e tenho ${pessoa.idade} anos`);
})

//outra codificação usando arrow function
pessoas.forEach(pessoa => console.log('forEach arrow function:', `Meu nome é ${pessoa.nome} e tenho ${pessoa.idade} anos`))

const gruposDeNumeros =  [[1,2,3,4,5], [6,7,8,9,10], [11,12,13,14,15]];

gruposDeNumeros.forEach(function(grupo) {
    grupo.forEach(function (numero) {
        console.log('function:', numero)
    });
})

//outra codificação usando arrow function
gruposDeNumeros.forEach(grupo => grupo.forEach(numero => console.log('arrow function:', numero)));

const numeros =  [1,3,5,7,9,11,13,15];

numeros.forEach(function (numero, indice) {
    console.log('function', `valor ${numero} na posição do array ${indice}`);
})

//outra codificação usando arrow function
numeros.forEach((numero, indice) => console.log('arrow function', `valor ${numero} na posição do array ${indice}`))

