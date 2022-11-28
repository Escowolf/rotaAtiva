package com.rotativa.usersapi.services;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rotativa.usersapi.Entidades.Usuario;

public interface UsuarioService {

    // List<Usuari> getUsuariosVaga(String nome);

    Usuario save(Usuario usuario);

    Usuario update(Usuario usuario);

    Optional<Usuario> partialUpdate(Usuario usuario);

    List<Usuario> findAll();

    Page<Usuario> findAllWithEagerRelationships(Pageable pageable);

    Optional<Usuario> findOne(Long id);

    void delete(Long id);
}
