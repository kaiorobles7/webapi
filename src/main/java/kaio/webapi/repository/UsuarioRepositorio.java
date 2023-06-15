package kaio.webapi.repository;

import kaio.webapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    // Métodos personalizados, se necessário
}