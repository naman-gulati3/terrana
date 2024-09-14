package com.terrana.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class CategoryEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private int id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;
//
//  @OneToMany(fetch = FetchType.LAZY)
//  @JoinColumn(name = "product_category", nullable = false)
//  private List<ProductEntity> products;
}
