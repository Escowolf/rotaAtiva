package com.rotativa.usersapi.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rotativa.usersapi.Entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    default Optional<Usuario> findOneWithEagerRelationships(Long id) {
        return this.findById(id);
    }

    default List<Usuario> findAllWithEagerRelationships() {
        return this.findAll();
    }

    default Page<Usuario> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAll(pageable);
    }

    // @Query(value = "FROM Usuario u JOIN u.transacoes t WHERE t.vaga.nome = :nome")
    // List<Usuari> getUsuariosVaga(@Param("nome") String nome);
}
