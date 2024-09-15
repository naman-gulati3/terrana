package com.terrana.dto;


import com.terrana.entity.CategoryEntity;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryRequest implements Serializable {

  private long id;

  private String name;

  private String description;

  public static CategoryRequest fromEntity(CategoryEntity categoryEntity) {
    return new CategoryRequest(categoryEntity.getId(), categoryEntity.getName(),
        categoryEntity.getDescription());
  }

  public static CategoryEntity toEntity(CategoryRequest categoryRequest) {
    CategoryEntity entity = new CategoryEntity();
    entity.setName(categoryRequest.getName());
    entity.setDescription(categoryRequest.getDescription());

    return entity;
  }
}
