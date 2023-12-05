package com.rotativa.usersapi.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.rotativa.usersapi.model.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
   
}
