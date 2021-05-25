package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        if(desempenho == Desempenho.A_DESEJAR){
           this.desempenhoADesejar(funcionario);
        }
        if(desempenho == Desempenho.BOM){
            this.desempenhoBom(funcionario);
        }
        if(desempenho == Desempenho.OTIMO){
            this.desempenhoOtimo(funcionario);
        }
    }

    public void desempenhoADesejar(Funcionario funcionario){
        BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
        funcionario.reajustarSalario(reajuste);
    }

    public void desempenhoBom(Funcionario funcionario){
        BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
        funcionario.reajustarSalario(reajuste);
    }

    public void desempenhoOtimo(Funcionario funcionario){
        BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
        funcionario.reajustarSalario(reajuste);
    }
}
