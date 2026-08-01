package br.com.nathaliaelen.gestao_vagas.modules.company.dtos;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import br.com.nathaliaelen.gestao_vagas.modules.company.enums.JobLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JobRequestDTO(
  @Length(max = 255, message = "O campo [description] deve conter no máximo (255) caracteres.")
    String description,
            
  @NotBlank(message = "O campo [benefits] é obrigatório.")
  @Length(max = 255, message = "O campo [benefits] deve conter no máximo (255) caracteres.")
    String benefits,
          
  @NotNull(message = "O campo [level] é obrigatório.")
    JobLevel level,
    
    UUID companyId
) {}
