package com.ec.akirafinanzas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.account.AccountResponseDTO;
import com.ec.akirafinanzas.model.dto.account.CreateAccountRequestDTO;
import com.ec.akirafinanzas.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<AccountResponseDTO> create(
            @RequestBody CreateAccountRequestDTO createAccountRequestDTO) {

        return ResponseEntity.ok(accountService.create(createAccountRequestDTO));
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
}
