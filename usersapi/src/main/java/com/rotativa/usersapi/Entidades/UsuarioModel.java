package com.rotativa.usersapi.Entidades;

import java.util.Date;
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.Id; 
import javax.persistence.Table;


@Entity
@Table(name="usuario", schema = "rotaativa")
public class UsuarioModel {
    @Id 
    private int idusuario;
    private String cpf;
    private String nome;
    private int acessibilidade;
    @Column(nullable=false)
    private String email;
    private String senha;
    private Date datanasc;
    private int ticket;

    public int getAcessibilidade() {
        return acessibilidade;
    }
    public void setAcessibilidade(int acessibilidade) {
        this.acessibilidade = acessibilidade;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getTicket() {
        return ticket;
    }
    public void setTicket(int ticket) {
        this.ticket = ticket;
    }
    public Date getDatanasc() {
        return datanasc;
    }
    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }
    
    @Override
    public String toString() {
        return "Usuario {" +
                "id='" + idusuario + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", acessibilidade='" + acessibilidade + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", ticket='" + ticket +
                '}';
    }

}
