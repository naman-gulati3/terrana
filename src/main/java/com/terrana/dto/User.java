package com.terrana.dto;

import com.terrana.entity.UserEntity;

public record User(long id, String email, String firstName, String lastName, String password) {

  public static User fromEntity(UserEntity entity) {
    return new User(entity.getId(), entity.getEmail(), entity.getFirstName(), entity.getLastName(),
        entity.getPassword());
  }
}
