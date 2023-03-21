global = ""

function varGlobal() {
    global = "Eu sou uma váriavel global"
    console.log(global)
}

varGlobal()

function varIcamento() {
    var icamento = "Eu sou uma váriavel que sofre içamento"
    console.log(icamento)
}

var icamento = ""

varIcamento()

sombreamento = "valor inicial"
function varSombreamento() {
    sombreamento = "Valor sobrescrito"
    console.log(sombreamento)
}

varSombreamento()

const varConstante = "Valor constante"

console.log(varConstante)