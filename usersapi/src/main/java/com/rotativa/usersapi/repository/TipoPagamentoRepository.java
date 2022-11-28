package com.rotativa.usersapi.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.rotativa.usersapi.model.TipoPagamento;

@Repository
public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Long> {}
