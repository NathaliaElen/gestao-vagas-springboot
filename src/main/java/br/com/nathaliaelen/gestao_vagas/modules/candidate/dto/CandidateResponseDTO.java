package br.com.nathaliaelen.gestao_vagas.modules.candidate.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CandidateResponseDTO(
  UUID id,
  String name,
  String username,
  String email,
  String description,
  String curriculum,
  LocalDateTime createAt
) {}
