package com.rotativa.usersapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rotativa.usersapi.Entidades.*;

public interface RepositorioVeiculo extends JpaRepository<VeiculoModel,Long> {
    
}
