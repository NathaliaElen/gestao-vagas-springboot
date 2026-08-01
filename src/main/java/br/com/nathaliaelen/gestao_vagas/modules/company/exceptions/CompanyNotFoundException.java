package br.com.nathaliaelen.gestao_vagas.modules.company.exceptions;

public class CompanyNotFoundException extends RuntimeException {

  public CompanyNotFoundException() {
    super("Empresa não encontrada!");
  }
  
}
