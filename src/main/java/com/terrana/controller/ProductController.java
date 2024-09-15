package com.terrana.controller;


import com.terrana.dto.ProductRequestDTO;
import com.terrana.dto.ProductResponseDTO;
import com.terrana.service.ProductService;
import com.terrana.utils.HTTPUtil;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @Autowired
  ProductService productService;

  @GetMapping("/collections/shop_all")
  public ResponseEntity<List<ProductResponseDTO>> getProducts(
      @RequestParam(name = "in_stock", required = false) Boolean inStock,
      @RequestParam(value = "price_lte", required = false) Integer priceLTE,
      @RequestParam(value = "price_gte", required = false, defaultValue = "0") Integer priceGTE) {

    return ResponseEntity.ok(getFilteredProducts(inStock, priceLTE, priceGTE));
  }

  // TODO: make this authenticated
  @PostMapping("/products/add_product")
  public ResponseEntity<String> createProduct(
      @RequestBody ProductRequestDTO productRequestDTO) {
    productService.createProduct(productRequestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(HTTPUtil.SUCCESS);
  }

  private List<ProductResponseDTO> getFilteredProducts(Boolean inStock, Integer priceLTE,
      Integer priceGTE) {
    Stream<ProductResponseDTO> allProducts = productService.getAllProducts().stream().map(
        ProductResponseDTO::fromEntity);

    if (inStock != null) {
      allProducts = allProducts.filter(p -> p.isInStock() == inStock);
    }

    if (priceLTE != null) {
      allProducts = allProducts.filter(p -> p.getCost() <= priceLTE);
    }

    if (priceGTE != null) {
      allProducts = allProducts.filter(p -> p.getCost() >= priceGTE);
    }

    return allProducts.toList();
  }

}
