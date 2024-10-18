package com.terrana.config;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
//    return security.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(register -> {
//          register.requestMatchers("/", "/register/**", "collections/**", "/authenticate",
//              "/products/**").permitAll();
//          register.requestMatchers("/user/**").hasRole("USER");
////          register.requestMatchers("/admin/**", "/category/create", "/products/add_product")
////              .hasRole("ADMIN");
//          register.requestMatchers("/category/create", "/products/add_product",
//              "/products/update_inventory").permitAll();
////          register.anyRequest().authenticated();
//        }).formLogin(formLogin -> {
//          formLogin.permitAll().defaultSuccessUrl("/collections/shop_all", true)
//              .permitAll();
//        })
//        .build();
//  }
//
////  @Autowired
////  private TerranaUserDetailsService terranaUserDetailsService;
////
////  @Bean
////  public UserDetailsService userDetailsService() {
////    return terranaUserDetailsService;
////  }
////
////  @Bean
////  public AuthenticationManager authenticationManager() {
////    return new ProviderManager(authenticationProvider());
////  }
//
////  @Bean
////  public AuthenticationProvider authenticationProvider() {
////    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
////    provider.setPasswordEncoder(new BCryptPasswordEncoder());
////    provider.setUserDetailsService(terranaUserDetailsService);
////
////    return provider;
////  }
////
////  @Bean
////  public PasswordEncoder passwordEncoder() {
////    return new BCryptPasswordEncoder();
////  }
//}
