package com.rotativa.usersapi.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotativa.usersapi.Entidades.*;
import com.rotativa.usersapi.Repositories.*;
import com.rotativa.usersapi.Services.*;

@Service("pagamentoService")
public class PagamentoImpl implements PagamentoService{
	
    RepositorioPagamento repositorioPagamento;
	
	@Autowired
	public PagamentoImpl(RepositorioPagamento repositorioPagamento) {
		this.repositorioPagamento = repositorioPagamento;
	}
	
	@Override
	public List<PagamentoModel> listar() {
        return repositorioPagamento.findAll();
    }
    
	@Override
    public void salvar(PagamentoModel pagamento) {
    	repositorioPagamento.save(pagamento);
    }

    @Override
    public void alterar(PagamentoModel pagamento) {
        if(pagamento.getIdpagamento()>0){
            repositorioPagamento.save(pagamento);
        }        
    }

    @Override
    public void excluir(PagamentoModel pagamento) {
        repositorioPagamento.delete(pagamento);        
    }
}

