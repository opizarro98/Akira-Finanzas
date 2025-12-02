package com.ec.akirafinanzas.model.dto.account;

import com.ec.akirafinanzas.model.enums.typeAccountEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountDTO {
    private String accountName;
    private typeAccountEnum type;
    private Double balance;

}
