package com.terrana.dto;


import com.terrana.entity.CategoryEntity;
import com.terrana.entity.ProductEntity;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequestDTO extends Product implements Serializable {

  private int categoryId;

  // TODO: move to some util
  public static ProductEntity toEntity(ProductRequestDTO productRequestDTO) {
    ProductEntity entity = new ProductEntity();
    CategoryEntity category = new CategoryEntity();
    category.setId(productRequestDTO.getCategoryId());

    entity.setId(productRequestDTO.getId());
    entity.setName(productRequestDTO.getName());
    entity.setDiscount(productRequestDTO.getDiscount());
    entity.setCost(productRequestDTO.getCost());
    entity.setDescription(productRequestDTO.getDescription());
    entity.setTags(productRequestDTO.getTags());
    entity.setInStock(productRequestDTO.isInStock());
    entity.setCategoryEntity(List.of(category));

    return entity;
  }
}
