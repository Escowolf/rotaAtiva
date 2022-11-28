package com.rotativa.usersapi.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotativa.usersapi.model.Pagamento;
import com.rotativa.usersapi.repository.PagamentoRepository;
import com.rotativa.usersapi.services.PagamentoService;

@Service
@Transactional
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public Pagamento update(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public Optional<Pagamento> partialUpdate(Pagamento pagamento) {

        return pagamentoRepository
            .findById(pagamento.getId())
            .map(existingPagamento -> {
                if (pagamento.getDataCompra() != null) {
                    existingPagamento.setDataCompra(pagamento.getDataCompra());
                }
                if (pagamento.getValor() != null) {
                    existingPagamento.setValor(pagamento.getValor());
                }
                if (pagamento.getQuantidadeTicket() != null) {
                    existingPagamento.setQuantidadeTicket(pagamento.getQuantidadeTicket());
                }

                return existingPagamento;
            })
            .map(pagamentoRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pagamento> findOne(Long id) {
        return pagamentoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
