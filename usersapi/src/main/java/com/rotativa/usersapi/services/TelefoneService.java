package com.rotativa.usersapi.services;
import java.util.List;
import java.util.Optional;

import com.rotativa.usersapi.Entidades.Telefone;

public interface TelefoneService {

    Telefone save(Telefone telefone);

    Telefone update(Telefone telefone);

    Optional<Telefone> partialUpdate(Telefone telefone);

    List<Telefone> findAll();

    Optional<Telefone> findOne(Long id);

    void delete(Long id);
}
