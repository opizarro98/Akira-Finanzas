package com.ec.akirafinanzas.model.mapper;

import org.mapstruct.Mapper;

import com.ec.akirafinanzas.model.dto.user.CreateUserDTO;
import com.ec.akirafinanzas.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    CreateUserDTO toDTOCreate(User entity);

    User toEntityCreate(CreateUserDTO dto);

}
