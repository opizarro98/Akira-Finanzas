package com.ec.akirafinanzas.model.dto.category;

import com.ec.akirafinanzas.model.enums.CategoryType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequestDTO {
    private String name;
    private CategoryType type;
}
