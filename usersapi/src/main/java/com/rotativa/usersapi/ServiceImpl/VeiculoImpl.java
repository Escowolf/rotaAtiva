package com.rotativa.usersapi.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotativa.usersapi.Services.*;
import com.rotativa.usersapi.Entidades.*;
import com.rotativa.usersapi.Repositories.*;

@Service("veiculoService")
public class VeiculoImpl implements VeiculoService{
	
    RepositorioVeiculo repositorioVeiculo;
	
	@Autowired
	public VeiculoImpl(RepositorioVeiculo repositorioVeiculo) {
		this.repositorioVeiculo = repositorioVeiculo;
	}
	
	@Override
	public List<VeiculoModel> listar() {
        return repositorioVeiculo.findAll();
    }
    
	@Override
    public void salvar(VeiculoModel veiculo) {
    	repositorioVeiculo.save(veiculo);
    }

    @Override
    public void alterar(VeiculoModel veiculo) {
        if(veiculo.getIdveiculo()>0){
            repositorioVeiculo.save(veiculo);
        }        
    }

    @Override
    public void excluir(VeiculoModel veiculo) {
        repositorioVeiculo.delete(veiculo);        
    }
}

