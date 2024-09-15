package com.terrana.service;

import com.terrana.dto.ProductRequestDTO;
import com.terrana.entity.CategoryEntity;
import com.terrana.entity.ProductEntity;
import com.terrana.repository.CategoryRepository;
import com.terrana.repository.ProductCategoryRepository;
import com.terrana.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  CategoryRepository categoryRepository;

  @Autowired
  ProductCategoryRepository productCategoryRepository;

  public List<ProductEntity> getAllProducts() {
    return productRepository.findAll();
  }

  @Transactional
  public void createProduct(ProductRequestDTO productRequestDTO) {
    ProductEntity productEntity = new ProductEntity();
    productEntity.setName(productRequestDTO.getName());
    productEntity.setDescription(productRequestDTO.getDescription());
    productEntity.setCost(productRequestDTO.getCost());
    productEntity.setDiscount(productRequestDTO.getDiscount());

    // Save product
    productRepository.save(productEntity);

    Optional<CategoryEntity> categoryOpt = categoryRepository.findById(
        productRequestDTO.getCategoryId());

    if (categoryOpt.isEmpty()) {
      throw new IllegalArgumentException(
          "Category id %s does not exist".formatted(productRequestDTO.getCategoryId()));
    }

    productEntity.setCategoryEntity(List.of(categoryOpt.get()));
  }
}
