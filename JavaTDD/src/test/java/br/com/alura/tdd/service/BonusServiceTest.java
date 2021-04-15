package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        BonusService service = new BonusService();

        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now()
                                            , new BigDecimal("25000"))));
    }

    @Test
    public void bonusDeveriaSer10PorcentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo"
                , LocalDate.now()
                , new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.0"), bonus);
    }
    @Test
    public void bonusDeveriaSer10PorcentoParaSalarioDeDezMil(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo"
                , LocalDate.now()
                , new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.0"), bonus);
    }

}
