// package com.rotativa.usersapi.Entidades;

// import java.io.Serializable;
// import java.time.LocalDate;
// import javax.persistence.*;

// @Entity
// @Table(name = "administradr")
// public class administradr implements Serializable {

//     private static final long serialVersionUID = 1L;

//     @Id
//     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
//     @SequenceGenerator(name = "sequenceGenerator")
//     @Column(name = "id")
//     private Long id;

//     @Column(name = "nome")
//     private String nome;

//     @Column(name = "cpf")
//     private String cpf;

//     @Column(name = "email")
//     private String email;

//     @Column(name = "nascimento")
//     private LocalDate nascimento;

//     @Column(name = "senha")
//     private String senha;

//     public Long getId() {
//         return this.id;
//     }

//     public administradr id(Long id) {
//         this.setId(id);
//         return this;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getNome() {
//         return this.nome;
//     }

//     public administradr nome(String nome) {
//         this.setNome(nome);
//         return this;
//     }

//     public void setNome(String nome) {
//         this.nome = nome;
//     }

//     public String getCpf() {
//         return this.cpf;
//     }

//     public administradr cpf(String cpf) {
//         this.setCpf(cpf);
//         return this;
//     }

//     public void setCpf(String cpf) {
//         this.cpf = cpf;
//     }

//     public String getEmail() {
//         return this.email;
//     }

//     public administradr email(String email) {
//         this.setEmail(email);
//         return this;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public LocalDate getNascimento() {
//         return this.nascimento;
//     }

//     public administradr nascimento(LocalDate nascimento) {
//         this.setNascimento(nascimento);
//         return this;
//     }

//     public void setNascimento(LocalDate nascimento) {
//         this.nascimento = nascimento;
//     }

//     public String getSenha() {
//         return this.senha;
//     }

//     public administradr senha(String senha) {
//         this.setSenha(senha);
//         return this;
//     }

//     public void setSenha(String senha) {
//         this.senha = senha;
//     }

//     @Override
//     public boolean equals(Object o) {
//         if (this == o) {
//             return true;
//         }
//         if (!(o instanceof administradr)) {
//             return false;
//         }
//         return id != null && id.equals(((administradr) o).id);
//     }

//     @Override
//     public int hashCode() {
//         return getClass().hashCode();
//     }

//     @Override
//     public String toString() {
//         return "Administrador{" +
//             "id=" + getId() +
//             ", nome='" + getNome() + "'" +
//             ", cpf='" + getCpf() + "'" +
//             ", email='" + getEmail() + "'" +
//             ", nascimento='" + getNascimento() + "'" +
//             ", senha='" + getSenha() + "'" +
//             "}";
//     }
// }
