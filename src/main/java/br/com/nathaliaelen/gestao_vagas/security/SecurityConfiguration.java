package br.com.nathaliaelen.gestao_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // desabilitar o spring security, para que eu configure como eu quero
    http.csrf(csrf -> csrf.disable());
    return http.build();
  }
  
}
