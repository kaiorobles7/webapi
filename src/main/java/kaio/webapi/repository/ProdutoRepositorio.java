package kaio.webapi.repository;

import kaio.webapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
}
