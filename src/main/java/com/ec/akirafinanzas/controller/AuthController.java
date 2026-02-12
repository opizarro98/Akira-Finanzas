package com.ec.akirafinanzas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.authapp.AuthRequestDTO;
import com.ec.akirafinanzas.model.dto.authapp.AuthResponseDTO;
import com.ec.akirafinanzas.model.dto.authapp.RegisterRequestDTO;
import com.ec.akirafinanzas.model.dto.authapp.UpdatePassRequestDTO;
import com.ec.akirafinanzas.service.AuthService.AuthService;
import com.fasterxml.jackson.databind.node.BooleanNode;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO dto) {
        return ResponseEntity.ok().body(authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO dto) {
        return ResponseEntity.ok().body(authService.login(dto));
    }

    @PostMapping("/UpdatePassword")
    public ResponseEntity<Boolean> updatePassword(@RequestBody UpdatePassRequestDTO dto) {
        return ResponseEntity.ok().body(authService.updatePassword(dto));
    }

    @GetMapping("/validPassword/{password}")
    public ResponseEntity<Boolean> validPassword(@PathVariable String password) {
        return ResponseEntity.ok(authService.validPassword(password));
    }
}
