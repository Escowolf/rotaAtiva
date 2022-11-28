package com.rotativa.usersapi.Services;
// interface criada em arquivo separado para manter a privacidade da implementação dos métodos.
import java.util.List;

import org.springframework.stereotype.Component;
import com.rotativa.usersapi.Entidades.*;

@Component
public interface PagamentoService {
 
    public List<PagamentoModel> listar();
    
    public void salvar(PagamentoModel pagamento);

    public void alterar(PagamentoModel pagamento);

    public void excluir(PagamentoModel pagamento);
}