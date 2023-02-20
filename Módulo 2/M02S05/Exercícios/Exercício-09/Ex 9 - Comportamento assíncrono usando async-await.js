async function fakeAPIFilmes(idRequisição) {
  const filmes = {
    1: "matrix",
    2: "O poderoso Chefão",
    3: "A espera de um milagre",
    4: "O clube da luta",
    5: "Coração valente",
    6: "O rei leão",
    7: "Forrest Gump - O Contador de Histórias",
    8: "Os bons companheiros",
    9: "O irlândes",
    10: "Um sonho de liberdade",
  };

  const tempoDeResposta = Math.random() * 1000;
  return new Promise(function (sucesso) {
    setTimeout(() => sucesso(filmes[idRequisição]), tempoDeResposta);
  });
}

const reqs = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

async function listarFilmesId() {
  for (const req of reqs) {
    const resultado = await fakeAPIFilmes(req)
    console.log(req, resultado);
  }
}

listarFilmesId()