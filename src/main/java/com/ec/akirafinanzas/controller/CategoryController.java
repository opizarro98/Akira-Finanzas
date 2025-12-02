package com.ec.akirafinanzas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.category.CreateCategoryDTO;
import com.ec.akirafinanzas.model.dto.category.UpdateCategoryDTO;
import com.ec.akirafinanzas.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/CategoryRest")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/Create")
    public ResponseEntity<?> createNewCategory(@RequestBody CreateCategoryDTO category) {
        return ResponseEntity.ok().body(categoryService.createNewCategory(category));
    }

    @PutMapping("/Update")
    public ResponseEntity<?> UpdateCategory(@RequestBody UpdateCategoryDTO category) {
        return ResponseEntity.ok().body(categoryService.updateCategory(category));
    }
}
