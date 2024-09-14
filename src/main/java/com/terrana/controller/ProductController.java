package com.terrana.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.terrana.dto.Product;
import com.terrana.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collections")
public class ProductController {

  @Autowired
  ProductService productService;

  @Autowired
  ObjectMapper objectMapper;

  @GetMapping("/shop_all")
  public ResponseEntity<List<Product>> getProducts() {

    List<Product> products = productService.getAllProducts().stream().map(Product::fromEntity)
        .toList();

    return ResponseEntity.ok(products);
  }

  // TODO: make this authenticated
  @PostMapping("/add_product")
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    try {
      productService.createProduct(product);
      return ResponseEntity.status(HttpStatus.CREATED).body(product);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
