package com.ec.akirafinanzas.service;

import com.ec.akirafinanzas.model.dto.account.CreateAccountDTO;
import com.ec.akirafinanzas.model.dto.account.UpdateAccountDTO;

public interface AccountService {

    CreateAccountDTO createAccount(CreateAccountDTO createAccountDTO);

    UpdateAccountDTO updateAccount(UpdateAccountDTO updateAccountDTO);

}
