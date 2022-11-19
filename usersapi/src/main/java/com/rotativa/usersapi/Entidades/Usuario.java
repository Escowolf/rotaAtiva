package com.rotativa.usersapi.Entidades;
/* Este projeto utiliza SpringBoot. Para que o Spring reconheça as elementos 
do projeto eles devem ser criados dentro da pasta userapi*/
import java.util.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "nome")
    private String nome;
    @Column(name = "acessibilidade")
    private int acessibilidade;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "ticket")
    private int ticket;


  public Usuario() {
    //
 	}
  
     public Usuario(int idUsuario, String cpf, String nome, int acessibilidade, String email, String senha, int ticket) {
 		this.idUsuario = idUsuario;
 		this.cpf = cpf;
 		this.nome = nome;
 		this.acessibilidade = acessibilidade;
 		this.email = email;
 		this.senha = senha;
 		this.ticket = ticket;
 	}

  public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getAcessibilidade() {
		return acessibilidade;
	}


	public void setAcessibilidade(int acessibilidade) {
		this.acessibilidade = acessibilidade;
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


	public int getTicket() {
		return ticket;
	}


	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

   @Override
    public String toString() {
        return "Usuario {" +
                "id='" + idUsuario + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", acessibilidade='" + acessibilidade + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", ticket='" + ticket +
                '}';

    }
}
