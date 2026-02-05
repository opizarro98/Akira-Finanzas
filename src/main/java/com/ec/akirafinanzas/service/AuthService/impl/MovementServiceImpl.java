package com.ec.akirafinanzas.service.AuthService.impl;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.model.dto.movement.CreateMovementRequestDTO;
import com.ec.akirafinanzas.model.dto.movement.MovementResponseDTO;
import com.ec.akirafinanzas.model.entity.Movement;
import com.ec.akirafinanzas.model.entity.Person;
import com.ec.akirafinanzas.model.entity.User;
import com.ec.akirafinanzas.repository.MovementRepository;
import com.ec.akirafinanzas.repository.UserRepository;
import com.ec.akirafinanzas.service.MovementService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MovementServiceImpl implements MovementService {

    private final MovementRepository movementRepository;
    private final UserRepository userRepository;

    @Override
    public MovementResponseDTO create(CreateMovementRequestDTO dto) {

        // 1️⃣ Obtener username desde JWT
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        System.out.println("+++++++++++++++++++++++++++++ Authenticated username: " + username);

        // 2️⃣ Buscar usuario
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));

        // 3️⃣ Obtener persona
        Person person = user.getPerson();

        // 4️⃣ Crear movimiento
        Movement movement = Movement.builder()
                .amount(dto.getAmount())
                .type(dto.getType())
                .movementDate(dto.getMovementDate())
                .description(dto.getDescription())
                .person(person)
                .build();

        // 5️⃣ Guardar
        Movement saved = movementRepository.save(movement);

        // 6️⃣ Respuesta
        return new MovementResponseDTO(
                saved.getMovementId(),
                saved.getAmount(),
                saved.getType(),
                saved.getMovementDate(),
                saved.getDescription());
    }

    @Override
    public List<MovementResponseDTO> findMyMovements() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));

        Long personId = user.getPerson().getPersonId();

        return movementRepository.findByPerson_PersonId(personId)
                .stream()
                .map(m -> new MovementResponseDTO(
                        m.getMovementId(),
                        m.getAmount(),
                        m.getType(),
                        m.getMovementDate(),
                        m.getDescription()))
                .toList();
    }
}
