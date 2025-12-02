package com.ec.akirafinanzas.service;

import com.ec.akirafinanzas.model.dto.category.CreateCategoryDTO;
import com.ec.akirafinanzas.model.dto.category.UpdateCategoryDTO;

public interface CategoryService {

    CreateCategoryDTO createNewCategory(CreateCategoryDTO createCategoryDTO);

    UpdateCategoryDTO updateCategory(UpdateCategoryDTO updateCategoryDTO);

}
