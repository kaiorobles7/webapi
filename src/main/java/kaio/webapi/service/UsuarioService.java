package kaio.webapi.service;

import kaio.webapi.model.Usuario;
import kaio.webapi.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio repository;

    public Usuario criarUsuario(Usuario usuario) {
        // Lógica para criar um novo usuário
        return repository.save(usuario);
    }

    public List<Usuario> buscarUsuarios(){
        return repository.findAll();
    }

    public Optional<Usuario> buscarUsuario(Long id) {
        // Lógica para buscar um usuário pelo ID
        return repository.findById(id);
    }

    public Optional<Usuario> atualizarUsuario(Long id, Usuario usuario) {//put
        // Lógica para atualizar um usuário existente
        Optional<Usuario> usuarioExistente = repository.findById(id);
        if (usuarioExistente.isPresent()) {
            usuario.setId(id);
            return Optional.of(repository.save(usuario));
        }
        return Optional.empty();
    }

    public List<Usuario> deletarUsuario(Long id) {
            repository.deleteById(id);
      return repository.findAll();
    }
}
