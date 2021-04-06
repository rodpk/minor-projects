package br.com.alura;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

import java.math.BigDecimal;

public class NumeroPorExtenso {
    public static void main(String[] args) {
        NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
        BigDecimal valor = new BigDecimal("75.300");

        System.out.println(conversor.toWords(valor.doubleValue()));
    }
}
