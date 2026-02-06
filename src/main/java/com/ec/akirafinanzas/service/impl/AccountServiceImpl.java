package com.ec.akirafinanzas.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.error.UnauthorizedException;
import com.ec.akirafinanzas.model.dto.account.AccountResponseDTO;
import com.ec.akirafinanzas.model.dto.account.CreateAccountRequestDTO;
import com.ec.akirafinanzas.model.entity.Account;
import com.ec.akirafinanzas.model.entity.Person;
import com.ec.akirafinanzas.model.entity.User;
import com.ec.akirafinanzas.repository.AccountRepository;
import com.ec.akirafinanzas.repository.UserRepository;
import com.ec.akirafinanzas.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountResponseDTO create(CreateAccountRequestDTO dto) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UnauthorizedException("User not found"));

        Person person = user.getPerson();

        Account account = Account.builder()
                .name(dto.getName())
                .balance(dto.getInitialBalance())
                .type(dto.getType())
                .person(person)
                .build();

        accountRepository.save(account);

        return AccountResponseDTO.builder()
                .accountId(account.getAccountId())
                .name(account.getName())
                .balance(account.getBalance())
                .type(account.getType())
                .build();
    }
}
