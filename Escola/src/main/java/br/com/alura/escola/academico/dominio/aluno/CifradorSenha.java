package br.com.alura.escola.academico.dominio.aluno;

public interface CifradorSenha {
    String cifrarSenha(String senha);
    boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
