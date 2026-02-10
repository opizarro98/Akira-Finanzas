package com.ec.akirafinanzas.service.impl;

import java.util.List;

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

        public CreateAccountRequestDTO create(CreateAccountRequestDTO dto) {

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

                return CreateAccountRequestDTO.builder()
                                .name(account.getName())
                                .initialBalance(account.getBalance())
                                .type(account.getType())
                                .build();
        }

        @Override
        public List<AccountResponseDTO> getAllAccounts() {
                List<Account> accounts = accountRepository.findByIsActiveTrue();
                return accounts.stream()
                                .map(account -> AccountResponseDTO.builder()
                                                .accountId(account.getAccountId())
                                                .name(account.getName())
                                                .balance(account.getBalance())
                                                .type(account.getType())
                                                .build())
                                .toList();
        }

        @Override
        public AccountResponseDTO update(AccountResponseDTO dto) {
                Account account = accountRepository.findById(dto.getAccountId())
                                .orElseThrow(() -> new RuntimeException("Account not found"));
                account.setName(dto.getName());
                account.setType(dto.getType());
                accountRepository.save(account);

                return AccountResponseDTO.builder()
                                .accountId(account.getAccountId())
                                .name(account.getName())
                                .balance(account.getBalance())
                                .type(account.getType())
                                .build();
        }

        @Override
        public Boolean delete(Long accountId) {
                Account account = accountRepository.findById(accountId)
                                .orElseThrow(() -> new RuntimeException("Account not found"));
                account.setActive(false);
                accountRepository.save(account);
                return true;
        }

        @Override
        public Double getTotalBalance() {
                List<Account> accounts = accountRepository.findByIsActiveTrue();
                return accounts.stream()
                                .mapToDouble(account -> account.getBalance().doubleValue())
                                .sum();
        }
}
