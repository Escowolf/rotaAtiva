package controllers;
// package com.rotativa.usersapi.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.rotativa.usersapi.Entidades.administradr;
// import com.rotativa.usersapi.services.AdministradorService;

// @CrossOrigin(origins = "http://localhost:3000")
// @RestController
// @RequestMapping("/administrador")
// public class AdministradorController {
//     @Autowired
//     AdministradorService administradorService;

//     @GetMapping("/administradores")
//     public List<administradr> listar(){
//         return administradorService.findAll();
//     }

//     @PostMapping("/cadastrar")
//     public void salvar(@RequestBody administradr administrador){
//         administradorService.save(administrador);
//     }

//     @PutMapping
//     public void alterar(@RequestBody administradr administrador){
//         administradorService.update(administrador);
//     }

//     // @GetMapping("/buscar")
//     // public List<Administrador> buscarAdm(@RequestParam("email") String email,@RequestParam("senha") int senha) {
//     //     System.out.println("email = " +email+" senha: "+ senha);
//     //     List<Administrador> administrador = administradorService.buscaAdm(email, senha);
//     //     if (administrador.isEmpty()) {
//     //         System.out.println("sim");
           
//     //     } else { 
//     //         System.out.println("não");
//     //     }
//     //     return administrador;
//     // }

// }
