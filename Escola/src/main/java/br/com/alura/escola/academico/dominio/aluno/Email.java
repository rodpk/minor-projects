package br.com.alura.escola.academico.dominio.aluno;

public class Email {
    // VALUE OBJECT - NÃO TEM DIFERENCIAÇÃO
    private String endereco;

    public String getEndereco() {
        return endereco;
    }

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            throw new IllegalArgumentException("E-mail inválido!");
        }
        this.endereco = endereco;
    }


    @Override
    public String toString() {
        return "Email{" +
                "endereco='" + endereco + '\'' +
                '}';
    }
}
