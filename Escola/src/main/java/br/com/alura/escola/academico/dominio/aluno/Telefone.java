package br.com.alura.escola.academico.dominio.aluno;

public class Telefone {
    private String ddd;
    private String numero;

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    public Telefone(String ddd, String numero) {

        if(ddd == null || numero == null)
            throw new IllegalArgumentException("DDD e Numero são obrigatorios");

        if(!ddd.matches("\\d{2}"))
            throw new IllegalArgumentException("DDD Inválido!");

        if(!numero.matches("\\d{8}|\\d{9}"))
            throw new IllegalArgumentException("Numero inválido!");
        this.ddd = ddd;
        this.numero = numero;
    }
}
