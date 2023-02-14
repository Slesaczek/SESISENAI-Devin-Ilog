
const playlist = [
  {
      musica: "Listen to your heart",
      cantor:"Roxette",
  },
  {
      musica: "Bloody Mary",
      cantor:"Lady Gaga"
  },
  {
      musica: "Bones",
      cantor:"Imagine Dragons"
  },
  {
      musica: "Sugar honey ice and tea",
      cantor:"Bring me the horizon"
  },
  {
      musica: "Rock you like a hurricane",
      cantor:"Scorpions"
  },
  {
      musica: "Pure/Honey",
      cantor:"Beyoncé"
  }]
  
  
let playlistLocal = document.getElementById("tabela")  

playlist.forEach(element => 
  localStorage.setItem(element.musica, element.cantor))


function updateTable() {
  playlistLocal.innerHTML = ""
  for (var i = 0; i < localStorage.length; i++) {
      let key = localStorage.key(i)
      playlistLocal.innerHTML += 
          `<tr>
          <td>${key}</td>
          <td>${localStorage.getItem(key)}</td>
          <td class="lastColumn"><button id="${key}" class="excluir">Excluir</button></td>
          </tr>`
  }
  DeleteRow()       
}

function DeleteRow() {
  
  document.querySelectorAll("button").forEach( function(button) {
      
      button.addEventListener("click", function(event) {
          const el = event.target.id
          localStorage.removeItem(el)
          updateTable()
      });
  });
}

updateTable()