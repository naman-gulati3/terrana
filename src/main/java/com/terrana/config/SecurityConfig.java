package com.terrana.config;

import com.terrana.service.TerranaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
    return security.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(register -> {
          register.requestMatchers("/", "/register/**", "collections/**").permitAll();
          register.requestMatchers("/user/**").hasRole("USER");
          register.requestMatchers("/admin/**", "/category/create", "/products/add_product")
              .hasRole("ADMIN");
          register.anyRequest().authenticated();
        }).formLogin(formLogin -> {
          formLogin.permitAll().defaultSuccessUrl("/collections/shop_all", true)
              .permitAll();
        })
        .build();
  }

  @Autowired
  private TerranaUserDetailsService terranaUserDetailsService;

  @Bean
  public UserDetailsService userDetailsService() {
    return terranaUserDetailsService;
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(new BCryptPasswordEncoder());
    provider.setUserDetailsService(terranaUserDetailsService);

    return provider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
