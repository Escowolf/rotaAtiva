package com.rotativa.usersapi.integration;

import javax.persistence.TableGenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rotativa.usersapi.services.*;
import com.rotativa.usersapi.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;

@SpringBootTest
public class Testes {
    
    @Autowired
    private VagaService vagaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VeiculoService veiculoService;

    @Test
    public void buscarToken() {

    }

    @Test
    public void BuscarUsuarioQueUtilizaUmaVaga() {
        Usuario usuario = new Usuario();
        List<Usuario> busca = this.usuarioService.getUsuariosVaga("Northwestern");
        Set<Transacao> trasacao = busca.get(0).getTransacoes();

        /* Assertions.assertEquals(18,trasacao.contains('));  */
    }


    @Test
    public void buscarVagaPorNome() {
        Vaga vaga = new Vaga();
        List<Vaga> busca = this.vagaService.buscarVaga("Mayfield");

    
        Assertions.assertEquals("Mayfield", busca.get(0).getNome());
        Assertions.assertEquals(2, busca.get(0).getId());
        Assertions.assertEquals("Czajkowska", busca.get(0).getBairro());
    }
    

    @Test
    public void registroVagaSistema() {
        Vaga vaga = new Vaga(123456789L,
                "Vaga 123456789",
                "Rua A",
                "Parangaba",
                true,
                23.5489,
                23.5495,
                46.6388,
                46.6395,
                10,
                2,
                30);

        Vaga busca = this.vagaService.save(vaga);

        Assertions.assertEquals(vaga.getNome(), busca.getNome());
        Assertions.assertEquals(vaga.getBairro(), busca.getBairro());
        Assertions.assertEquals(vaga.getTotalVeiculos(), busca.getTotalVeiculos());
        Assertions.assertEquals(true, busca.getAcessibilidade());
        Assertions.assertEquals(vaga.getLatitudeInicial(), busca.getLatitudeInicial());
        Assertions.assertEquals(vaga.getLatitudeFinal(), busca.getLatitudeFinal());
        Assertions.assertEquals(vaga.getLongitudeInicial(), busca.getLongitudeInicial());
        Assertions.assertEquals(vaga.getLongitudeFinal(), busca.getLongitudeFinal());
    }

    @Test
    public void registroUsuarioNoSistema() {

        Usuario usuario = new Usuario(
                12345L,
                "123.456.789-00",
                "João Silva",
                true,
                "joao.silva@gmail.com",
                "senha123",
                LocalDate.of(1990, 5, 10),
                5,
                false/* ,new ArrayList<Pagamento>(), new ArrayList<Telefone>(), new ArrayList<Transacao>(), new ArrayList<Veiculo>() */
        );
        Usuario busca = this.usuarioService.save(usuario);

        Assertions.assertEquals(usuario.getCpf(), busca.getCpf());
        Assertions.assertEquals(usuario.getEstado(), busca.getEstado());
        Assertions.assertEquals(usuario.getNome(), busca.getNome());
        Assertions.assertEquals(usuario.getTelefones(), busca.getTelefones());
        Assertions.assertEquals(usuario.getEmail(), busca.getEmail());
        Assertions.assertEquals(usuario.getPassword(), busca.getPassword());
    }

    @Test
    public void cadastrandoVeiculo() {
        Veiculo veiculo = new Veiculo(
        3000L,
        "preto",
        "ABC-2530",
        "Colora");

        Veiculo busca = veiculoService.save(veiculo);

        
        Assertions.assertEquals(veiculo.getCor(),busca.getCor());
        Assertions.assertEquals(veiculo.getModelo(),busca.getModelo());
        Assertions.assertEquals(veiculo.getPlaca(),busca.getPlaca());

    }

   
    
    public void validandoLoginUsuario() {
    }
}
