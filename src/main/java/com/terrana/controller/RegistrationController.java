package com.terrana.controller;


import com.terrana.entity.UserEntity;
import com.terrana.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;


  @PostMapping("/register/user")
  public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
    Optional<UserEntity> userOpt = userRepository.findByEmail(user.getEmail());
    if (userOpt.isPresent()) {
      return ResponseEntity.ok(userOpt.get());
    }

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    for (String role : user.getRole().split(", ")) {
      if (role.equals("ADMIN")) {
        return ResponseEntity.badRequest().build();
      }
    }

    return ResponseEntity.ok(userRepository.save(user));

  }

  @GetMapping("/login")
  public String handleLogin() {
    return "custom_login";
  }
}
