package br.com.nathaliaelen.gestao_vagas.modules.company.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.nathaliaelen.gestao_vagas.modules.company.dtos.AuthCompanyRequestDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.dtos.AuthCompanyResponseDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.exceptions.CompanyNotFoundException;
import br.com.nathaliaelen.gestao_vagas.modules.company.exceptions.InvalidCredentialsException;
import br.com.nathaliaelen.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyService {

  @Value("${security.token.secret}")
  private String secretKey;

  private final CompanyRepository companyRepository;
  private final PasswordEncoder passwordEncoder;

  public AuthCompanyService(CompanyRepository companyRepository, PasswordEncoder passwordEncoder) {
    this.companyRepository = companyRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public AuthCompanyResponseDTO authenticateCompany(AuthCompanyRequestDTO dto) {
    var companyExists = companyRepository.findByUsername(dto.username()).orElseThrow(() -> {
      throw new CompanyNotFoundException();
    });

    // se empresa existe, verificar se senhas são iguais
    // senha que o usuário passou = senha cadastrada no banco de dados
    var passwordMatches = this.passwordEncoder.matches(dto.password(), companyExists.getPassword());

    // se não for igual -> Erro
    if (!passwordMatches) {
      throw new InvalidCredentialsException();
    }
    // Se for igual -> Gerar o Token
    Algorithm algorithm = Algorithm.HMAC256(secretKey);
    var token = JWT.create().withIssuer("javagas")
        .withSubject(companyExists.getId().toString())
        .sign(algorithm);
    
        return new AuthCompanyResponseDTO(token, "Bearer");
  }
  
}
