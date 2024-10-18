package com.terrana.service;

import com.terrana.dto.ProductRequestDTO;
import com.terrana.entity.InventoryEntity;
import com.terrana.entity.ProductEntity;
import com.terrana.repository.CategoryRepository;
import com.terrana.repository.InventoryRepository;
import com.terrana.repository.ProductCategoryRepository;
import com.terrana.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  CategoryRepository categoryRepository;

  @Autowired
  ProductCategoryRepository productCategoryRepository;

  @Autowired
  InventoryRepository inventoryRepository;

  public List<ProductEntity> getAllProducts() {
    return productRepository.findAll();
  }

  public List<InventoryEntity> getInventory() {
    return inventoryRepository.findAll();
  }

  @Transactional
  public void createProduct(ProductRequestDTO productRequestDTO, MultipartFile image)
      throws IOException {
    Optional<ProductEntity> product = productRepository.findByName(productRequestDTO.getName());

    if (product.isPresent()) {
      handleProductUpdate(productRequestDTO, product.get(), image);
      return;
    }

    ProductEntity productEntity = buildProductEntity(productRequestDTO, image);

    InventoryEntity inventoryEntity = new InventoryEntity();
    inventoryEntity.setProduct(productEntity);
    inventoryEntity.setQuantity(productRequestDTO.getQuantity());
    // Save product

    productRepository.save(productEntity);
    inventoryRepository.save(inventoryEntity);
  }

  private static ProductEntity buildProductEntity(ProductRequestDTO productRequestDTO,
      MultipartFile image) throws IOException {
    ProductEntity productEntity = new ProductEntity();
    productEntity.setName(productRequestDTO.getName());
    productEntity.setDescription(productRequestDTO.getDescription());
    productEntity.setCost(productRequestDTO.getCost());
    productEntity.setDiscount(productRequestDTO.getDiscount());
    productEntity.setInStock(productRequestDTO.isInStock());
    productEntity.setTags(productRequestDTO.getTags());
    productEntity.setImage(image.getBytes());
    productEntity.setImageName(image.getName());
    productEntity.setImageType(image.getContentType());
    return productEntity;
  }

  private void handleProductUpdate(ProductRequestDTO productRequestDTO,
      ProductEntity productEntity, MultipartFile image) throws IOException {
    productEntity.setCost(productRequestDTO.getCost());
    productEntity.setDescription(productRequestDTO.getDescription());
    productEntity.setTags(productRequestDTO.getTags());
    productEntity.setInStock(productRequestDTO.isInStock());
    productEntity.setDiscount(productRequestDTO.getDiscount());
    productEntity.setImage(image.getBytes());
    productEntity.setImageName(image.getName());
    productEntity.setImageType(image.getContentType());
    productRepository.save(productEntity);
    InventoryEntity inventoryEntity = inventoryRepository.findByProductId(productEntity.getId())
        .orElseGet(() -> {
          InventoryEntity newEntity = new InventoryEntity();
          newEntity.setProduct(productEntity);
          return newEntity;
        });

    inventoryEntity.setQuantity(productRequestDTO.getQuantity());

    inventoryRepository.save(inventoryEntity);
  }
}
