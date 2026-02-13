package com.ec.akirafinanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ec.akirafinanzas.model.entity.Category;
import com.ec.akirafinanzas.model.entity.Person;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByNameAndPerson(String name, com.ec.akirafinanzas.model.entity.Person person);

    List<Category> findByPerson(Person person);

    @Query("SELECT a FROM Category a WHERE a.categoryId = :id")
    Category findByIdCategory(Long id);

}
