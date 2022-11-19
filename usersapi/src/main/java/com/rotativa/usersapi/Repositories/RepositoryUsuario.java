package com.rotativa.usersapi.Repositories;

import com.rotativa.usersapi.Entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, String>{
  Usuario findByNome(String nome); 

}
