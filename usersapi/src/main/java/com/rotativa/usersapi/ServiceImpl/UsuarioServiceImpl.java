package com.rotativa.usersapi.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotativa.usersapi.Entidades.UsuarioModel;
import com.rotativa.usersapi.Repositories.RepositorioUsuario;
import com.rotativa.usersapi.Services.UsuarioService;


@Service("userService")
public class UsuarioServiceImpl implements UsuarioService{
	
	RepositorioUsuario repositorio;
	
	@Autowired
	public UsuarioServiceImpl(RepositorioUsuario repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public List<UsuarioModel> listar() {
        return this.repositorio.findAll();
    }
    
	@Override
    public void salvar(UsuarioModel usuario) {
    	repositorio.save(usuario);
    }

    @Override
    public void alterar(UsuarioModel usuario) {
        if(usuario.getIdusuario()>0){
            repositorio.save(usuario);
        }        
    }

    @Override
    public void excluir(UsuarioModel usuario) {
        repositorio.delete(usuario);        
    }

    @Override
    public List<UsuarioModel> carregarPorNome(String nome) {
        System.out.println();
        return repositorio.carregarPorNome(nome);
    }
    @Override
    public List<List<String>> relatorioUsuario() {
        return repositorio.relatorioUsuario();
    }

  
}

