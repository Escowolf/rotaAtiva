package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rotativa.usersapi.Entidades.*;
import com.rotativa.usersapi.services.PagamentoService;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired 
	PagamentoService pagamentoService;

    @GetMapping("/listarTodos")
    public List<Pagamento> listar(){
        return pagamentoService.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Pagamento pagamento){
        pagamentoService.save(pagamento);
    }

    @PutMapping
    public void alterar(@RequestBody Pagamento pagamento){
        pagamentoService.update(pagamento);
    }

}