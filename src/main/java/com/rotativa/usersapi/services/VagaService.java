package com.rotativa.usersapi.services;

import java.util.List;
import java.util.Optional;

import com.rotativa.usersapi.model.Vaga;

public interface VagaService {

  List<Vaga> buscarVaga(String nome);

  List<Vaga> vagasDisponiveis();

  Vaga save(Vaga vaga);

  Vaga update(Vaga vaga);

  Optional<Vaga> partialUpdate(Vaga vaga);

  List<Vaga> findAll();

  Optional<Vaga> findOne(Long id);

  void delete(Long id);

  Integer getOcupacaoById(Long id);

}