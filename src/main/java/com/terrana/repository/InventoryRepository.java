package com.terrana.repository;

import com.terrana.entity.InventoryEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {

  Optional<InventoryEntity> findByProductId(Long productId);
}
