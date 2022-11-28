package com.rotativa.usersapi.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotativa.usersapi.Entidades.AdministradorModel;
import com.rotativa.usersapi.Repositories.RepositorioAdministrador;
import com.rotativa.usersapi.Services.AdministradorService;

@Service("AdministradorService")
public class AdministradorImpl implements AdministradorService {
    
    RepositorioAdministrador repositorioAdministrador;

    @Autowired
	public AdministradorImpl(RepositorioAdministrador repositorioAdministrador) {
		this.repositorioAdministrador = repositorioAdministrador;
	}
	
	@Override
	public List<AdministradorModel> listar() {
        return repositorioAdministrador.findAll();
    }
    
	@Override
    public void salvar(AdministradorModel administrador) {
    	repositorioAdministrador.save(administrador);
    }

    @Override
    public void alterar(AdministradorModel administrador) {
        if(administrador.getIdadministrador()>0){
            repositorioAdministrador.save(administrador);
        }        
    }

    @Override
    public void excluir(AdministradorModel administrador) {
        repositorioAdministrador.delete(administrador);
    }
    @Override
    public List<AdministradorModel> buscaAdm(String email, int senha) {
        return repositorioAdministrador.buscarAdm(email,senha);
    }
    
}
