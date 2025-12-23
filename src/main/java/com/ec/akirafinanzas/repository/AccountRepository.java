package com.ec.akirafinanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec.akirafinanzas.model.entity.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {

    List<Accounts> findAllByActiveTrue();

}
