package com.ec.akirafinanzas.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ec.akirafinanzas.model.dto.account.CreateAccountDTO;
import com.ec.akirafinanzas.model.dto.account.GetActiveAccountsDTO;
import com.ec.akirafinanzas.model.dto.account.UpdateAccountDTO;
import com.ec.akirafinanzas.model.entity.Accounts;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Accounts toEntityCreate(CreateAccountDTO dto);

    CreateAccountDTO toDTOCreate(Accounts entity);

    Accounts toEntityUpdate(UpdateAccountDTO dto);

    UpdateAccountDTO toDTOUpdate(Accounts entity);

    List<GetActiveAccountsDTO> toDTOList(List<Accounts> entities);
}
