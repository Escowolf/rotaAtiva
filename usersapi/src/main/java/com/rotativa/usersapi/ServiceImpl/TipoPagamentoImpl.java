package com.rotativa.usersapi.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotativa.usersapi.Services.*;
import com.rotativa.usersapi.Entidades.*;
import com.rotativa.usersapi.Repositories.*;

@Service("tipoPagamentoService")
public class TipoPagamentoImpl implements TipoPagamentoService{
	
    RepositorioTipoPagamento repositorioTipoPagamento;
	
	@Autowired
	public TipoPagamentoImpl(RepositorioTipoPagamento repositorioTipoPagamento) {
		this.repositorioTipoPagamento = repositorioTipoPagamento;
	}
	
	@Override
	public List<TipoPagamentoModel> listar() {
        return repositorioTipoPagamento.findAll();
    }
    
	@Override
    public void salvar(TipoPagamentoModel vagas) {
    	repositorioTipoPagamento.save(vagas);
    }

    @Override
    public void alterar(TipoPagamentoModel vagas) {
        if(vagas.getIdTipoPagamento()>0){
            repositorioTipoPagamento.save(vagas);
        }        
    }

    @Override
    public void excluir(TipoPagamentoModel usuario) {
        repositorioTipoPagamento.delete(usuario);        
    }
}

