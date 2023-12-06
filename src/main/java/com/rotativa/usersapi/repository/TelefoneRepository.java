package com.rotativa.usersapi.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.rotativa.usersapi.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {}
