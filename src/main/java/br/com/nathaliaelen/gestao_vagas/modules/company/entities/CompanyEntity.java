package br.com.nathaliaelen.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(unique = true, nullable = false, length = 14)
  private String cnpj;

  @Column(nullable = false, length = 50)
  private String username;

  @Column(unique = true, nullable = false, length = 50)
  private String email;

  @Column(nullable = false, length = 100)
  private String password;

  @Column(length = 255)
  private String website;

  @Column(length = 255)
  private String description;

  @CreationTimestamp
  @Column(updatable = false, nullable = false, name = "create_at")
  private LocalDateTime createAt;

  @OneToMany(mappedBy = "companyEntity") // uma company (pode ter) para muitos jobs
  private List<JobEntity> jobs;
  
}
