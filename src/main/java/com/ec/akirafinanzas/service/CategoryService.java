package com.ec.akirafinanzas.service;

import java.util.List;

import com.ec.akirafinanzas.model.dto.category.CreateCategoryDTO;
import com.ec.akirafinanzas.model.dto.category.GetCategoryDTO;
import com.ec.akirafinanzas.model.dto.category.UpdateCategoryDTO;

public interface CategoryService {

    List<GetCategoryDTO> getAllActiveCategories();

    CreateCategoryDTO createNewCategory(CreateCategoryDTO createCategoryDTO);

    UpdateCategoryDTO updateCategory(UpdateCategoryDTO updateCategoryDTO);

    boolean deleteCategory(long id);

}
