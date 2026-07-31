package br.com.nathaliaelen.gestao_vagas.modules.candidate.exception;

public class UserFoundException extends RuntimeException {

  public UserFoundException() {
    super("Usuário já existe!");
  }
  
}
