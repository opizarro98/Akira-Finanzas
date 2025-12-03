package com.ec.akirafinanzas.service;

import com.ec.akirafinanzas.model.dto.user.CreateUserDTO;

public interface UserService {

    CreateUserDTO createNewUser(CreateUserDTO user);
}
