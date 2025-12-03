package com.ec.akirafinanzas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.account.CreateAccountDTO;
import com.ec.akirafinanzas.model.dto.account.UpdateAccountDTO;
import com.ec.akirafinanzas.service.AccountService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/AccountRest")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/Create")
    public ResponseEntity<?> createNewAccount(@Valid @RequestBody CreateAccountDTO account) {
        return ResponseEntity.ok().body(accountService.createAccount(account));
    }

    @PutMapping("/Update")
    public ResponseEntity<?> UpdateAccount(@RequestBody UpdateAccountDTO account) {
        return ResponseEntity.ok().body(accountService.updateAccount(account));
    }
}
