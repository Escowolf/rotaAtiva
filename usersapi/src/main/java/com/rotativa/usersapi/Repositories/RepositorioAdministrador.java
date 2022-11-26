package com.rotativa.usersapi.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rotativa.usersapi.Entidades.AdministradorModel;

public interface RepositorioAdministrador extends JpaRepository<AdministradorModel, Long> {

    @Query(value = "select * from administrador where email = :email and senha = :senha",  nativeQuery = true)
    List<AdministradorModel> buscarAdm(@Param ("email") String email,@Param ("senha") int senha);

    List<AdministradorModel> findAll(Class<AdministradorModel> class1, String string);
    
}
