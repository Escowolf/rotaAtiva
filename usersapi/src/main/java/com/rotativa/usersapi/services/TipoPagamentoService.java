package com.rotativa.usersapi.Services;
// interface criada em arquivo separado para manter a privacidade da implementação dos métodos.
import java.util.List;

import org.springframework.stereotype.Component;
import com.rotativa.usersapi.Entidades.*;

@Component
public interface TipoPagamentoService {
 
    public List<TipoPagamentoModel> listar();
    
    public void salvar(TipoPagamentoModel tipoPagamento);

    public void alterar(TipoPagamentoModel tipoPagamento);

    public void excluir(TipoPagamentoModel tipoPagamento);
}