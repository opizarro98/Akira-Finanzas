package com.ec.akirafinanzas.service.implement;

import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.model.dto.user.CreateUserDTO;
import com.ec.akirafinanzas.model.entity.User;
import com.ec.akirafinanzas.model.mapper.UserMapper;
import com.ec.akirafinanzas.repository.UserRepository;
import com.ec.akirafinanzas.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public CreateUserDTO createNewUser(CreateUserDTO user) {
        User newUser = userMapper.toEntityCreate(user);
        return userMapper.toDTOCreate(userRepository.save(newUser));
    }

}
