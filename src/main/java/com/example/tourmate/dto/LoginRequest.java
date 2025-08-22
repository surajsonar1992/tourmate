package com.example.tourmate.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class LoginRequest {
  @NotBlank @Email
  private String username; // email
  @NotBlank
  private String password;
}
