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

for (let i = 0; i < playlist.length; i++) {
    tabela.innerHTML +=
    `<tr>
    <td>${playlist[i].nome}</td>
    <td>${playlist[i].cantor}</td>
    </tr>`
}