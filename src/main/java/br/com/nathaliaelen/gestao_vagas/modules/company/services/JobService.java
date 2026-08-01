package br.com.nathaliaelen.gestao_vagas.modules.company.services;

import org.springframework.stereotype.Service;

import br.com.nathaliaelen.gestao_vagas.modules.company.dtos.JobRequestDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.dtos.JobResponseDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.entities.JobEntity;
import br.com.nathaliaelen.gestao_vagas.modules.company.exceptions.CompanyNotFoundException;
import br.com.nathaliaelen.gestao_vagas.modules.company.repositories.CompanyRepository;
import br.com.nathaliaelen.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class JobService {

  private final JobRepository jobRepository;
  private final CompanyRepository companyRepository;

  public JobService(JobRepository jobRepository, CompanyRepository companyRepository) {
    this.jobRepository = jobRepository;
    this.companyRepository = companyRepository;
  }

  public JobResponseDTO create(JobRequestDTO dto) {

    var company = companyRepository.findById(dto.companyId());

    if (company.isEmpty()) {
      throw new CompanyNotFoundException();
    }

    // Criando a entity a partir do DTO
    // Pegar os dados que chegaram pela API e colocando em um objeto que o JPA consegue persistir
    JobEntity job = new JobEntity();

    job.setDescription(dto.description());
    job.setBenefits(dto.benefits());
    job.setLevel(dto.level());
    job.setCompanyEntity(company.get());

    // Apos criar a Entity, consigo usar o Repository para salvar a company
    var jobSaved = jobRepository.save(job);

    // Mas meu método precisa devolver ResponseDTO
    // Preciso transformar JobEntity -> JobResponseDTO
    return new JobResponseDTO(
      jobSaved.getId(),
      jobSaved.getDescription(),
      jobSaved.getBenefits(),
      jobSaved.getLevel(),
      jobSaved.getCompanyEntity().getId(),
      jobSaved.getCreateAt()
    );
  }
  
}
