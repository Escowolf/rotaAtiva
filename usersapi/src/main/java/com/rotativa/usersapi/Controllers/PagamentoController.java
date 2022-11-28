package com.rotativa.usersapi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rotativa.usersapi.Entidades.*;
import com.rotativa.usersapi.Services.PagamentoService;
// possui as operações operações básicas para manipular o usuário no bd
@CrossOrigin(origins = "http://localhost:3000") //Permite que o back envie e receba dados de uma origem diferente
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired //o spring cria o objeto, injeta no atributo repositório
	PagamentoService pagamentoService;

    @GetMapping
    public List<PagamentoModel> listar(){
        return pagamentoService.listar();
    }

    @PostMapping
    public void salvar(@RequestBody PagamentoModel pagamento){
        pagamentoService.salvar(pagamento);
    }

    @PutMapping
    public void alterar(@RequestBody PagamentoModel pagamento){
        pagamentoService.alterar(pagamento);
    }

    @DeleteMapping
    public void excluir(@RequestBody PagamentoModel pagamento){
        pagamentoService.excluir(pagamento);
    }

}