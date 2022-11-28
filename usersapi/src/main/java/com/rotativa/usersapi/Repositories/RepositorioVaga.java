package com.rotativa.usersapi.Repositories;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rotativa.usersapi.Entidades.*;

/* teste */

public interface RepositorioVaga extends JpaRepository<VagasModel, Long> {

    @Query(value = "select v.rua_avenida, v.bairro  from vaga v", nativeQuery = true)
    List<List<String>> enderecoVaga();

    @Query(value = "SELECT TIMEDIFF(v.saida,v.entrada)  FROM vaga v  ", nativeQuery = true)
    List<Time> tempoDeUsoVaga();

    @Query(value = "select v.nomeVaga,sum(t.ticketsUsados) as ticketsUsados ,count(ve.placa) as total_veiculos,sec_to_time((sum(time_to_sec(timediff( t.saida,t.entrada))))) as tempoUso from usuario u "+
    "join transacao t "+
    "on u.idusuario = t.usuario_idusuario "+
    "join vaga v "+
    "on v.idvaga = t.vaga_idvaga "+
    "join usuario_has_veiculo hv "+
    "on u.idusuario = hv.usuario_idusuario "+
    "join veiculo ve "+
    "on ve.idveiculo = hv.veiculo_idveiculo "+
    "group by v.nomeVaga "+
    "order by v.nomeVaga ", nativeQuery = true)
    List<List<String>> relatorioFinanceiro();

    
    @Query(value = "select v.nomeVaga,u.nome,timediff( t.saida,t.entrada) as tempoUso,t.ticketsUsados as ticketsUsados ,ve.modelo,ve.placa,u.acessibilidade from usuario u "+
    "join transacao t "+
    "on u.idusuario = t.usuario_idusuario "+
    "join vaga v "+
    "on v.idvaga = t.vaga_idvaga "+
    "join usuario_has_veiculo hv "+
    "on u.idusuario = hv.usuario_idusuario "+
    "join veiculo ve "+
    "on ve.idveiculo = hv.veiculo_idveiculo "+
     "where v.nomeVaga = :nome and estadovaga = 1" , nativeQuery = true) 
    List<List<String>> relatorioFinanceiroPorVaga(@Param("nome") String nome);
    
    @Query(value = "select v.nomeVaga,sum(t.ticketsUsados) as ticketsUsados ,count(ve.placa) as total_veiculos,sec_to_time((sum(time_to_sec(timediff( t.saida,t.entrada))))) as tempoUso from usuario u "+
    "join transacao t "+
    "on u.idusuario = t.usuario_idusuario "+
    "join vaga v "+
    "on v.idvaga = t.vaga_idvaga "+
    "join usuario_has_veiculo hv "+
    "on u.idusuario = hv.usuario_idusuario "+
    "join veiculo ve "+
    "on ve.idveiculo = hv.veiculo_idveiculo "+
    "group by v.nomeVaga "+
    "order by tempoUso desc", nativeQuery = true)
    List<List<String>> relatorioRank();

    @Query(value = "select idvaga,nomeVaga,rua_avenida,bairro,acessibilidade,longitudeInicial,longitudeFinal,latitudeInicial,latitudeFinal,horarioUsoInica,horarioUsoFinal,tempoTicket,estadoVaga from vaga v "+
    "where nomeVaga = :nome and estadovaga = 1", nativeQuery = true)
    List<List<String>> buscarVaga(String nome);

    @Modifying
    @Query(value = "UPDATE vaga "+
    "SET estadoVaga = 0 "+
    "where nomevaga = :nome" , nativeQuery = true) 
    void desativarVaga(@Param("nome") String nome);
    
    @Modifying
    @Query(value = "UPDATE vaga "+
    "SET estadoVaga = 1 "+
    "where nomevaga = :nome" , nativeQuery = true) 
    void ativarVaga(@Param("nome")String nome);



}


//

 