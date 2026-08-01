package br.com.nathaliaelen.gestao_vagas.modules.candidate.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CandidateRequestDTO(
  @NotBlank(message = "O campo [name] é obrigatório.")
  @Length(max = 100, message = "O campo [name] deve conter no máximo (100) caracteres.")
    String name,
      
  @NotBlank(message = "O campo [username] é obrigatório.")
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço.")
  @Length(max = 50, message = "O campo [username] deve conter no máximo (50) caracteres.")
    String username,
      
  @NotBlank(message = "O campo [email] é obrigatório.")
  @Length(max = 50, message = "O campo [email] deve conter no máximo (50) caracteres.")
  @Email(message = "O campo [email] deve conter um e-mail válido.")
    String email,
      
  @NotBlank(message = "O campo [password] é obrigatório.")
  @Length(min = 8, max = 100, message = "O campo [password] deve conter entre (8) e (100) caracteres.")
    String password,
      
  @Length(max = 255, message = "O campo [description] deve conter no máximo (255) caracteres.")
    String description,
        
  @Length(max = 255, message = "O campo [curriculum] deve conter no máximo (255) caracteres.")
    String curriculum
) {}
