// package com.rotativa.usersapi.ServiceImpl;

// import java.util.List;
// import java.util.Optional;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.rotativa.usersapi.Entidades.administradr;
// import com.rotativa.usersapi.repository.AdministradoRepository;
// import com.rotativa.usersapi.services.AdministradorService;

// @Service
// @Transactional
// public class AdministradorServiceImpl implements AdministradorService {

//     private final AdministradoRepository administradorRepository;

//     public AdministradorServiceImpl(AdministradoRepository administradorRepository) {
//         this.administradorRepository = administradorRepository;
//     }

//     @Override
//     public administradr save(administradr administrador) {
//         return administradorRepository.save(administrador);
//     }

//     @Override
//     public administradr update(administradr administrador) {
//         return administradorRepository.save(administrador);
//     }

//     @Override
//     public Optional<administradr> partialUpdate(administradr administrador) {

//         return administradorRepository
//             .findById(administrador.getId())
//             .map(existingAdministrador -> {
//                 if (administrador.getNome() != null) {
//                     existingAdministrador.setNome(administrador.getNome());
//                 }
//                 if (administrador.getCpf() != null) {
//                     existingAdministrador.setCpf(administrador.getCpf());
//                 }
//                 if (administrador.getEmail() != null) {
//                     existingAdministrador.setEmail(administrador.getEmail());
//                 }
//                 if (administrador.getNascimento() != null) {
//                     existingAdministrador.setNascimento(administrador.getNascimento());
//                 }
//                 if (administrador.getSenha() != null) {
//                     existingAdministrador.setSenha(administrador.getSenha());
//                 }

//                 return existingAdministrador;
//             })
//             .map(administradorRepository::save);
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public List<administradr> findAll() {
//         return administradorRepository.findAll();
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public Optional<administradr> findOne(Long id) {
//         return administradorRepository.findById(id);
//     }

//     @Override
//     public void delete(Long id) {
//         administradorRepository.deleteById(id);
//     }
// }
