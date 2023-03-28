package com.rotativa.usersapi.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotativa.usersapi.model.TipoPagamento;
import com.rotativa.usersapi.repository.TipoPagamentoRepository;
import com.rotativa.usersapi.services.TipoPagamentoService;

@Service
@Transactional
public class TipoPagamentoServiceImpl implements TipoPagamentoService {

    private final TipoPagamentoRepository tipoPagamentoRepository;

    public TipoPagamentoServiceImpl(TipoPagamentoRepository tipoPagamentoRepository) {
        this.tipoPagamentoRepository = tipoPagamentoRepository;
    }

    @Override
    public TipoPagamento save(TipoPagamento tipoPagamento) {
        return tipoPagamentoRepository.save(tipoPagamento);
    }

    @Override
    public TipoPagamento update(TipoPagamento tipoPagamento) {
        return tipoPagamentoRepository.save(tipoPagamento);
    }

    @Override
    public Optional<TipoPagamento> partialUpdate(TipoPagamento tipoPagamento) {

        return tipoPagamentoRepository
            .findById(tipoPagamento.getId())
            .map(existingTipoPagamento -> {
                if (tipoPagamento.getNome() != null) {
                    existingTipoPagamento.setNome(tipoPagamento.getNome());
                }
                if (tipoPagamento.getDescricao() != null) {
                    existingTipoPagamento.setDescricao(tipoPagamento.getDescricao());
                }

                return existingTipoPagamento;
            })
            .map(tipoPagamentoRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoPagamento> findAll() {
        return tipoPagamentoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoPagamento> findOne(Long id) {
        return tipoPagamentoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        tipoPagamentoRepository.deleteById(id);
    }
}