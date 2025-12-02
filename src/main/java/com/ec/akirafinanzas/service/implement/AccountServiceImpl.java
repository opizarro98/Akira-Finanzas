package com.ec.akirafinanzas.service.implement;

import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.model.dto.account.CreateAccountDTO;
import com.ec.akirafinanzas.model.dto.account.UpdateAccountDTO;
import com.ec.akirafinanzas.model.entity.Accounts;
import com.ec.akirafinanzas.model.mapper.AccountMapper;
import com.ec.akirafinanzas.repository.AccountRepository;
import com.ec.akirafinanzas.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public CreateAccountDTO createAccount(CreateAccountDTO createAccountDTO) {
        Accounts account = accountMapper.toEntityCreate(createAccountDTO);
        return accountMapper.toDTOCreate(accountRepository.save(account));
    }

    @Override
    public UpdateAccountDTO updateAccount(UpdateAccountDTO dto) {
        Accounts account = accountRepository.getReferenceById(dto.getAccountId());
        account.setAccountName(dto.getAccountName());
        account.setBalance(dto.getBalance());
        account.setType(dto.getType());
        return accountMapper.toDTOUpdate(accountRepository.save(account));
    }
}
