package com.ec.akirafinanzas.model.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "categories")
public class Categories extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categorie_id")
    @Comment("Identificador de la categoria")
    private Long Id;

    @Column(nullable = false, name = "Name", length = 25)
    @Comment("Nombre de la categoria")
    private String Name;

}
