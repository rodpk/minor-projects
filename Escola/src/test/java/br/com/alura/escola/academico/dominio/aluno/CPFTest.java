package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {



    @Test
    void naoDeveriaCriarCPFComNumerosInvalidos(){
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(null));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(""));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("12345678900"));
    }

    @Test
    void deveriaPermitirCriarCPFComNumeroValido(){
        String num = "123.456.789-00";
        CPF cpf = new CPF(num);
        assertEquals(num, cpf.getNumero());
    }

}