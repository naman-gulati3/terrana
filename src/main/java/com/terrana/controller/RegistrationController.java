package com.terrana.controller;


import com.terrana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {

  @Autowired
  UserRepository userRepository;

//  @Autowired
//  private PasswordEncoder passwordEncoder;
//
//  @Autowired
//  private AuthenticationManager authenticationManager;
//
//  @Autowired
//  private TerranaUserDetailsService terranaUserDetailsService;

//  @Autowired
//  private JwtService jwtService;
//
//  @PostMapping("/register/user")
//  public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
//    Optional<UserEntity> userOpt = userRepository.findByEmail(user.getEmail());
//    if (userOpt.isPresent()) {
//      return ResponseEntity.ok(userOpt.get());
//    }
//
//    user.setPassword(passwordEncoder.encode(user.getPassword()));
//    for (String role : user.getRole().split(", ")) {
//      if (role.equals("ADMIN")) {
//        return ResponseEntity.badRequest().build();
//      }
//    }
//
//    return ResponseEntity.ok(userRepository.save(user));
//  }
//
//  @PostMapping("/authenticate")
//  public ResponseEntity<String> authenticateAndGetTokens(@RequestBody LoginForm loginForm) {
//    Authentication authentication = authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(loginForm.email(), loginForm.password()));
//
//    if (authentication.isAuthenticated()) {
//      return ResponseEntity.ok(jwtService.generateToken(
//          terranaUserDetailsService.loadUserByUsername(loginForm.email())));
//
//    } else {
//      throw new UsernameNotFoundException(
//          "User with name %s not found".formatted(loginForm.email()));
//    }
//  }
//
//  @GetMapping("/login")
//  public String handleLogin() {
//    return "custom_login";
//  }
}
