package br.com.nathaliaelen.gestao_vagas.modules.company.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nathaliaelen.gestao_vagas.exceptions.ErrorMessageDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.dtos.AuthCompanyRequestDTO;
import br.com.nathaliaelen.gestao_vagas.modules.company.services.AuthCompanyService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

  private final AuthCompanyService authCompanyService;

  public AuthCompanyController(AuthCompanyService authCompanyService) {
    this.authCompanyService = authCompanyService;
  }

  @PostMapping("/company")
  public ResponseEntity<?> create(@RequestBody @Valid AuthCompanyRequestDTO dto) {

    try {
      var authenticateCompany = this.authCompanyService.authenticateCompany(dto);

      return ResponseEntity.status(HttpStatus.OK).body(authenticateCompany);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorMessageDTO(e.getMessage(), null));
    }

  }
  
}
