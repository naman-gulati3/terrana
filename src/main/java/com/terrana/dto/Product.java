package com.terrana.dto;


import com.terrana.entity.CategoryEntity;
import com.terrana.entity.ProductEntity;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

  private long id;

  private String name;

  private String description;

  private float cost;

  private int discount;

  private int categoryId;


  // TODO: move to some util
  public static Product fromEntity(ProductEntity productEntity) {
    Product product = new Product();
    product.setId(productEntity.getId());
    product.setName(productEntity.getName());
    product.setDescription(productEntity.getDescription());
    product.setDiscount(productEntity.getDiscount());
    product.setCost(productEntity.getCost());
    product.setCategoryId(productEntity.getCategoryEntity().getFirst().getId());

    return product;
  }

  public static ProductEntity toEntity(Product product) {
    ProductEntity entity = new ProductEntity();
    CategoryEntity categoryEntity = new CategoryEntity();
//    categoryEntity.setId(product.getCategoryId());

    entity.setId(product.getId());
    entity.setName(product.getName());
    entity.setDiscount(product.getDiscount());
    entity.setCost(product.getCost());
    entity.setDescription(product.getDescription());
//    entity.set(categoryEntity);

    return entity;
  }
}
