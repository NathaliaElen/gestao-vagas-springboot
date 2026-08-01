package br.com.nathaliaelen.gestao_vagas.modules.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nathaliaelen.gestao_vagas.modules.company.entities.JobEntity;
import java.util.List;
import br.com.nathaliaelen.gestao_vagas.modules.company.enums.JobLevel;


public interface JobRepository extends JpaRepository<JobEntity, UUID> {
  
  List<JobEntity> findByLevel(JobLevel level);
  
}
