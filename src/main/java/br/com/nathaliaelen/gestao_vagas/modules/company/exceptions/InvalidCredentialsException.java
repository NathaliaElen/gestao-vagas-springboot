package br.com.nathaliaelen.gestao_vagas.modules.company.exceptions;

public class InvalidCredentialsException extends RuntimeException {

  public InvalidCredentialsException() {
    super("Usuário ou senha inválidos.");
  }
  
}
