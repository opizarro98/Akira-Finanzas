package com.ec.akirafinanzas.service;

import com.ec.akirafinanzas.model.dto.category.CategoryResponseDTO;
import com.ec.akirafinanzas.model.dto.category.CreateCategoryRequestDTO;

public interface CategoryService {

    public CategoryResponseDTO create(CreateCategoryRequestDTO dto);

    public java.util.List<CategoryResponseDTO> list();
}
