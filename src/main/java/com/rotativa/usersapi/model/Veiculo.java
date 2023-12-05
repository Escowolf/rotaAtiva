package com.rotativa.usersapi.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    public Veiculo(Long id, String cor, String placa, String modelo) {
        this.id = id;
        this.cor = cor;
        this.placa = placa;
        this.modelo = modelo;
    }
    public Veiculo(){}

    @Column(name = "cor")
    private String cor;

    @Column(name = "placa")
    private String placa;

    @Column(name = "modelo")
    private String modelo;

    public Long getId() {
        return this.id;
    }

    public Veiculo id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCor() {
        return this.cor;
    }

    public Veiculo cor(String cor) {
        this.setCor(cor);
        return this;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return this.placa;
    }

    public Veiculo placa(String placa) {
        this.setPlaca(placa);
        return this;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public Veiculo modelo(String modelo) {
        this.setModelo(modelo);
        return this;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Veiculo)) {
            return false;
        }
        return id != null && id.equals(((Veiculo) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Veiculo{" +
            "id=" + getId() +
            ", cor='" + getCor() + "'" +
            ", placa='" + getPlaca() + "'" +
            ", modelo='" + getModelo() + "'" +
            "}";
    }
}
