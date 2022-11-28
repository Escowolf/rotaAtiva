package com.rotativa.usersapi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rotativa.usersapi.Entidades.UsuarioModel;
import com.rotativa.usersapi.Services.UsuarioService;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping
public class UsuarioController {
    @Autowired 
    UsuarioService usersService;

    @GetMapping("/usuario")
    public List<UsuarioModel> listar(){
        return this.usersService.listar();
    }

    @PostMapping
    public void salvar(@RequestBody UsuarioModel usuario){
        usersService.salvar(usuario);
    }

    @PatchMapping
    public void alterar(@RequestBody UsuarioModel usuario){
        usersService.alterar(usuario);
    }

    @DeleteMapping
    public void excluir(@RequestBody UsuarioModel usuario) {
        usersService.excluir(usuario);
    }

    @GetMapping("/filtro")
    public List<UsuarioModel> filtroUsuario(@RequestParam("nome") String nome) {
        System.out.println("Nome = " + nome);
        List<UsuarioModel> usuarios = usersService.carregarPorNome(nome);
        return usuarios;
    }

    @GetMapping("/relatorio")
    List<List<String>> relatorioUsuario() {
        List<List<String>> filtro = usersService.relatorioUsuario();
        return filtro;
    }



    /* @GetMapping("filtro")
    public List<Usuario> filtroUsuario(String nome) {
        if (nome == null) {
            return usersService.listar();
        } else {
            List<Usuario> usuarios = repositorioUser.carregarPorNome(nome);
            return null;
        }
    } */

}