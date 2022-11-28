package com.rotativa.usersapi.Entidades;
/* Este projeto utiliza SpringBoot. Para que o Spring reconheça as elementos 
do projeto eles devem ser criados dentro da pasta userapi*/
import java.sql.Time;

import javax.persistence.Entity; //O uso de @Entity identifica uma classe como Entidade
import javax.persistence.Column; // Definindo regras para a coluna
import javax.persistence.Id; //identificando chave primária para o framework
import javax.persistence.Table;

@Entity
@Table(name = "vaga", schema = "rotaativa")
public class VagasModel {
    @Id
    private int idvaga;
    @Column(nullable = false)
    private String rua_avenida;
    private String bairro;
    private String acessibilidade;
    private String nomevaga;
    private int longitudeinicial;
    private int longitudefinal;
    private int latitudeinicial;
    private int latitudefinal;
    private Time horariousoinica;
    private Time horariousofinal;
    private boolean estadovaga;
    private int tempoticket;
    

    public int getIdvaga() {
        return idvaga;
    }
    public int getTempoticket() {
        return tempoticket;
    }
    public void setTempoticket(int tempoticket) {
        this.tempoticket = tempoticket;
    }
    public void setIdvaga(int idvaga) {
        this.idvaga = idvaga;
    }
    public String getRua_avenida() {
        return rua_avenida;
    }
    public void setRua_avenida(String rua_avenida) {
        this.rua_avenida = rua_avenida;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getAcessibilidade() {
        return acessibilidade;
    }
    public void setAcessibilidade(String acessibilidade) {
        this.acessibilidade = acessibilidade;
    }
    public String getNomeVaga() {
        return nomevaga;
    }
    public void setNomeVaga(String nomeVaga) {
        this.nomevaga = nomeVaga;
    }
    public int getLongitudeInicial() {
        return longitudeinicial;
    }
    public void setLongitudeInicial(int longitudeInicial) {
        this.longitudeinicial = longitudeInicial;
    }
    public int getLongitudeFinal() {
        return longitudefinal;
    }
    public void setLongitudeFinal(int longitudeFinal) {
        this.longitudefinal = longitudeFinal;
    }
    public int getLatitudeInicial() {
        return latitudeinicial;
    }
    public void setLatitudeInicial(int latitudeInicial) {
        this.latitudeinicial = latitudeInicial;
    }
    public int getLatitudeFinal() {
        return latitudefinal;
    }
    public void setLatitudeFinal(int latitudeFinal) {
        this.latitudefinal = latitudeFinal;
    }
    public Time getHorarioUsoInica() {
        return horariousoinica;
    }
    public void setHorarioUsoInica(Time horarioUsoInica) {
        this.horariousoinica = horarioUsoInica;
    }
    public Time getHorarioUsoFinal() {
        return horariousofinal;
    }
    public void setHorarioUsoFinal(Time horarioUsoFinal) {
        this.horariousofinal = horarioUsoFinal;
    }
    public boolean isEstadoVaga() {
        return estadovaga;
    }
    public void setEstadoVaga(boolean estadoVaga) {
        this.estadovaga = estadoVaga;
    }
      

     

  
    
}
