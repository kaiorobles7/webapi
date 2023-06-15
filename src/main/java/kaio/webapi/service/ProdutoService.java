package kaio.webapi.service;

import kaio.webapi.model.Produto;
import kaio.webapi.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorio prepository;

    public ProdutoService(ProdutoRepositorio prepository) {
        this.prepository = prepository;
    }

    public Produto criarUsuario(Produto produto) {
        // Lógica para criar um novo usuário
        return prepository.save(produto);
    }

    public List<Produto> buscarUsuarios(){
        return prepository.findAll();
    }

    public Optional<Produto> buscarUsuario(Long id) {
        // Lógica para buscar um usuário pelo ID
        return prepository.findById(id);
    }

    public Optional<Produto> atualizarUsuario(Long id, Produto produto) {//put
        // Lógica para atualizar um usuário existente
        Optional<Produto> usuarioExistente = prepository.findById(id);
        if (usuarioExistente.isPresent()) {
            produto.setId(id);
            return Optional.of(prepository.save(produto));
        }
        return Optional.empty();
    }

    public List<Produto> deletarUsuario(Long id) {
        prepository.deleteById(id);
        return prepository.findAll();
    }
}

