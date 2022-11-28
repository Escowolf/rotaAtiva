package com.rotativa.usersapi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rotativa.usersapi.Entidades.AdministradorModel;
import com.rotativa.usersapi.Services.AdministradorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    AdministradorService administradorService;

    @GetMapping("/administradores")
    public List<AdministradorModel> listar(){
        return administradorService.listar();
    }

    @PostMapping("/cadastrar")
    public void salvar(@RequestBody AdministradorModel administrador){
        administradorService.salvar(administrador);
    }

    @PutMapping
    public void alterar(@RequestBody AdministradorModel administrador){
        administradorService.alterar(administrador);
    }

    @DeleteMapping
    public void excluir(@RequestBody AdministradorModel administrador) {
        administradorService.excluir(administrador);
    }
    @GetMapping("/buscar")
    public List<AdministradorModel> buscarAdm(@RequestParam("email") String email,@RequestParam("senha") int senha) {
        System.out.println("email = " +email+" senha: "+ senha);
        List<AdministradorModel> administrador = administradorService.buscaAdm(email, senha);
        if (administrador.isEmpty()) {
            System.out.println("sim");
           
        } else { 
            System.out.println("não");
        }
        return administrador;
    }

}
