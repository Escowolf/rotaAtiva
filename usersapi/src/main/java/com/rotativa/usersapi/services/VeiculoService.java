package com.rotativa.usersapi.services;
import java.util.List;
import java.util.Optional;

import com.rotativa.usersapi.Entidades.Veiculo;

public interface VeiculoService {

    Veiculo save(Veiculo veiculo);

    Veiculo update(Veiculo veiculo);

    Optional<Veiculo> partialUpdate(Veiculo veiculo);

    List<Veiculo> findAll();

    Optional<Veiculo> findOne(Long id);

    void delete(Long id);
}
