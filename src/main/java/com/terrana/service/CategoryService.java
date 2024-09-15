package com.terrana.service;

import com.terrana.entity.CategoryEntity;
import com.terrana.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  CategoryRepository categoryRepository;

  public int createCategory(CategoryEntity category) {
    CategoryEntity categoryEntity = categoryRepository.save(category);
    return categoryEntity.getId();
  }
}
