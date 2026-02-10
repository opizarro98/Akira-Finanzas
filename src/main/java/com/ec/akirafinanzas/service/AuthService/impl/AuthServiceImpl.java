package com.ec.akirafinanzas.service.AuthService.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.error.InvalidAuthDataException;
import com.ec.akirafinanzas.error.InvalidCredentialsException;
import com.ec.akirafinanzas.error.InvalidOldPasswordException;
import com.ec.akirafinanzas.error.SamePasswordException;
import com.ec.akirafinanzas.error.UserAlreadyExistsException;
import com.ec.akirafinanzas.model.dto.authapp.AuthRequestDTO;
import com.ec.akirafinanzas.model.dto.authapp.AuthResponseDTO;
import com.ec.akirafinanzas.model.dto.authapp.RegisterRequestDTO;
import com.ec.akirafinanzas.model.dto.authapp.UpdatePassRequestDTO;
import com.ec.akirafinanzas.model.entity.Person;
import com.ec.akirafinanzas.model.entity.User;
import com.ec.akirafinanzas.repository.PersonRepository;
import com.ec.akirafinanzas.repository.UserRepository;
import com.ec.akirafinanzas.security.JwtService;
import com.ec.akirafinanzas.service.AuthService.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public boolean register(RegisterRequestDTO authRequestDTO) {
        if (authRequestDTO.getUsername() == null || authRequestDTO.getUsername().isBlank()) {
            throw new InvalidAuthDataException("Username is required");
        }
        if (authRequestDTO.getPassword() == null || authRequestDTO.getPassword().isBlank()) {
            throw new InvalidAuthDataException("Password is required");
        }
        if (userRepository.existsByUsername(authRequestDTO.getUsername())) {
            throw new UserAlreadyExistsException(authRequestDTO.getUsername());
        }
        Person person = Person.builder()
                .firstName(authRequestDTO.getFirstName())
                .lastName(authRequestDTO.getLastName())
                .email(authRequestDTO.getEmail())
                .phone(authRequestDTO.getPhone())
                .build();

        personRepository.save(person);

        User user = User.builder()
                .username(authRequestDTO.getUsername())
                .password(passwordEncoder.encode(authRequestDTO.getPassword()))
                .person(person)
                .build();

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
                jwtService.generateToken(user));
    }

    @Override
    public boolean updatePassword(UpdatePassRequestDTO authRequestDTO) {
        User user = userRepository.findByUsername(authRequestDTO.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException());
        if (!passwordEncoder.matches(authRequestDTO.getOldPassword(), user.getPassword())) {
            throw new InvalidOldPasswordException("The previous password does not match");
        }

        if (passwordEncoder.matches(authRequestDTO.getNewPassword(), user.getPassword())) {
            throw new SamePasswordException("The password cannot be the same as the previous one. ");
        }

        user.setPassword(passwordEncoder.encode(authRequestDTO.getNewPassword()));
        userRepository.save(user);
        return true;
    }

}
