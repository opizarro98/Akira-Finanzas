package com.ec.akirafinanzas.model.entity;

import java.time.LocalDate;

import org.hibernate.annotations.Comment;

import com.ec.akirafinanzas.auditable.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movements")
public class Movements extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movement_id")
    @Comment("Identificador del movimiento")
    private Long movementId;

    @Column(nullable = false, name = "description", length = 100)
    @Comment("Descripción del movimiento")
    private String description;

    @Column(name = "amount")
    @Comment("Monto del movimiento")
    private Double amount;

    @Column(name = "movement_date")
    @Comment("Fecha del movimiento")
    private LocalDate movementDate;

}
