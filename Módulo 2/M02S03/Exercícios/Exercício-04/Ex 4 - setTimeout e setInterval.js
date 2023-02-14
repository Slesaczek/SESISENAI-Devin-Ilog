let contador = document.getElementById("time");
function atualizaContador() {
  parseInt((contador.innerHTML = contador.innerText - 1 + `<br>`));
}
function zerarContador() {
  parseInt((contador.innerHTML = 0));
  clearInterval(interval);
  clearTimeout(timeOut);
}
const timeOut = setTimeout(zerarContador, 30000);
const interval = setInterval(atualizaContador, 1000);