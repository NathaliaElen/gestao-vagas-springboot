package br.com.nathaliaelen.gestao_vagas.modules.candidate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nathaliaelen.gestao_vagas.modules.candidate.entity.CandidateEntity;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
  
}
