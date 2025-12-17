package com.ec.akirafinanzas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.category.CreateCategoryDTO;
import com.ec.akirafinanzas.model.dto.category.UpdateCategoryDTO;
import com.ec.akirafinanzas.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/CategoryRest")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/GetAllActive")
    public ResponseEntity<?> getAllActiveCategories() {
        return ResponseEntity.ok().body(categoryService.getAllActiveCategories());
    }

    @PostMapping("/Create")
    public ResponseEntity<?> createNewCategory(@Valid @RequestBody CreateCategoryDTO category) {
        return ResponseEntity.ok().body(categoryService.createNewCategory(category));
    }

    @PutMapping("/Update")
    public ResponseEntity<?> UpdateCategory(@Valid @RequestBody UpdateCategoryDTO category) {
        return ResponseEntity.ok().body(categoryService.updateCategory(category));
    }

    @PutMapping("/Delete/{id}")
    public ResponseEntity<?> deleteCategory(@Valid @PathVariable Long id) {
        return ResponseEntity.ok().body(categoryService.deleteCategory(id));
    }
}