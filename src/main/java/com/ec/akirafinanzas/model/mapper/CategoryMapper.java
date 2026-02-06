package com.ec.akirafinanzas.model.mapper;

import org.springframework.stereotype.Component;

import com.ec.akirafinanzas.model.dto.category.CategoryResponseDTO;
import com.ec.akirafinanzas.model.dto.category.CreateCategoryRequestDTO;
import com.ec.akirafinanzas.model.entity.Category;
import com.ec.akirafinanzas.model.entity.Person;

@Component
public class CategoryMapper {

    public Category toEntity(CreateCategoryRequestDTO dto, Person person) {

        return Category.builder()
                .name(dto.getName())
                .type(dto.getType())
                .person(person)
                .build();
    }

    public CategoryResponseDTO toResponse(Category category) {

        return CategoryResponseDTO.builder()
                .categoryId(category.getCategoryId())
                .name(category.getName())
                .type(category.getType())
                .build();
    }
}
