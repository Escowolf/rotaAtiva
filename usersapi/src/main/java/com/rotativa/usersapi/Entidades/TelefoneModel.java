package com.rotativa.usersapi.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefone",schema = "rotaativa")
public class TelefoneModel {
    @Id
    private int idtelefone;
    private int telefone;

    @ManyToOne
     private UsuarioModel usuario;
   
    
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
     
    public int getIdtelefone() {
        return idtelefone;
    }
    public void setIdtelefone(int idtelefone) {
        this.idtelefone = idtelefone;
    }
    
    public UsuarioModel getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
     
    
}
