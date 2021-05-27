package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        System.out.println("Inicializar");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Celso", LocalDate.now(),new BigDecimal("1000.00"));
    }

    @AfterEach
    private void finalizar(){
        System.out.println("Fim");
    }

    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("Antes de Todos");
    }

    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("depois de Todos");
    }

    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar(){
       //inicializar();
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom(){
       //inicializar();
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo(){
       //inicializar();
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }
}
