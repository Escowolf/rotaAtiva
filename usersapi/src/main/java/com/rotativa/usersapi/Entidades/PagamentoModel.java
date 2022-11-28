package com.rotativa.usersapi.Entidades;

import java.sql.Date;
import javax.persistence.Entity; //O uso de @Entity identifica uma classe como Entidade
import javax.persistence.Id; //identificando chave primária para o framework
import javax.persistence.Table;

@Entity
@Table(name = "pagamento", schema = "rotaativa")
public class PagamentoModel {
    @Id
    private int idpagamento;
    private Date dataCompra;
    private Double valor;
    private int quantidadeTicket;


    
    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }
    public Date getDataCompra() {
        return dataCompra;
    }
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public int getQuantidadeTicket() {
        return quantidadeTicket;
    }

    public void setQuantidadeTicket(int quantidadeTicket) {
        this.quantidadeTicket = quantidadeTicket;
    }

    
}
