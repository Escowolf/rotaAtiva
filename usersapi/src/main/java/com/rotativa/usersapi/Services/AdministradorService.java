package com.rotativa.usersapi.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rotativa.usersapi.model.*;

@Component
public interface AdministradorService {
 
    public List<Administrador> listar();
    
    public void salvar(Administrador administrador);

    public void alterar(Administrador administrador);

    public void excluir(Administrador administrador);

    public List<Administrador> buscaAdm(String email, int senha);
}