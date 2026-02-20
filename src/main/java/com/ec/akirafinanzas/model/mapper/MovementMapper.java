package com.ec.akirafinanzas.model.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ec.akirafinanzas.model.dto.movement.CreateMovementRequestDTO;
import com.ec.akirafinanzas.model.dto.movement.MovementResponseDTO;
import com.ec.akirafinanzas.model.entity.Account;
import com.ec.akirafinanzas.model.entity.Movement;
import com.ec.akirafinanzas.model.entity.Person;

@Component
public class MovementMapper {

        public Movement toEntity(CreateMovementRequestDTO dto,
                        Person person,
                        Account source,
                        Account target) {

                return Movement.builder()
                                .type(dto.getType())
                                .amount(dto.getAmount())
                                .description(dto.getDescription())
                                .movementDate(LocalDateTime.now())
                                .sourceAccount(source)
                                .targetAccount(target)
                                .person(person)
                                .build();
        }

        public MovementResponseDTO toResponse(Movement movement) {

                return MovementResponseDTO.builder()
                                .movementId(movement.getMovementId())
                                .type(movement.getType())
                                .amount(movement.getAmount())
                                .description(movement.getDescription())
                                .movementDate(movement.getMovementDate())
                                .sourceAccountId(
                                                movement.getSourceAccount() != null
                                                                ? movement.getSourceAccount().getAccountId()
                                                                : null)
                                .targetAccountId(
                                                movement.getTargetAccount() != null
                                                                ? movement.getTargetAccount().getAccountId()
                                                                : null)
                                .sourceAccountName(movement.getSourceAccount() != null
                                                ? movement.getSourceAccount().getName()
                                                : null)
                                .targetAccountName(movement.getTargetAccount() != null
                                                ? movement.getTargetAccount().getName()
                                                : null)
                                .build();
        }
}
