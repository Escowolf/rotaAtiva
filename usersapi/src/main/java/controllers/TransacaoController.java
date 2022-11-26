package controllers;

import java.util.List;

import com.rotativa.usersapi.Entidades.Transacao;
import com.rotativa.usersapi.services.TransacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000") //Permite que o back envie e receba dados de uma origem diferente
@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired //o spring cria o objeto, injeta no atributo repositório
	TransacaoService transacaoService;

    @GetMapping
    public List<Transacao> listar(){
        return transacaoService.findAll();
    }

    @GetMapping("/usuarios")
    public List<Transacao> getTransacao(@RequestParam("nome") String nome){
        return transacaoService.getTransacoes(nome);
    }

    @PostMapping
    public void salvar(@RequestBody Transacao transacao){
        transacaoService.save(transacao);
    }

    @PutMapping
    public void alterar(@RequestBody Transacao transacao){
        transacaoService.update(transacao);
    }

}
