package com.ec.akirafinanzas.service;

import com.ec.akirafinanzas.model.dto.account.AccountResponseDTO;
import com.ec.akirafinanzas.model.dto.account.CreateAccountRequestDTO;

public interface AccountService {

    public AccountResponseDTO create(CreateAccountRequestDTO dto);
}
