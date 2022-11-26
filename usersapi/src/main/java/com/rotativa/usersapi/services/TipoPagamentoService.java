package com.rotativa.usersapi.services;
import java.util.List;
import java.util.Optional;

import com.rotativa.usersapi.Entidades.TipoPagamento;

public interface TipoPagamentoService {

    TipoPagamento save(TipoPagamento tipoPagamento);

    TipoPagamento update(TipoPagamento tipoPagamento);

    Optional<TipoPagamento> partialUpdate(TipoPagamento tipoPagamento);

    List<TipoPagamento> findAll();

    Optional<TipoPagamento> findOne(Long id);

    void delete(Long id);
}
