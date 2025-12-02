package com.ec.akirafinanzas.model.dto.account;

import com.ec.akirafinanzas.model.enums.typeAccountEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAccountDTO {
    private Long accountId;
    private String accountName;
    private typeAccountEnum type;
    private Double balance;
}
