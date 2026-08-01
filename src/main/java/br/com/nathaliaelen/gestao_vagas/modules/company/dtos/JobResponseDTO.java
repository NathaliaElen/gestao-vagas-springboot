package br.com.nathaliaelen.gestao_vagas.modules.company.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.nathaliaelen.gestao_vagas.modules.company.enums.JobLevel;

public record JobResponseDTO(
  UUID id,
  String description,
  String benefits,
  JobLevel level,
  UUID companyId,
  LocalDateTime createAt
) {}
