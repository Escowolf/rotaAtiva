package com.rotativa.usersapi.services;
import java.util.List;
import java.util.Optional;

import com.rotativa.usersapi.Entidades.Transacao;

public interface TransacaoService {

    List<Transacao> getTransacoes(String nome);    

    Transacao save(Transacao transacao);

    Transacao update(Transacao transacao);

    Optional<Transacao> partialUpdate(Transacao transacao);

    List<Transacao> findAll();

    Optional<Transacao> findOne(Long id);

    void delete(Long id);
}
