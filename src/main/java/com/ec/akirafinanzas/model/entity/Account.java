package com.ec.akirafinanzas.model.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.Comment;

import com.ec.akirafinanzas.auditable.AuditableEntity;
import com.ec.akirafinanzas.model.enums.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Unique identifier for the account")
    private Long accountId;

    @Column(nullable = false)
    @Comment("Name of the account, e.g., Banco Pichincha, Efectivo, etc.")
    private String name; // Banco Pichincha, Efectivo, etc.

    @Column(nullable = false)
    @Comment("Current balance of the account")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Comment("Type of the account, e.g., BANK, CASH, WALLET")
    private AccountType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
