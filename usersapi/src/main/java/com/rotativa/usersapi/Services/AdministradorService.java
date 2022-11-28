package com.rotativa.usersapi.Services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rotativa.usersapi.Entidades.*;

@Component
public interface AdministradorService {
 
    public List<AdministradorModel> listar();
    
    public void salvar(AdministradorModel administrador);

    public void alterar(AdministradorModel administrador);

    public void excluir(AdministradorModel administrador);

    public List<AdministradorModel> buscaAdm(String email, int senha);
}