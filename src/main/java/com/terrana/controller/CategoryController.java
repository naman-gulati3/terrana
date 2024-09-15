package com.terrana.controller;

import com.terrana.dto.CategoryRequest;
import com.terrana.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping("/create")
  public ResponseEntity<Integer> createCategory(
      @RequestBody CategoryRequest categoryRequest) {
    int id = categoryService.createCategory(CategoryRequest.toEntity(categoryRequest));
    return ResponseEntity.status(HttpStatus.CREATED).body(id);
  }
}
