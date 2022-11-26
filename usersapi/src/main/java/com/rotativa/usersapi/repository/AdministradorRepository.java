package com.rotativa.usersapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rotativa.usersapi.model.AdministradorModel;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<AdministradorModel, Integer> {

    public Optional<AdministradorModel> findByLogin(String login);

}
