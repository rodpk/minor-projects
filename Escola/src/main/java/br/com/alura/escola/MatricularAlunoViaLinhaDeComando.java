package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.matricular.MatricularAlunoDto;
import br.com.alura.escola.gamificacao.GeraSeloAlunoNovato;
import br.com.alura.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {
    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@gmail.com";
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        publicador.adicionar(new GeraSeloAlunoNovato(new RepositorioDeSelosEmMemoria()));
        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
        matricular.executa(new MatricularAlunoDto(nome, cpf, email));
    }
}
