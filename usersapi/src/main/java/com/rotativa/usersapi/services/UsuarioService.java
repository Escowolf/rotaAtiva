package com.rotativa.usersapi.services;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rotativa.usersapi.Entidades.Usuari;

public interface UsuarioService {

    // List<Usuari> getUsuariosVaga(String nome);

    Usuari save(Usuari usuario);

    Usuari update(Usuari usuario);

    Optional<Usuari> partialUpdate(Usuari usuario);

    List<Usuari> findAll();

    Page<Usuari> findAllWithEagerRelationships(Pageable pageable);

    Optional<Usuari> findOne(Long id);

    void delete(Long id);
}
