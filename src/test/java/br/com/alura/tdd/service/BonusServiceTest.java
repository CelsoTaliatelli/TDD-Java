package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionariosComSalariosMuitoAlto(){
        BonusService service = new BonusService();
        /*assertThrows(IllegalArgumentException.class,
                () ->service.calcularBonus(new Funcionario("Celso", LocalDate.now(),new BigDecimal("25000"))));*/
        try {
            service.calcularBonus(new Funcionario("Celso", LocalDate.now(),new BigDecimal("25000")));
            fail("Não deu a excepion");
        }catch (Exception e){
            assertEquals("Funcionario com salario maior do que R$10000 não pode receber bonus",e.getMessage());
        }


    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus= service.calcularBonus(new Funcionario("Celso", LocalDate.now(),new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMilReais(){
        BonusService service = new BonusService();
        BigDecimal bonus= service.calcularBonus(new Funcionario("Celso", LocalDate.now(),new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}