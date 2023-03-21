
var number1 = window.prompt("Digite um número:");

number1 = number1.replace(',', '.');  

if(number1%2===0.00){
    document.write("<h3>Par</h3>");    
} else {    
    document.write("<h3>Ímpar</h3>");
}   
