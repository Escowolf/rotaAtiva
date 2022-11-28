package com.rotativa.usersapi.Entidades;
/* Este projeto utiliza SpringBoot. Para que o Spring reconheça as elementos 
do projeto eles devem ser criados dentro da pasta userapi*/
import javax.persistence.Entity; //O uso de @Entity identifica uma classe como Entidade
import javax.persistence.Id; //identificando chave primária para o framework
import javax.persistence.Table;

@Entity
@Table(name = "veiculo", schema = "rotaativa")
public class VeiculoModel {
  @Id
  private int idveiculo;
  private String cor;
  private String placa;
  private String modelo;

  public int getIdveiculo() {
    return idveiculo;
  }

  public void setIdveiculo(int idveiculo) {
    this.idveiculo = idveiculo;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

}
