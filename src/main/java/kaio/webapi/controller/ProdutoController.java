package kaio.webapi.controller;

import kaio.webapi.model.Produto;
import kaio.webapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProdutoController {

    @Autowired
    private ProdutoService pservice;
    @GetMapping()
    public List<Produto> getUsers(){
        //  return repository.findAll();
        return pservice.buscarUsuarios();
    }
    @PostMapping("/create")
    public Produto createUsers(@RequestBody Produto produto){
        return pservice.criarUsuario(produto);
    }
    @PutMapping("/atualizar")
    public Optional<Produto> putUsers(@RequestBody Produto produto){
        return Optional.ofNullable(pservice.criarUsuario(produto));
    }
    @DeleteMapping("/delete/{id}")
    public List<Produto> deleteUsers(@PathVariable Long id){
        return pservice.deletarUsuario(id);
    }
}
