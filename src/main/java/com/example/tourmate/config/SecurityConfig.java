package com.example.tourmate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.ignoringRequestMatchers("/api/chat"))
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/css/**","/js/**","/images/**","/signup","/signin","/api/chat").permitAll()
        .anyRequest().authenticated()
      )
      .formLogin(login -> login
        .loginPage("/signin")
        .loginProcessingUrl("/signin")
        .defaultSuccessUrl("/", true)
        .permitAll()
      )
      .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/signin?logout").permitAll())
      .sessionManagement(sm -> sm.sessionFixation().migrateSession());

    return http.build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

  @Bean
  public DaoAuthenticationProvider authenticationProvider(UserDetailsService uds, BCryptPasswordEncoder encoder) {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(uds);
    provider.setPasswordEncoder(encoder);
    return provider;
  }
}
