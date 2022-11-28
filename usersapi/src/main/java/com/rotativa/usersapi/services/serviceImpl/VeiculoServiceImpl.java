package com.rotativa.usersapi.services.serviceImpl;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotativa.usersapi.model.Veiculo;
import com.rotativa.usersapi.repository.VeiculoRepository;
import com.rotativa.usersapi.services.VeiculoService;

@Service
@Transactional
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Veiculo update(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Optional<Veiculo> partialUpdate(Veiculo veiculo) {

        return veiculoRepository
            .findById(veiculo.getId())
            .map(existingVeiculo -> {
                if (veiculo.getCor() != null) {
                    existingVeiculo.setCor(veiculo.getCor());
                }
                if (veiculo.getPlaca() != null) {
                    existingVeiculo.setPlaca(veiculo.getPlaca());
                }
                if (veiculo.getModelo() != null) {
                    existingVeiculo.setModelo(veiculo.getModelo());
                }

                return existingVeiculo;
            })
            .map(veiculoRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Veiculo> findOne(Long id) {
        return veiculoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        veiculoRepository.deleteById(id);
    }
}
