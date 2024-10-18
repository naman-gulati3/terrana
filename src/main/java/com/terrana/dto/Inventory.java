package com.terrana.dto;

import com.terrana.entity.InventoryEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

  private ProductResponseDTO product;
  private int quantity;

  public static List<Inventory> fromEntity(List<InventoryEntity> entityList) {
    List<Inventory> inventory = new ArrayList<>();
    for (InventoryEntity entity : entityList) {
      inventory.add(
          new Inventory(ProductResponseDTO.fromEntity(entity.getProduct()), entity.getQuantity()));
    }

    return inventory;
  }
}
