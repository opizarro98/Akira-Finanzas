package com.ec.akirafinanzas.model.dto.movement;

import java.math.BigDecimal;

import com.ec.akirafinanzas.model.enums.MovementType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateMovementRequestDTO {

    private MovementType type;
    private BigDecimal amount;
    private String description;

    private Long sourceAccountId;
    private Long targetAccountId;

    private Long categoryId;
}
