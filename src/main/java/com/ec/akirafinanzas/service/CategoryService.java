package com.ec.akirafinanzas.service;

import java.util.List;

import com.ec.akirafinanzas.model.dto.category.CategoryResponseDTO;
import com.ec.akirafinanzas.model.dto.category.CreateCategoryRequestDTO;
import com.ec.akirafinanzas.model.dto.category.UpdateCategoryRequestDTO;

public interface CategoryService {

    public CategoryResponseDTO create(CreateCategoryRequestDTO dto);

    public Boolean update(UpdateCategoryRequestDTO data);

    public List<CategoryResponseDTO> list();

    public Boolean delete(Long categoryId);
}
