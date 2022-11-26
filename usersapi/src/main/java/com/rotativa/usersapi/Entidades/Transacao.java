package com.rotativa.usersapi.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "transacao")
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "entrada")
    private LocalDate entrada;

    @Column(name = "saida")
    private LocalDate saida;

    @Column(name = "ticket_usado")
    private Integer ticketUsado;

    @ManyToOne
    @JsonIgnoreProperties(value = { "pagamentos", "telefones", "transacoes"}, allowSetters = true)
    private Usuari usuario;

    @ManyToOne
    private Vaga vaga;
    
    public Long getId() {
        return this.id;
    }

    public Transacao(){}

    public Transacao(Long id, LocalDate entrada, LocalDate saida, Integer ticketUsado, Usuari usuario, Vaga vaga) {
        this.id = id;
        this.entrada = entrada;
        this.saida = saida;
        this.ticketUsado = ticketUsado;
        this.usuario = usuario;
        this.vaga = vaga;
    }

    public Transacao id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEntrada() {
        return this.entrada;
    }

    public Transacao entrada(LocalDate entrada) {
        this.setEntrada(entrada);
        return this;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public LocalDate getSaida() {
        return this.saida;
    }

    public Transacao saida(LocalDate saida) {
        this.setSaida(saida);
        return this;
    }

    public void setSaida(LocalDate saida) {
        this.saida = saida;
    }

    public Integer getTicketUsado() {
        return this.ticketUsado;
    }

    public Transacao ticketUsado(Integer ticketUsado) {
        this.setTicketUsado(ticketUsado);
        return this;
    }

    public void setTicketUsado(Integer ticketUsado) {
        this.ticketUsado = ticketUsado;
    }

    public Usuari getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuari usuario) {
        this.usuario = usuario;
    }

    public Transacao usuario(Usuari usuario) {
        this.setUsuario(usuario);
        return this;
    }

    public Vaga getVaga() {
        return this.vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Transacao vaga(Vaga vaga) {
        this.setVaga(vaga);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Transacao)) {
            return false;
        }
        return id != null && id.equals(((Transacao) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Transacao{" +
            "id=" + getId() +
            ", entrada='" + getEntrada() + "'" +
            ", saida='" + getSaida() + "'" +
            ", ticketUsado=" + getTicketUsado() +
            "}";
    }
}
