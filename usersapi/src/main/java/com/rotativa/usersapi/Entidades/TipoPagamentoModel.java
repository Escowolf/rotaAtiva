package com.rotativa.usersapi.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipopagamento", schema = "rotaativa")
public class TipoPagamentoModel {
    @Id 
    private int idTipoPagamento;
    private String TipoPagamento;
    private String DescPagamento;

    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }
    public void setIdTipoPagamento(int idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }
    public String getTipoPagamento() {
        return TipoPagamento;
    }
    public void setTipoPagamento(String tipoPagamento) {
        TipoPagamento = tipoPagamento;
    }
    public String getDescPagamento() {
        return DescPagamento;
    }
    public void setDescPagamento(String descPagamento) {
        DescPagamento = descPagamento;
    }
}
