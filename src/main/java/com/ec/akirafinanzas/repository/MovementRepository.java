package com.ec.akirafinanzas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec.akirafinanzas.model.entity.Movement;
import com.ec.akirafinanzas.model.enums.MovementType;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

    List<Movement> findByPerson_PersonId(Long personId);

    List<Movement> findByPerson_PersonIdAndType(
            Long personId,
            MovementType type);

    List<Movement> findByPerson_PersonIdAndMovementDateBetween(
            Long personId,
            LocalDate start,
            LocalDate end);
}
