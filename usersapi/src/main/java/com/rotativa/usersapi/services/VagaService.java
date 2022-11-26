package com.rotativa.usersapi.services;
import java.util.List;
import java.util.Optional;

import com.rotativa.usersapi.Entidades.Vaga;

public interface VagaService {

    List<Vaga> buscarVaga(String nome);

    Vaga save(Vaga vaga);

    Vaga update(Vaga vaga);

    Optional<Vaga> partialUpdate(Vaga vaga);

    List<Vaga> findAll();

    Optional<Vaga> findOne(Long id);

    void delete(Long id);
}
