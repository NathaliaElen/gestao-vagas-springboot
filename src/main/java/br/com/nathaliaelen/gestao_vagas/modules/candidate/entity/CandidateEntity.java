package br.com.nathaliaelen.gestao_vagas.modules.candidate.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CandidateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(nullable = false, length = 100)
  private String name;
  
  @Column(nullable = false, length = 50)
  private String username;

  @Column(unique = true, nullable = false, length = 50)
  private String email;

  @Column(nullable = false, length = 100)
  private String password;

  @Column(length = 255)
  private String description;

  @Column(length = 255)
  private String curriculum;

  @CreationTimestamp
  @Column(updatable = false, nullable = false, name = "create_at")
  private LocalDateTime createAt;
  
}
