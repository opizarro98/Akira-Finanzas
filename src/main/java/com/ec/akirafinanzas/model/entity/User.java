package com.ec.akirafinanzas.model.entity;

import org.hibernate.annotations.Comment;

import com.ec.akirafinanzas.auditable.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @Comment("Identificador del usuario")
    private Long userId;

    @Column(nullable = false, name = "username", length = 50)
    @Comment("Nombre de usuario")
    private String username;

    @Column(nullable = false, name = "password", length = 100)
    @Comment("Contraseña del usuario")
    private String password;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;
}
