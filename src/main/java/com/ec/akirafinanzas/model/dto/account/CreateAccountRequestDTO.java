package com.ec.akirafinanzas.model.dto.account;

import java.math.BigDecimal;

import com.ec.akirafinanzas.model.enums.AccountType;

import lombok.Data;

@Data
public class CreateAccountRequestDTO {
    private String name;
    private BigDecimal initialBalance;
    private AccountType type;
}
