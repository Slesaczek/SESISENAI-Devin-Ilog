package Desafio1;
import java.util.*;

public class CalculadoraGorgeta {
    private float valorConta;
    private int percentual;

    public float calcularGorgeta(){
        return valorConta *  percentual / (100) ;
    }

    public float getValorConta() {
        return valorConta;
    }

    public void setValorConta(float valorConta) {
        this.valorConta = valorConta;
    }

    public Integer getPercentual() {
        return percentual;
    }

    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }
}
