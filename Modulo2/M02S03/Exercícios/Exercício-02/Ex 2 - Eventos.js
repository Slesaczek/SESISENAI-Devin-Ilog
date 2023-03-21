var num1 = document.getElementById("num1")
var num2 = document.getElementById("num2")
var resultado;

function Somar(){
    resultado = parseFloat(num1.value) + parseFloat(num2.value);    
    document.getElementById('txtResultado').setAttribute("value", resultado);
 }

 function Subtrair(){
    resultado = parseFloat(num1.value) - parseFloat(num2.value);    
    document.getElementById('txtResultado').setAttribute("value", resultado);
 }
