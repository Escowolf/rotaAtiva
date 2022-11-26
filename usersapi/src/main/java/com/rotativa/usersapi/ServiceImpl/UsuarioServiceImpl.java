package com.rotativa.usersapi.ServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rotativa.usersapi.Entidades.Usuari;
import com.rotativa.usersapi.repository.UsuarioRepository;
import com.rotativa.usersapi.services.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuari save(Usuari usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuari update(Usuari usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuari> partialUpdate(Usuari usuario) {

        return usuarioRepository
            .findById(usuario.getId())
            .map(existingUsuario -> {
                if (usuario.getCpf() != null) {
                    existingUsuario.setCpf(usuario.getCpf());
                }
                if (usuario.getNome() != null) {
                    existingUsuario.setNome(usuario.getNome());
                }
                if (usuario.getAcessibilidade() != null) {
                    existingUsuario.setAcessibilidade(usuario.getAcessibilidade());
                }
                if (usuario.getEmail() != null) {
                    existingUsuario.setEmail(usuario.getEmail());
                }
                if (usuario.getSenha() != null) {
                    existingUsuario.setSenha(usuario.getSenha());
                }
                if (usuario.getNascimento() != null) {
                    existingUsuario.setNascimento(usuario.getNascimento());
                }
                if (usuario.getTicket() != null) {
                    existingUsuario.setTicket(usuario.getTicket());
                }
                if (usuario.getEstado() != null) {
                    existingUsuario.setEstado(usuario.getEstado());
                }

                return existingUsuario;
            })
            .map(usuarioRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuari> findAll() {
        return usuarioRepository.findAllWithEagerRelationships();
    }

    public Page<Usuari> findAllWithEagerRelationships(Pageable pageable) {
        return usuarioRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuari> findOne(Long id) {
        return usuarioRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    // @Override
    // public List<Usuari> getUsuariosVaga(String nome) {
    //     return usuarioRepository.getUsuariosVaga(nome);
    // }
}
