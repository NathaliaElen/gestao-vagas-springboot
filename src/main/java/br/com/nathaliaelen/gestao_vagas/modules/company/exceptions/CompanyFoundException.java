package br.com.nathaliaelen.gestao_vagas.modules.company.exceptions;

public class CompanyFoundException extends RuntimeException {

  public CompanyFoundException() {
    super("Empresa já existe!");
  }
  
}
