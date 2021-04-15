package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;


    @Before
    public void inicializar(){
        System.out.println("Inicializando.");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @After
    public void finalizar(){
        System.out.println("Finalizando...");
    }

    @BeforeClass
    public static void antesDeTodos(){
        System.out.println("Rodando antes de todos...");
    }

    @AfterClass
    public static void depoisDeTodos(){
        System.out.println("Rodando depois de todos..");
    }

    @Test
    public void reajusteDeveriaSerTresPorcentoQuandoDesempenhoForADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerQuinzePorcentoQuandoDesempenhoForBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerVintePorcentoQuandoDesempenhoForOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
