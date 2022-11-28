package com.rotativa.usersapi.Services;

import java.util.List;
import org.springframework.stereotype.Component;
import com.rotativa.usersapi.Entidades.*;

@Component
public interface UsuarioService {
 
    public List<UsuarioModel> listar();

    public void salvar(UsuarioModel users);

    public void alterar(UsuarioModel usuario);

    public void excluir(UsuarioModel usuario);

    public List<UsuarioModel> carregarPorNome(String nome);

    public List<List<String>> relatorioUsuario();

    
    
}