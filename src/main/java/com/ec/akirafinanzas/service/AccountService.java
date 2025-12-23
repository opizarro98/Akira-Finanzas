package com.ec.akirafinanzas.service;

import java.util.List;

import com.ec.akirafinanzas.model.dto.account.CreateAccountDTO;
import com.ec.akirafinanzas.model.dto.account.GetActiveAccountsDTO;
import com.ec.akirafinanzas.model.dto.account.UpdateAccountDTO;

public interface AccountService {

    CreateAccountDTO createAccount(CreateAccountDTO createAccountDTO);

    UpdateAccountDTO updateAccount(UpdateAccountDTO updateAccountDTO);

    List<GetActiveAccountsDTO> getAllAccounts();

}
