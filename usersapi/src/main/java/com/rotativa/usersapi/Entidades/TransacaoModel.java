package com.rotativa.usersapi.Entidades;

import java.util.Date;
import javax.persistence.Entity; 
import javax.persistence.Column;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.Table;

@Entity
@Table(name = "transacao")
public class TransacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_transacao;
    @Column(name = "vaga_idvaga")
    private int vaga_idvaga;
    @Column(name = "usuario_idusuario")
    private int usuario_idusuario;
    @Column(name = "entrada")
    private Date entrada;
    @Column(name = "saida")
    private Date saida;
    @Column(name = "ticketsUsados")
    private int ticketsUsados;

  public TransacaoModel() {
        //
    }
  
     /**
     * @param id_transacao
     * @param vaga_idvaga
     * @param usuario_idusuario
     * @param entrada
     * @param saida
     * @param ticketsUsados
     */
    public TransacaoModel(int id_transacao, int vaga_idvaga, int usuario_idusuario, Date entrada, Date saida, int ticketsUsados) {
        this.id_transacao = id_transacao;
        this.vaga_idvaga = vaga_idvaga;
        this.usuario_idusuario = usuario_idusuario;
        this.entrada = entrada;
        this.saida = saida;
        this.ticketsUsados = ticketsUsados;
    }
    
    public int getTicketsUsados() {
        return ticketsUsados;
    }

    public void setTicketsUsados(int ticketsUsados) {
        this.ticketsUsados = ticketsUsados;
    }

    public int getId_transacao() {
        return id_transacao;
    }

    public void setId_Transacao(int id_transacao) {
        this.id_transacao = id_transacao;
    }

    public int getVaga_idvaga() {
        return vaga_idvaga;
    }

    public void setVaga_idvaga(int vaga_idvaga) {
        this.vaga_idvaga = vaga_idvaga;
    }

    public int getUsuario_idusuario() {
        return usuario_idusuario;
    }

    public void setUsuario_idusuario(int usuario_idusuario) {
        this.usuario_idusuario = usuario_idusuario;
    }

  public Date getSaida() {
        return saida;
    }

    public void setSaida (Date saida) {
        this.saida = saida;
    }


    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada (Date entrada) {
        this.entrada = entrada;
    }

    @Override
    public String toString() {
        return "Vagas {" +
                "id='" + id_transacao + '\'' +
                ", vaga='" + vaga_idvaga + '\'' +
                ", usuario ='" + usuario_idusuario + '\'' +
                ", entrada='" + entrada + '\'' +
                ", saida='" + saida + '\'' +
                ", ticketsUsados='" + ticketsUsados + '\'' +
                '}';
    }
}

