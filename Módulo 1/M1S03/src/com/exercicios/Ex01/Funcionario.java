package com.exercicios.Ex01;

public class Funcionario {

        String cpf;
        String nomeCompleto;
        float salario;

        public void promover(float percentual){
            this.salario += this.salario * (percentual/100);
        }
}
