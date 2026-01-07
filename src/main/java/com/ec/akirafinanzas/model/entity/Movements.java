package com.ec.akirafinanzas.model.entity;

import java.time.LocalDate;

import org.hibernate.annotations.Comment;

import com.ec.akirafinanzas.auditable.Auditable;
import com.ec.akirafinanzas.model.enums.typeMovementEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column(name = "type")
    @Comment("Tipo de movimeinto de la cuenta ")
    private typeMovementEnum typeMovementEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Accounts account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categories categories;
}
