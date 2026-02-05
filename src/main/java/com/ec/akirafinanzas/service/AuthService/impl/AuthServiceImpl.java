package com.ec.akirafinanzas.service.AuthService.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.error.InvalidAuthDataException;
import com.ec.akirafinanzas.error.InvalidCredentialsException;
import com.ec.akirafinanzas.error.UserAlreadyExistsException;
import com.ec.akirafinanzas.model.dto.authapp.AuthRequestDTO;
import com.ec.akirafinanzas.model.dto.authapp.AuthResponseDTO;
import com.ec.akirafinanzas.model.entity.User;
import com.ec.akirafinanzas.repository.UserRepository;
import com.ec.akirafinanzas.security.JwtService;
import com.ec.akirafinanzas.service.AuthService.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public boolean register(AuthRequestDTO authRequestDTO) {
        if (authRequestDTO.getUsername() == null || authRequestDTO.getUsername().isBlank()) {
            throw new InvalidAuthDataException("Username is required");
        }
        if (authRequestDTO.getPassword() == null || authRequestDTO.getPassword().isBlank()) {
            throw new InvalidAuthDataException("Password is required");
        }
        if (userRepository.existsByUsername(authRequestDTO.getUsername())) {
            throw new UserAlreadyExistsException(authRequestDTO.getUsername());
        }
        User user = new User();
        user.setUsername(authRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(authRequestDTO.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {
        User user = userRepository.findByUsername(authRequestDTO.getUsername())
                .orElseThrow(InvalidCredentialsException::new);
        if (!passwordEncoder.matches(authRequestDTO.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }
        return new AuthResponseDTO(
                jwtService.generateToken(user.getUserId()));
    }

}
