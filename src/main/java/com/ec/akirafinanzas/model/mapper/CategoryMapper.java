package com.ec.akirafinanzas.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ec.akirafinanzas.model.dto.category.CreateCategoryDTO;
import com.ec.akirafinanzas.model.dto.category.UpdateCategoryDTO;
import com.ec.akirafinanzas.model.entity.Categories;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Categories toEntityCreate(CreateCategoryDTO dto);

    CreateCategoryDTO toDTOCreate(Categories entity);

    Categories toEntityUpdate(UpdateCategoryDTO dto);

    UpdateCategoryDTO toDTOUpdate(Categories entity);

    List<UpdateCategoryDTO> toDTOListUpdate(List<Categories> entities);
}
