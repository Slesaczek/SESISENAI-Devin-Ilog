class Aluno {
    constructor(nome, cpf, codTurma) {
        this.nome = nome
        this.cpf = cpf
        this.codTurma = codTurma
    }
    getNome() {
        return this.nome
    };  
    getCpf() {
        return this.cpf
    };
    getCodTurma() {
        return this.codTurma
    };
    imprimeDados() {
        console.log(this.nome, this.cpf, this.codTurma)
    };
}

let aluno = new Aluno("César", 490, 03)

aluno.imprimeDados()