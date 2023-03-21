let tabela = document.getElementById("tabela");
const playlist = [
    {
        nome: "Listen to your heart",
        cantor:"Roxette"
    },
    {
        nome: "Bloody Mary",
        cantor:"Lady Gaga"
    },
    {
        nome: "Bones",
        cantor:"Imagine Dragons"
    },
    {
        nome: "Sugar honey ice and tea",
        cantor:"Bring me the horizon"
    },
    {
        nome: "Rock you like a hurricane",
        cantor:"Scorpions"
    },
    {
        nome: "Pure/Honey",
        cantor:"Beyoncé"
    },
];
let playlistString = JSON.stringify(playlist);

localStorage.setItem("Playlist", playlistString);

let playlistStringParse = JSON.parse(localStorage.getItem("Playlist"));

for (let i = 0; i < playlistStringParse.length; i++) {
    tabela.innerHTML +=
    `<tr>
    <td>${playlistStringParse[i].nome}</td>
    <td>${playlistStringParse[i].cantor}</td>
    </tr>`
}