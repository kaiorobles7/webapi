package kaio.webapi.service;

import kaio.webapi.model.Setor;
import kaio.webapi.model.Usuario;
import kaio.webapi.repository.SetorRepositorio;
import kaio.webapi.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio repository;

    @Autowired
    private SetorRepositorio setorRepositorio;

    public Usuario criarUsuario(Usuario usuario) {
        // Lógica para criar um novo usuário
        return repository.save(usuario);
    }

    public List<Usuario> buscarUsuarios(){
        return repository.findAll();
    }

    public List<Usuario> buscarUsuario(String login) {
        // Lógica para buscar um usuário pelo ID
        return repository.findByLogin(login);
    }

    public Optional<Usuario> atualizarUsuario( Usuario usuario) {//put
        // Lógica para atualizar um usuário existente
        Optional<Usuario> usuarioExistente = repository.findById(usuario.getId());
        if (usuarioExistente.isPresent()) {
            return Optional.of(repository.save(usuario));
        }
        return Optional.empty();
    }

    public List<Usuario> deletarUsuario(Long id) {
            repository.deleteById(id);
      return repository.findAll();
    }

    public List<Usuario> atualizarUsuariosComSetor(Long setorId, List<Usuario> usuarios) {
        Optional<Setor> setor = setorRepositorio.findById(setorId);

        for (Usuario usuario : usuarios) {
            usuario.setSetor(setor.get());
            repository.save(usuario);
        }

        return usuarios;
    }


    public List<Usuario> buscarUsuariosPorSetor(Long setorId) {
        Optional<Setor> setor = setorRepositorio.findById(setorId);
       return repository.findBySetor(setor.get());

    }
}

