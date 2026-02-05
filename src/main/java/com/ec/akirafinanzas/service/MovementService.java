package com.ec.akirafinanzas.service;

import java.util.List;

import com.ec.akirafinanzas.model.dto.movement.CreateMovementRequestDTO;
import com.ec.akirafinanzas.model.dto.movement.MovementResponseDTO;

public interface MovementService {

    MovementResponseDTO create(CreateMovementRequestDTO dto);

    List<MovementResponseDTO> findMyMovements();
}
