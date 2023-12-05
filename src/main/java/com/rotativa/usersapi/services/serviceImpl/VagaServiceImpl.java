package com.rotativa.usersapi.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotativa.usersapi.model.Vaga;
import com.rotativa.usersapi.repository.VagaRepository;
import com.rotativa.usersapi.services.VagaService;

@Service
@Transactional
public class VagaServiceImpl implements VagaService {

    private final VagaRepository vagaRepository;

    public VagaServiceImpl(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @Override
    public Vaga save(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    @Override
    public Vaga update(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    @Override
    public Optional<Vaga> partialUpdate(Vaga vaga) {

        return vagaRepository
            .findById(vaga.getId())
            .map(existingVaga -> {
                if (vaga.getLogradouro() != null) {
                    existingVaga.setLogradouro(vaga.getLogradouro());
                }
                if (vaga.getBairro() != null) {
                    existingVaga.setBairro(vaga.getBairro());
                }
                if (vaga.getAcessibilidade() != null) {
                    existingVaga.setAcessibilidade(vaga.getAcessibilidade());
                }
                if (vaga.getNome() != null) {
                    existingVaga.setNome(vaga.getNome());
                }
                if (vaga.getLongitudeInicial() != null) {
                    existingVaga.setLongitudeInicial(vaga.getLongitudeInicial());
                }
                if (vaga.getLongitudeFinal() != null) {
                    existingVaga.setLongitudeFinal(vaga.getLongitudeFinal());
                }
                if (vaga.getLatitudeInicial() != null) {
                    existingVaga.setLatitudeInicial(vaga.getLatitudeInicial());
                }
                if (vaga.getLatitudeFinal() != null) {
                    existingVaga.setLatitudeFinal(vaga.getLatitudeFinal());
                }

                return existingVaga;
            })
            .map(vagaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Vaga> findOne(Long id) {
        return vagaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        vagaRepository.deleteById(id);
    }

    @Override
    public List<Vaga> buscarVaga(String nome) {
        return vagaRepository.buscarVaga(nome);
    }
}
