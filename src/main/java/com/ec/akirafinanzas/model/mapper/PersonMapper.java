package com.ec.akirafinanzas.model.mapper;

import org.mapstruct.Mapper;

import com.ec.akirafinanzas.model.dto.person.CreatePersonDTO;
import com.ec.akirafinanzas.model.dto.person.GetPersonCompleteDTO;
import com.ec.akirafinanzas.model.dto.person.UpdatePersonDTO;
import com.ec.akirafinanzas.model.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    CreatePersonDTO toDTOCreate(Person entity);

    Person toEntityCreate(CreatePersonDTO dto);

    Person toEntityUpdate(UpdatePersonDTO dto);

    UpdatePersonDTO toDTOUpdate(Person entity);

    GetPersonCompleteDTO toDTOComplete(Person entity);

}
