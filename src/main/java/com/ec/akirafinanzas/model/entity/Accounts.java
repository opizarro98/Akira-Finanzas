package com.ec.akirafinanzas.model.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.Comment;

import com.ec.akirafinanzas.auditable.Auditable;
import com.ec.akirafinanzas.model.enums.typeAccountEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "accounts")
public class Accounts extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    @Comment("Identificador de la cuenta")
    private Long accountId;

    @Column(nullable = false, name = "NameAccount", length = 25)
    @Comment("Nombre de la cuenta")
    private String accountName;

    @Comment("Tipo de Cuenta")
    @Enumerated(EnumType.STRING)
    private typeAccountEnum type;

    @Column(name = "balance", length = 25)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}