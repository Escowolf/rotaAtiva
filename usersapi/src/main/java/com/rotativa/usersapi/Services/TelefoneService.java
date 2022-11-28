package com.rotativa.usersapi.Services;
// interface criada em arquivo separado para manter a privacidade da implementação dos métodos.
import java.util.List;

import org.springframework.stereotype.Component;
import com.rotativa.usersapi.Entidades.*;

@Component
public interface TelefoneService {
 
    public List<TelefoneModel> listar();
    
    public void salvar(TelefoneModel telefone);

    public void alterar(TelefoneModel telefone);

    public void excluir(TelefoneModel telefone);
}