package br.com.nathaliaelen.gestao_vagas.modules.company.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AuthCompanyRequestDTO(
  @NotBlank(message = "O campo [username] é obrigatório.")
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço.")
  @Length(max = 50, message = "O campo [username] deve conter no máximo (50) caracteres.")
    String username,
        
  @NotBlank(message = "O campo [password] é obrigatório.")
  @Length(min = 8, max = 100, message = "O campo [password] deve conter entre (8) e (100) caracteres.")        
    String password
) {}
