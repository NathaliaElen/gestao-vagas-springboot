package br.com.nathaliaelen.gestao_vagas.modules.company.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nathaliaelen.gestao_vagas.exceptions.ErrorMessageDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.dtos.JobRequestDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.exceptions.CompanyNotFoundException;
import br.com.nathaliaelen.gestao_vagas.modules.company.services.JobService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

  private final JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @PostMapping 
  public ResponseEntity<Object> create(@RequestBody @Valid JobRequestDTO jobRequestDTO) {

    try {
      var jobSaved = jobService.create(jobRequestDTO);

      return ResponseEntity.status(HttpStatus.CREATED).body(jobSaved);

    } catch (CompanyNotFoundException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageDTO(e.getMessage(), null));
    }
    
  }
  
}
