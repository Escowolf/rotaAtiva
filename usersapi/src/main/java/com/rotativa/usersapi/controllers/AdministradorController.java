package com.rotativa.usersapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.rotativa.usersapi.model.Administrador;
import com.rotativa.usersapi.repository.AdministradorRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    private final AdministradorRepository repository;
    private final PasswordEncoder encoder;

    public AdministradorController(AdministradorRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @PostMapping("/editar")
    public void update(@RequestBody Administrador administrador) {

        repository.findById(administrador.getId())
                .map(existingUsuario -> {
                    if (administrador.getCpf() != null) {
                        existingUsuario.setCpf(administrador.getCpf());
                    }
                    if (administrador.getNome() != null) {
                        existingUsuario.setNome(administrador.getNome());
                    }
                    if (administrador.getEmail() != null) {
                        existingUsuario.setEmail(administrador.getEmail());
                    }
                    if (administrador.getPassword() != null) {
                        existingUsuario.setPassword(administrador.getPassword());
                    }
                    if (administrador.getNascimento() != null) {
                        existingUsuario.setNascimento(administrador.getNascimento());
                    }
                    return existingUsuario;
                })
                .map(repository::save);

    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Administrador>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Administrador> salvar(@RequestBody Administrador administrador) {
        administrador.setPassword(encoder.encode(administrador.getPassword()));
        return ResponseEntity.ok(repository.save(administrador));
    }

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String email,
            @RequestParam String password) {

        Optional<Administrador> optAdministrador = repository.findByEmail(email);
        if (optAdministrador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Administrador administrador = optAdministrador.get();
        boolean valid = encoder.matches(password, administrador.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}