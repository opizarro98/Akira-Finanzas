package com.ec.akirafinanzas.service;

import java.util.List;

import com.ec.akirafinanzas.model.dto.account.AccountResponseDTO;
import com.ec.akirafinanzas.model.dto.account.CreateAccountRequestDTO;

public interface AccountService {

    public AccountResponseDTO create(CreateAccountRequestDTO dto);

    public List<AccountResponseDTO> getAllAccounts();
}
