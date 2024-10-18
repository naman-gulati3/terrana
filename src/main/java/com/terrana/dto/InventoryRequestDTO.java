package com.terrana.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class InventoryRequestDTO {

  private String productName;
  private int quantity;
}
