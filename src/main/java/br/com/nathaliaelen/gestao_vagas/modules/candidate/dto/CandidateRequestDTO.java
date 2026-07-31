package br.com.nathaliaelen.gestao_vagas.modules.candidate.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CandidateRequestDTO(
  @NotBlank(message = "O campo [name] é obrigatório.")
    String name,
      
  @NotBlank(message = "O campo [username] é obrigatório.")
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço.")
    String username,
      
  @NotBlank(message = "O campo [email] é obrigatório.")
  @Email(message = "O campo [email] deve conter um e-mail válido.")
    String email,
      
  @NotBlank(message = "O campo [password] é obrigatório.")
  @Length(min = 8, max = 100, message = "O campo [password] deve conter entre (8) e (100) caracteres.")
    String password,
      
    String description,
    String curriculum
) {}
