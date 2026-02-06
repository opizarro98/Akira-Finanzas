package com.ec.akirafinanzas.model.dto.movement;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ec.akirafinanzas.model.enums.MovementType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementResponseDTO {

    private Long movementId;
    private MovementType type;
    private BigDecimal amount;
    private String description;
    private LocalDateTime movementDate;

    private Long sourceAccountId;
    private Long targetAccountId;
}
