package br.com.alura;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.TituloEleitoralFormatter;
import br.com.caelum.stella.validation.*;

public class ValidacaoDocumento {
    public static void main(String[] args) {
        String[] tipo = {"CPF", "CNPJ", "Titulo de Eleitor"};

        String cpf = "49290090812";
        validarDocumentos(new CPFValidator(), cpf, tipo[0]);

        String cnpj = "36106480000117";
        validarDocumentos(new CNPJValidator(), cnpj, tipo[1]);

        String tituloEleitor = "747162740132";
        validarDocumentos(new TituloEleitoralValidator(), tituloEleitor, tipo[2]);
    }

    private static void validarDocumentos(Validator<String> validador, String documento, String tipo) {

        try {
            validador.assertValid(documento);
            String formatado = null;

            switch (tipo) {
                case "CPF":
                    formatado = new CPFFormatter().format(documento);
                    break;
                case "CNPJ":
                    formatado = new CNPJFormatter().format(documento);
                    break;
                case "Titulo de Eleitor":
                    formatado = new TituloEleitoralFormatter().format(documento);
                    break;
            }
            System.out.println("O " + tipo + ": " + formatado + " é válido");
        } catch (InvalidStateException ex) {
            System.out.println("O " + tipo + ": " + documento + " é inválido\n" + ex);
        }
    }
}
