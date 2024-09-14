package com.terrana.dto;


import com.terrana.entity.CategoryEntity;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category implements Serializable {

  private long id;

  private String name;

  private String description;

  private List<Product> products;

  public static Category fromEntity(CategoryEntity categoryEntity) {
//    List<Product> products = categoryEntity.getProducts().stream().map(Product::fromEntity)
//        .toList();
    return new Category(categoryEntity.getId(), categoryEntity.getName(),
        categoryEntity.getDescription(), Collections.emptyList());
  }
}
