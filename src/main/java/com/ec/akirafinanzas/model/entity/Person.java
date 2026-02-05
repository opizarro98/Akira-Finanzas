package com.ec.akirafinanzas.model.entity;

import org.hibernate.annotations.Comment;

import com.ec.akirafinanzas.auditable.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Unique identifier for the person")
    private Long personId;

    @Column(nullable = false)
    @Comment("First name of the person")
    private String firstName;

    @Comment("Middle name of the person")
    private String middleName;

    @Column(nullable = false)
    @Comment("Last name of the person")
    private String lastName;

    @Comment("Second last name of the person")
    private String secondLastName;

    @Column(unique = true)
    @Comment("Email address of the person")
    private String email;

    @Column(unique = true)
    @Comment("Phone number of the person")
    private String phone;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    private User user;
}
