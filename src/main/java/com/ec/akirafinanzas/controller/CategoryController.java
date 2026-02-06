package com.ec.akirafinanzas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.category.CategoryResponseDTO;
import com.ec.akirafinanzas.model.dto.category.CreateCategoryRequestDTO;
import com.ec.akirafinanzas.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("createCategory")
    public ResponseEntity<CategoryResponseDTO> create(
            @RequestBody CreateCategoryRequestDTO dto) {

        return ResponseEntity.ok(categoryService.create(dto));
    }

    @GetMapping("listCategories")
    public ResponseEntity<List<CategoryResponseDTO>> list() {

        return ResponseEntity.ok(categoryService.list());
    }
}
