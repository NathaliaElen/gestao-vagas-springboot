package br.com.nathaliaelen.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.nathaliaelen.gestao_vagas.modules.company.enums.JobLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class JobEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(length = 255)
  private String description;

  @Column(nullable = false, length = 255)
  private String benefits;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private JobLevel level;

  @CreationTimestamp
  @Column(updatable = false, nullable = false, name = "create_at")
  private LocalDateTime createAt;
  
}
