package com.rotativa.usersapi.Services;
import java.sql.Time;
// interface criada em arquivo separado para manter a privacidade da implementação dos métodos.
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.rotativa.usersapi.Entidades.*;

@Component
public interface VagaService {

    public List<Time> tempoDeUsoVaga();

    public List<List<String>> enderecoVaga();

    List<List<String>> relatorioFinanceiro();

    List<List<String>> relatorioRank();

    List<List<String>> relatorioFinanceiroPorVaga(@Param("nome") String nome );
 
    public List<VagasModel> listar();
    
    public void salvar(VagasModel vagas);

    public void alterar(VagasModel vagas);

    public void excluir(VagasModel vagas);

    List<List<String>> buscarVaga(@Param("nome") String nome);

    void desativarVaga(@Param("nome") String nome);

    void ativarVaga(@Param("nome") String nome);
}