package br.com.nathaliaelen.gestao_vagas.modules.company.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nathaliaelen.gestao_vagas.exceptions.ErrorMessageDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.dtos.CompanyRequestDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.exceptions.CompanyFoundException;
import br.com.nathaliaelen.gestao_vagas.modules.company.services.CompanyService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

  private final CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @PostMapping 
  public ResponseEntity<Object> create(@RequestBody @Valid CompanyRequestDTO companyRequestDTO) {

    try {
      var companySaved = companyService.create(companyRequestDTO);

      return ResponseEntity.status(HttpStatus.CREATED).body(companySaved);
    } catch (CompanyFoundException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageDTO(e.getMessage(), null));
    } 

  }
  
}
