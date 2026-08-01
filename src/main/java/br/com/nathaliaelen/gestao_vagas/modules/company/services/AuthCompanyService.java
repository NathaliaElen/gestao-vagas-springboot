package br.com.nathaliaelen.gestao_vagas.modules.company.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.nathaliaelen.gestao_vagas.modules.company.dtos.AuthCompanyRequestDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.exceptions.CompanyNotFoundException;
import br.com.nathaliaelen.gestao_vagas.modules.company.exceptions.InvalidCredentialsException;
import br.com.nathaliaelen.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyService {

  private final CompanyRepository companyRepository;
  private final PasswordEncoder passwordEncoder;

  public AuthCompanyService(CompanyRepository companyRepository, PasswordEncoder passwordEncoder) {
    this.companyRepository = companyRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public void authenticateCompany(AuthCompanyRequestDTO dto) {
    var companyExists = companyRepository.findByUsername(dto.username()).orElseThrow(() -> {
      throw new CompanyNotFoundException();
    });

    // se empresa existe, verificar se senhas sao iguais
    // senha que o usuario passou = senha cadastrada no banco de dados
    var passwordMatches = this.passwordEncoder.matches(dto.password(), companyExists.getPassword());

    // se nao for igual -> Erro
    if (!passwordMatches) {
      throw new InvalidCredentialsException();
    }
    // Se for igual -> Gerar o Token
  }
  
}
