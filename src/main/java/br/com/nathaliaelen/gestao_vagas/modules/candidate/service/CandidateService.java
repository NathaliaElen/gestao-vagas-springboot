package br.com.nathaliaelen.gestao_vagas.modules.candidate.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.nathaliaelen.gestao_vagas.modules.candidate.dto.CandidateRequestDTO;
import br.com.nathaliaelen.gestao_vagas.modules.candidate.dto.CandidateResponseDTO;
import br.com.nathaliaelen.gestao_vagas.modules.candidate.entity.CandidateEntity;
import br.com.nathaliaelen.gestao_vagas.modules.candidate.exception.UserFoundException;
import br.com.nathaliaelen.gestao_vagas.modules.candidate.repository.CandidateRepository;

@Service
public class CandidateService {

  private final CandidateRepository candidateRepository;
  private final PasswordEncoder passwordEncoder;

  public CandidateService(CandidateRepository candidateRepository, PasswordEncoder passwordEncoder) {
    this.candidateRepository = candidateRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public CandidateResponseDTO create(CandidateRequestDTO dto) {
    var candidateExists = candidateRepository.findByUsernameOrEmail(dto.username(), dto.email());

    if (candidateExists.isPresent()) {
      throw new UserFoundException();
    }

    // Criando a entity a partir do DTO
    // Pegar os dados que chegaram pela API e colocando em um objeto que o JPA consegue persistir
    CandidateEntity candidate = new CandidateEntity();

    candidate.setName(dto.name());
    candidate.setUsername(dto.username());
    candidate.setEmail(dto.email());
    candidate.setPassword(dto.password());
    candidate.setDescription(dto.description());
    candidate.setCurriculum(dto.curriculum());

    // encode da senha
    var password = passwordEncoder.encode(candidate.getPassword());
    candidate.setPassword(password);

    // Apos criar a Entity, consigo usar o Repository para salvar o candidato
    var candidateSaved = candidateRepository.save(candidate);

    // Mas meu metodo precisa devolver ResponseDTO
    // Preciso transformar CandidateEntity -> CandidateResponseDTO
    return new CandidateResponseDTO(
      candidateSaved.getId(),
      candidateSaved.getName(),
      candidateSaved.getUsername(),
      candidateSaved.getEmail(),
      candidateSaved.getDescription(),
      candidateSaved.getCurriculum(),
      candidateSaved.getCreateAt()
    ); 
  }
  
}
