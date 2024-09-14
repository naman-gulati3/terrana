package com.terrana.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_unique_id", nullable = false)
  private String orderUniqueId;

  @Column(name = "shipping_address", nullable = false)
  private String shippingAddress;

  @Column(name = "tracking_number")
  private Long trackingNumber;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private ProductEntity product;
}
