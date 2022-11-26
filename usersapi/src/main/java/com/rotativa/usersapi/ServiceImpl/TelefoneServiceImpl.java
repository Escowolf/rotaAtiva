package com.rotativa.usersapi.ServiceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotativa.usersapi.Entidades.Telefone;
import com.rotativa.usersapi.repository.TelefoneRepository;
import com.rotativa.usersapi.services.TelefoneService;

@Service
@Transactional
public class TelefoneServiceImpl implements TelefoneService {

    private final TelefoneRepository telefoneRepository;

    public TelefoneServiceImpl(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    @Override
    public Telefone save(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    @Override
    public Telefone update(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    @Override
    public Optional<Telefone> partialUpdate(Telefone telefone) {

        return telefoneRepository
            .findById(telefone.getId())
            .map(existingTelefone -> {
                if (telefone.getNumero() != null) {
                    existingTelefone.setNumero(telefone.getNumero());
                }

                return existingTelefone;
            })
            .map(telefoneRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Telefone> findAll() {
        return telefoneRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Telefone> findOne(Long id) {
        return telefoneRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        telefoneRepository.deleteById(id);
    }
}
