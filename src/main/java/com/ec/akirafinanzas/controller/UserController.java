package com.ec.akirafinanzas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.user.CreateUserDTO;
import com.ec.akirafinanzas.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/UserRest")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @PostMapping("/Create")
    public ResponseEntity<CreateUserDTO> createNewUser(@Valid @RequestBody CreateUserDTO user) {
        return ResponseEntity.ok().body(userService.createNewUser(user));
    }
}
