package com.ec.akirafinanzas.model.entity;

import java.util.List;

import org.hibernate.annotations.Comment;

import com.ec.akirafinanzas.auditable.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Person extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    @Comment("Identificador de la persona")
    private Long personId;

    @Column(nullable = false, name = "first_name", length = 25)
    @Comment("Primer nombre de la persona")
    private String firstName;

    @Column(nullable = true, name = "middle_name", length = 25)
    @Comment("Segundo nombre de la persona")
    private String middleName;

    @Column(nullable = false, name = "last_name", length = 25)
    @Comment("Primer apellido de la persona")
    private String lastName;

    @Column(nullable = true, name = "second_last_name", length = 25)
    @Comment("Segundo apellido de la persona")
    private String secondLastName;

    @Column(nullable = false, name = "email", length = 50)
    @Comment("Email de la persona")
    private String email;

    @Column(nullable = false, name = "phone")
    @Comment("Teléfono de la persona")
    private String phone;

    @OneToOne(mappedBy = "person")
    private User user;

    @OneToMany(mappedBy = "person")
    private List<Accounts> account;
}