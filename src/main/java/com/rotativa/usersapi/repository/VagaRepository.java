package com.rotativa.usersapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rotativa.usersapi.model.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
    @Query(value = "select new Vaga(v.id, v.nome, v.logradouro,v.bairro,v.acessibilidade,v.longitudeInicial,v.longitudeFinal,v.latitudeInicial,v.latitudeFinal,v.credito,v.totalVeiculos,v.tempoUso) from Vaga v  where nome = :nome")
    List<Vaga> buscarVaga(@Param("nome") String nome);

    
}
