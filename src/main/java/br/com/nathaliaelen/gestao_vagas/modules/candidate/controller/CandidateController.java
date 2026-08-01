package br.com.nathaliaelen.gestao_vagas.modules.candidate.controller;

import br.com.nathaliaelen.gestao_vagas.modules.candidate.service.CandidateService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nathaliaelen.gestao_vagas.exceptions.ErrorMessageDTO;
import br.com.nathaliaelen.gestao_vagas.modules.candidate.dto.CandidateRequestDTO;
import br.com.nathaliaelen.gestao_vagas.modules.candidate.exception.UserFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  private final CandidateService candidateService;

  public CandidateController(CandidateService candidateService) {
    this.candidateService = candidateService;
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody @Valid CandidateRequestDTO candidateRequestDTO) {
    
    try {
      var candidateSaved = candidateService.create(candidateRequestDTO);

      return ResponseEntity.status(HttpStatus.CREATED).body(candidateSaved);
    } catch (UserFoundException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageDTO(e.getMessage(), null));
    }
    
  }
  
}
