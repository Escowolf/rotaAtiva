package com.rotativa.usersapi.Repositories;

import com.rotativa.usersapi.Entidades.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    public Optional<UsuarioModel> findByLogin(String login);

}