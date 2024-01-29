package com.rotativa.usersapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.rotativa.usersapi.model.Vaga;
import com.rotativa.usersapi.services.VagaService;

// possui as operações operações básicas para manipular o usuário no bd
@CrossOrigin(origins = "http://localhost:3000") // Permite que o back envie e receba dados de uma origem diferente
@RestController
@RequestMapping("/zona")
public class VagaController {
  @Autowired // o spring cria o objeto, injeta no atributo repositório
  VagaService vagaService;

  @GetMapping("/auth/user/vagas")
  public List<Vaga> listar() {
    return vagaService.findAll();
  }

  @PostMapping("/auth/user/save")
  public void salvar(@RequestBody Vaga vaga) {
    vagaService.save(vaga);
  }

  @PutMapping
  public void alterar(@RequestBody Vaga vaga) {
    vagaService.update(vaga);
  }

  /*
   * @GetMapping("/tempoUso")
   * public List<Time> tempoUso() {
   * List<Time> vagas = vagaService.tempoDeUsoVaga();
   * return vagas;
   * }
   */
  // @GetMapping("/endereco")
  // public List<List<String>> enderecoVaga() {
  // List<List<String>> retorno = vagaService.enderecoVaga();
  // return retorno;
  // }
  // @GetMapping("/relatorio")
  // List<List<String>> relatorioFinanceiro() {
  // List<List<String>> retorno = vagaService.relatorioFinanceiro();
  // return retorno;
  // }

  // @GetMapping("/relatorioPorVaga")
  // List<List<String>> relatorioFinanceiroPorVaga(@RequestParam("nome") String
  // nome) {
  // List<List<String>> retorno = vagaService.relatorioFinanceiroPorVaga(nome);
  // return retorno;
  // }

  // @GetMapping("/relatorioRank")
  // List<List<String>> relatorioFinanceioRank() {
  // List<List<String>> retorno = vagaService.relatorioRank();
  // return retorno;
  // }
  @GetMapping("/buscar")
  List<Vaga> buscarVaga(@RequestParam("nome") String nome) {
    List<Vaga> retorno = vagaService.buscarVaga(nome);
    return retorno;
  }

  // @GetMapping("/teste")
  // String teste(@RequestParam("nome") String nome) {
  // String nomeTeste = "oi";
  // if (nomeTeste.equals(nome)) {
  // return "Deu certo";
  // } else {
  // return "Errado";
  // }

  // }

  // @PutMapping("/ativar")
  // public String ativarVaga(@RequestParam("nome") String nome) {
  // vagaService.ativarVaga(nome);
  // return "oi";

  // }

  @GetMapping("/auth/user/disponiveis")
  public ResponseEntity<List<Vaga>> obterVagasDisponiveis() {
    List<Vaga> vagasDisponiveis = vagaService.vagasDisponiveis();
    return ResponseEntity.ok(vagasDisponiveis);
  }

  @DeleteMapping
  public void desativarVaga(@RequestParam("id") String id) {

    vagaService.delete(Long.parseLong(id));

  }

}
