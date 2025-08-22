package com.example.tourmate.controller;

import com.example.tourmate.dto.SignupRequest;
import com.example.tourmate.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller @RequiredArgsConstructor
public class AuthController {
  private final UserService userService;

  @GetMapping("/signup")
  public String signupForm(SignupRequest form) { return "signup"; }

  @PostMapping("/signup")
  public String doSignup(@Valid SignupRequest form, BindingResult br, Model model) {
    if (br.hasErrors()) return "signup";
    try {
      userService.register(form);
      model.addAttribute("success", "Account created. Please sign in.");
      return "signin";
    } catch (IllegalArgumentException e) {
      model.addAttribute("error", e.getMessage());
      return "signup";
    }
  }

  @GetMapping("/signin")
  public String signinForm() { return "signin"; }
}
