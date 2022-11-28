package com.rotativa.usersapi.Entidades;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdministradorModel {

    @Id
    private int idadministrador;
    private String nome;
    private String cpf;
    private String email;
    private Date datanasc;
    private int senha;


    public int  getIdadministrador() {
        return idadministrador;
    }
    public void setIdadministrador(int idadministrador) {
        this.idadministrador = idadministrador;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDatanasc() {
        return datanasc;
    }
    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }
    public int getSenha() {
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Administrador {" +
                "id='"+idadministrador+'\'' +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", datanasc='" + datanasc + '\'' +
                ", senha='" + senha + 
                '}';

    }
    
}
