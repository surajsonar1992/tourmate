package com.example.tourmate.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SignupRequest {
  @NotBlank @Size(min=2,max=80)
  private String fullName;

  @NotBlank @Email
  private String email;

  @NotBlank @Size(min=6,max=100)
  private String password;
}
