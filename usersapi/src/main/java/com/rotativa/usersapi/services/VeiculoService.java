package com.rotativa.usersapi.Services;
// interface criada em arquivo separado para manter a privacidade da implementação dos métodos.
import java.util.List;

import org.springframework.stereotype.Component;
import com.rotativa.usersapi.Entidades.*;

@Component
public interface VeiculoService {
 
    public List<VeiculoModel> listar();
    
    public void salvar(VeiculoModel veiculo);

    public void alterar(VeiculoModel veiculo);

    public void excluir(VeiculoModel veiculo);
}