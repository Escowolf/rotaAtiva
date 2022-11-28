package com.rotativa.usersapi.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotativa.usersapi.Services.*;
import com.rotativa.usersapi.Entidades.*;
import com.rotativa.usersapi.Repositories.*;

@Service("telefoneService")
public class TelefoneImpl implements TelefoneService{
	
    RepositorioTelefone repositorioTelefone;
	
	@Autowired
	public TelefoneImpl(RepositorioTelefone repositorioTelefone) {
		this.repositorioTelefone = repositorioTelefone;
	}
	
	@Override
	public List<TelefoneModel> listar() {
        return repositorioTelefone.findAll();
    }
    
	@Override
    public void salvar(TelefoneModel telefone) {
    	repositorioTelefone.save(telefone);
    }

    @Override
    public void alterar(TelefoneModel telefone) {
        if(telefone.getIdtelefone()>0){
            repositorioTelefone.save(telefone);
        }        
    }

    @Override
    public void excluir(TelefoneModel telefone) {
        repositorioTelefone.delete(telefone);        
    }
}

