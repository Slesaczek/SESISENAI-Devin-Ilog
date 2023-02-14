const alunos = [
    {
        nome: 'Luis Carlos Elias',
        mediaFinal: 7.0,
    },
{
        nome: 'Juliana Silva',
        mediaFinal: 8.5,
    },
{
        nome: 'Pedro Pascal',
        mediaFinal: 5.5,
    },
{
        nome: 'Ana Santos',
        mediaFinal: 6.5,
    }
];

const mediaFinal = alunos.reduce(function (mediaNotas,aluno) { return mediaNotas + aluno.mediaFinal / alunos.length },0); console.log(mediaFinal);
