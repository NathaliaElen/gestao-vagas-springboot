package br.com.nathaliaelen.gestao_vagas.modules.company.services;

import org.springframework.stereotype.Service;

import br.com.nathaliaelen.gestao_vagas.modules.company.dtos.CompanyRequestDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.dtos.CompanyResponseDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.nathaliaelen.gestao_vagas.modules.company.exceptions.CompanyFoundException;
import br.com.nathaliaelen.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CompanyService {

  private final CompanyRepository companyRepository;

  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  // criar uma company
  public CompanyResponseDTO create(CompanyRequestDTO dto) {
    var companyExists = companyRepository.findByUsernameOrEmail(dto.username(), dto.email());

    if (companyExists.isPresent()) {
      throw new CompanyFoundException();
    }

    // Criando a entity a partir do DTO
    // Pegar os dados que chegaram pela API e colocando em um objeto que o JPA consegue persistir
    CompanyEntity company = new CompanyEntity();

    company.setName(dto.name());
    company.setCnpj(dto.cnpj());
    company.setUsername(dto.username());
    company.setEmail(dto.email());
    company.setPassword(dto.password());
    company.setWebsite(dto.website());
    company.setDescription(dto.description());

    // Apos criar a Entity, consigo usar o Repository para salvar a company
    var companySaved = companyRepository.save(company);

    // Mas meu método precisa devolver ResponseDTO
    // Preciso transformar CompanyEntity -> CompanyResponseDTO
    return new CompanyResponseDTO(
      companySaved.getId(),
      companySaved.getName(),
      companySaved.getCnpj(),
      companySaved.getUsername(),
      companySaved.getEmail(),
      companySaved.getWebsite(),
      companySaved.getDescription(),
      companySaved.getCreateAt()
    );
  }
  
}
