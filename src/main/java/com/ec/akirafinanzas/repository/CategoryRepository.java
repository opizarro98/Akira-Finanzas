package com.ec.akirafinanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec.akirafinanzas.model.entity.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {

}
