package com.rotativa.usersapi.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "data_compra")
    private LocalDate dataCompra;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "ticket")
    private Integer ticket;

    @ManyToOne
    @JsonIgnoreProperties(value = { "pagamentos", "telefones", "transacoes"}, allowSetters = true)
    private Usuari usuario;

    @ManyToOne
    private TipoPagamento tipoPagamento;

    public Long getId() {
        return this.id;
    }

    public Pagamento id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataCompra() {
        return this.dataCompra;
    }

    public Pagamento dataCompra(LocalDate dataCompra) {
        this.setDataCompra(dataCompra);
        return this;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValor() {
        return this.valor;
    }

    public Pagamento valor(Double valor) {
        this.setValor(valor);
        return this;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidadeTicket() {
        return this.ticket;
    }

    public Pagamento quantidadeTicket(Integer quantidadeTicket) {
        this.setQuantidadeTicket(quantidadeTicket);
        return this;
    }

    public void setQuantidadeTicket(Integer quantidadeTicket) {
        this.ticket = quantidadeTicket;
    }

    public Usuari getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuari usuario) {
        this.usuario = usuario;
    }

    public Pagamento usuario(Usuari usuario) {
        this.setUsuario(usuario);
        return this;
    }

    public TipoPagamento getTipoPagamento() {
        return this.tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Pagamento tipoPagamento(TipoPagamento tipoPagamento) {
        this.setTipoPagamento(tipoPagamento);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pagamento)) {
            return false;
        }
        return id != null && id.equals(((Pagamento) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Pagamento{" +
            "id=" + getId() +
            ", dataCompra='" + getDataCompra() + "'" +
            ", valor=" + getValor() +
            ", quantidadeTicket=" + getQuantidadeTicket() +
            "}";
    }
}
