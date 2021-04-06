package br.com.alura.escola.academico.aplicacao.matricular;

import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido(){

        // MOCK -> Mockito
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.publicar((Evento) new LogDeAlunoMatriculado());
        MatricularAluno useCase = new MatricularAluno(repositorio, publicador);
        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano", "123.456.789-99", "fulaninho@gmail.com");
        useCase.executa(dados);

        Aluno encontrado = repositorio.buscarPorCpf(new CPF("123.456.789-99"));

        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.789-99", encontrado.getCpf());
        assertEquals("fulaninho@gmail.com", encontrado.getEmail());

    }

}