package com.rotativa.usersapi.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "numero", length = 45, nullable = false)
    private String numero;

    @ManyToOne
    @JsonIgnoreProperties(value = { "pagamentos", "telefones", "transacoes", "veiculos" }, allowSetters = true)
    private Usuario usuario;

    public Long getId() {
        return this.id;
    }

    public Telefone id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return this.numero;
    }

    public Telefone numero(String numero) {
        this.setNumero(numero);
        return this;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuari) {
        this.usuario = usuari;
    }

    public Telefone usuario(Usuario usuario) {
        this.setUsuario(usuario);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Telefone)) {
            return false;
        }
        return id != null && id.equals(((Telefone) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Telefone{" +
            "id=" + getId() +
            ", numero='" + getNumero() + "'" +
            "}";
    }
}
