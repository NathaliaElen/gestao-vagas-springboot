package br.com.nathaliaelen.gestao_vagas.modules.company.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record CompanyResponseDTO(
  UUID id,
  String name,
  String cnpj,
  String username,
  String email,
  String website,
  String description,
  LocalDateTime createAt
) {}
