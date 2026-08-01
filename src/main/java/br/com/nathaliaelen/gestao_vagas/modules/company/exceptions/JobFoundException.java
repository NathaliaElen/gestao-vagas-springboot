package br.com.nathaliaelen.gestao_vagas.modules.company.exceptions;

public class JobFoundException extends RuntimeException {
  
  public JobFoundException() {
    super("Já existe uma vaga cadastrada com essa descrição e level para esta empresa.");
  }
  
}
