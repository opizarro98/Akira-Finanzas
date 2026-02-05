package com.ec.akirafinanzas.model.dto.movement;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ec.akirafinanzas.model.enums.MovementType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMovementRequestDTO {

    private BigDecimal amount;
    private MovementType type;
    private LocalDate movementDate;
    private String description;
}
