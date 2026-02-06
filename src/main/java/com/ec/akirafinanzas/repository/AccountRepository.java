package com.ec.akirafinanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.akirafinanzas.model.entity.Account;
import com.ec.akirafinanzas.model.entity.Category;
import com.ec.akirafinanzas.model.entity.Person;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByNameAndPerson(String name, Person person);

    List<Category> findByPerson(Person person);
}
