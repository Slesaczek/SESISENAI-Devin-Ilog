const jogadoresSelecao94 = [
  {
      nome: 'Taffarel',
      posicao: 'Goleiro',
  },
  {
      nome: 'Jorginho',
      posicao: 'Lateral Direito',
  },
  {
      nome: 'Ricardo Rocha',
      posicao: 'Zagueiro',
  },
  {
      nome: 'Mauro Silva',
      posicao: 'Volante',
  },
  {
      nome: 'Bebeto',
      posicao: 'Atacante',
  },
  {
      nome: 'Romário',
      posicao: 'Atacante',
  },
  {
      nome: 'Dunga',
      posicao: 'Volante',
  },
];

const nomesJogadores = jogadoresSelecao94.map(function (jogadorSelecao94) {
  return jogadorSelecao94.nome
})

console.log(nomesJogadores)
