let mensagem = document.getElementById("mensagem")
let show = document.getElementById("show")
let showLS = document.getElementById("showLocalStorage")
let indexAdd = 0
let teste = 1

function saveMessage() {
    if (!mensagem.value){
    alert("Campo vazio, adicione um texto!")
    return
    }
    localStorage.setItem(`${teste}`, mensagem.value)
    teste++
}

function indexMessageSave(){
    let index = localStorage.length
    index += 1
    return index
}

function indexMessageAdd(){
    indexAdd += 1
    return indexAdd
}

function addMessage(){
    show.innerHTML += `Mensagem Nº ${indexMessageAdd()} ${mensagem.value}<br>`
}


var arr = []

function loadMessage(Element) {
    
    arr[Element] = localStorage.getItem(Element)

}



function getMessage(){

    if(localStorage.length === 0){
        alert("Não há itens salvos")
        return
    }
    
    Object.keys(localStorage).forEach(Element =>
        
        loadMessage(Element)
    )    
    
    arr.sort

    for (index = 1; index < arr.length; index++){
        showLS.innerHTML += `Mensagem Nº ${index}: ${arr[index]}<br>`
    }

    

}