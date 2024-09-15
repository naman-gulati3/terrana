package com.terrana.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Product {

  private long id;

  private String name;

  private String description;

  private float cost;

  private int discount;

  private boolean inStock;

  private String tags;
}
