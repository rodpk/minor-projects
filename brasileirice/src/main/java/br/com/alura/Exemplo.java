package br.com.alura;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

public class Exemplo {
    public static void main(String[] args) {
        CPFValidator validator = new CPFValidator();
        try{
            validator.assertValid("51720155232");
            CurrencyUnit moeda = Monetary.getCurrency("BRL");
            MonetaryAmount valorDaParcela = Money.of(900, moeda);
            System.out.println("Cobrança de : " + valorDaParcela);
        } catch(InvalidStateException ex){
            System.out.println("Atualize seus dados.\n" + ex);
        }
    }
}
