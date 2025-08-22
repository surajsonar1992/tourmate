package com.example.tourmate.service;

import com.example.tourmate.dto.SignupRequest;
import com.example.tourmate.entity.User;
import com.example.tourmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class UserService {
  private final UserRepository repo;
  private final PasswordEncoder encoder;

  public User register(SignupRequest req) {
    if (repo.existsByEmail(req.getEmail())) throw new IllegalArgumentException("Email already registered");
    User user = User.builder()
      .fullName(req.getFullName())
      .email(req.getEmail())
      .passwordHash(encoder.encode(req.getPassword()))
      .build();
    return repo.save(user);
  }
}
