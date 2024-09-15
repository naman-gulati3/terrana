package com.terrana.dto;


import com.terrana.entity.ProductEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ProductResponseDTO extends Product {

  private String category;

  public static ProductResponseDTO fromEntity(ProductEntity productEntity) {
    ProductResponseDTO product = new ProductResponseDTO();
    product.setId(productEntity.getId());
    product.setName(productEntity.getName());
    product.setDescription(productEntity.getDescription());
    product.setDiscount(productEntity.getDiscount());
    product.setCost(productEntity.getCost());
    product.setInStock(productEntity.isInStock());
    product.setTags(productEntity.getTags());
    product.setCategory(productEntity.getCategoryEntity().getFirst().getName());

    return product;
  }
}
