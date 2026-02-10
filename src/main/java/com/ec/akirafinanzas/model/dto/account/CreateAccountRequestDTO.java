package com.ec.akirafinanzas.model.dto.account;

import java.math.BigDecimal;

import com.ec.akirafinanzas.model.enums.AccountType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAccountRequestDTO {
    private String name;
    private BigDecimal initialBalance;
    private AccountType type;
}
