package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;
//AGGREGATE ROOT
public class Aluno { // dominio deve ser desacoplado da infra
    private CPF cpf;
    private String nome;
    private String senha;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }


    public List<Telefone> getTelefones() {
        return telefones;
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }


    public void adicionarTelefone(String ddd, String numero){
        if(telefones.size() == 2)
            throw new IllegalArgumentException("Número máximo de telefones atingido");
        this.telefones.add(new Telefone(ddd, numero));
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", email=" + email +
                ", telefones=" + telefones +
                '}';
    }
}
