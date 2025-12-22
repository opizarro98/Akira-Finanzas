package com.ec.akirafinanzas.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.model.dto.category.CreateCategoryDTO;
import com.ec.akirafinanzas.model.dto.category.GetCategoryDTO;
import com.ec.akirafinanzas.model.dto.category.UpdateCategoryDTO;
import com.ec.akirafinanzas.model.entity.Categories;
import com.ec.akirafinanzas.model.mapper.CategoryMapper;
import com.ec.akirafinanzas.repository.CategoryRepository;
import com.ec.akirafinanzas.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public List<GetCategoryDTO> getAllActiveCategories() {
        List<Categories> categories = categoryRepository.findAllByActiveTrue();
        return categoryMapper.toDTOListUpdate(categories);
    }

    @Override
    public CreateCategoryDTO createNewCategory(CreateCategoryDTO createCategoryDTO) {

        System.out.println("Esta es la cateoria que llega " + createCategoryDTO);
        Categories newCategories = categoryMapper.toEntityCreate(createCategoryDTO);
        return categoryMapper.toDTOCreate(categoryRepository.save(newCategories));
    }

    @Override
    public UpdateCategoryDTO updateCategory(UpdateCategoryDTO updateCategoryDTO) {
        Categories category = categoryRepository.getReferenceById(updateCategoryDTO.getId());
        category.setName(updateCategoryDTO.getName());
        return categoryMapper.toDTOUpdate(categoryRepository.save(category));
    }

    @Override
    public boolean deleteCategory(long id) {
        Categories category = categoryRepository.getReferenceById(id);
        category.setActive(false);
        categoryRepository.save(category);
        return true;
    }

}
