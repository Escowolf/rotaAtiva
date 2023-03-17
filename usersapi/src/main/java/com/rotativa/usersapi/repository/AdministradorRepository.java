package com.rotativa.usersapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rotativa.usersapi.model.Administrador;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    public Optional<Administrador> findByEmail(String email);

}
