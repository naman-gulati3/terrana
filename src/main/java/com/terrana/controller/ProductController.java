package com.terrana.controller;


import com.terrana.dto.Inventory;
import com.terrana.dto.ProductRequestDTO;
import com.terrana.dto.ProductResponseDTO;
import com.terrana.service.ProductService;
import com.terrana.utils.HTTPUtil;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
      @RequestPart ProductRequestDTO productRequestDTO, @RequestPart MultipartFile image) {
    try {
      productService.createProduct(productRequestDTO, image);
      return ResponseEntity.status(HttpStatus.CREATED).body(HTTPUtil.SUCCESS);
    } catch (IOException exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid image");
    }
  }

  @GetMapping("/products/inventory")
  public ResponseEntity<List<Inventory>> getInventory() {
    return ResponseEntity.ok(Inventory.fromEntity(productService.getInventory()));
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
