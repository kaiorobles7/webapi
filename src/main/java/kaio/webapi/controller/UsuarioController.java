package kaio.webapi.controller;



import kaio.webapi.model.Usuario;
import kaio.webapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UserRepository repository;
    @GetMapping()
    public List<Usuario> getUsers(){
        return repository.findAll();
    }
    @GetMapping("/{login}")
    public Usuario getOne(@PathVariable String login){
        return repository.findByUsername(login);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(Integer id){
        repository.deleteById(id);
    }
    @PostMapping()
    public void postUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
}