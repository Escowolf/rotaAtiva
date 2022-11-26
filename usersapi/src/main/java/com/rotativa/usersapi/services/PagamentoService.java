package com.rotativa.usersapi.services;
import java.util.List;
import java.util.Optional;

import com.rotativa.usersapi.Entidades.Pagamento;

public interface PagamentoService {

    Pagamento save(Pagamento pagamento);

    Pagamento update(Pagamento pagamento);

    Optional<Pagamento> partialUpdate(Pagamento pagamento);

    List<Pagamento> findAll();

    Optional<Pagamento> findOne(Long id);

    void delete(Long id);
}
