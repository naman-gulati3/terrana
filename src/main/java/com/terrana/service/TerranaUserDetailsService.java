package com.terrana.service;

//@Service
//public class TerranaUserDetailsService implements UserDetailsService {
//
//  //  @Autowired
//  UserRepository userRepository;
//
//  public Optional<UserEntity> findUserByEmail(String email) {
//    return userRepository.findByEmail(email);
//  }
//
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    Optional<UserEntity> entity = userRepository.findByEmail(username);
//    if (entity.isPresent()) {
//      var userObj = entity.get();
//      return User.builder()
//          .password(userObj.getPassword())
//          .roles(getRole(userObj.getRole()))
//          .username(userObj.getEmail()).build();
//    } else {
//      throw new UsernameNotFoundException("User with username: %s not found".formatted(username));
//    }
//  }
//
//  private String[] getRole(String role) {
//    if (role == null) {
//      return new String[]{"USER"};
//    }
//    return role.split(", ");
//  }
//}
