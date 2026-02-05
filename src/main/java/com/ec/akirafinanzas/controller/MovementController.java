package com.ec.akirafinanzas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.movement.CreateMovementRequestDTO;
import com.ec.akirafinanzas.model.dto.movement.MovementResponseDTO;
import com.ec.akirafinanzas.service.MovementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movements")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class MovementController {

    private final MovementService movementService;

    /**
     * Crear un movimiento (ingreso / gasto)
     */
    @PostMapping("/createMovement")
    public ResponseEntity<MovementResponseDTO> create(
            @RequestBody CreateMovementRequestDTO dto) {
        return ResponseEntity.ok(movementService.create(dto));
    }

    /**
     * Listar mis movimientos
     */
    @GetMapping("/myMovements")
    public ResponseEntity<List<MovementResponseDTO>> getMyMovements() {
        return ResponseEntity.ok(movementService.findMyMovements());
    }
}
