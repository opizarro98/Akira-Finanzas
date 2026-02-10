package com.ec.akirafinanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ec.akirafinanzas.model.entity.Account;
import com.ec.akirafinanzas.model.entity.Category;
import com.ec.akirafinanzas.model.entity.Person;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByNameAndPerson(String name, Person person);

    List<Category> findByPerson(Person person);

    @Query("SELECT a FROM Account a WHERE a.active = true ORDER BY a.accountId ASC")
    List<Account> findByIsActiveTrue();
}
