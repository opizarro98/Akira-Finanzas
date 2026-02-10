package com.ec.akirafinanzas.service;

import java.util.List;

import com.ec.akirafinanzas.model.dto.account.AccountResponseDTO;
import com.ec.akirafinanzas.model.dto.account.CreateAccountRequestDTO;

public interface AccountService {

    public CreateAccountRequestDTO create(CreateAccountRequestDTO dto);

    public AccountResponseDTO update(AccountResponseDTO dto);

    public List<AccountResponseDTO> getAllAccounts();

    public Boolean delete(Long accountId);

    public Double getTotalBalance();
}
