package com.ec.akirafinanzas.model.mapper;

import org.mapstruct.Mapper;

import com.ec.akirafinanzas.model.dto.person.createPersonDTO;
import com.ec.akirafinanzas.model.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    createPersonDTO toDTOCreate(Person entity);

    Person toEntityCreate(createPersonDTO dto);

}
