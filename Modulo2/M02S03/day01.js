//Capturando tags html
// getElementsByTagName
let tagsP = document.getElementsByTagName('p'); //retorna um HTMLCollection
console.log(tagsP);
//Metodos para capturar o texto interno a tag na posição 0
console.log(tagsP[0].textContent);
console.log(tagsP[0].innerText);
console.log(tagsP[0].innerHTML);

// getElementsByClassName
let tagsWithClass = document.getElementsByClassName("byClassName");
console.log(tagsWithClass);

// getElementById
let byId = document.getElementById("byId");
console.log(byId);


// querySelector e querySelectorAll
let selector1 = document.querySelector("h1#byId");
let selector2 = document.querySelectorAll("div .box form p");
console.log(selector1);
console.log(selector2);


//.value e .attributes
let input = document.getElementById("nome");
console.log(input.value); //retorna apenas o atributo value
console.log(input.placeholder); //Também é possível capturar vários outros atributos
console.log(input.attributes); //retorna uma lista com todos atributos daquela tag