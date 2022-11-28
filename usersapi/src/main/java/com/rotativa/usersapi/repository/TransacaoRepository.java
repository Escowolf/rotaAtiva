package com.rotativa.usersapi.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rotativa.usersapi.model.Transacao;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query(value = "FROM Transacao t WHERE t.vaga.nome = :nome")
    List<Transacao> getTransacoes(@Param("nome") String nome);

}
