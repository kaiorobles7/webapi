package kaio.webapi.controller;


import kaio.webapi.model.Usuario;
import kaio.webapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired

    private UsuarioService service;
    @GetMapping()
    public List<Usuario> getUsers(){
        return service.buscarUsuarios();
    }
    @GetMapping("/{login}")
    public List<Usuario> getUsers(@PathVariable String login){
        return service.buscarUsuario(login);
    }
@PostMapping("/create")
    public Usuario createUsers(@RequestBody Usuario usuario){
        return service.criarUsuario(usuario);
}
@PutMapping("/atualizar")
    public Optional<Usuario> putUsers(@RequestBody Usuario usuario){
        return service.atualizarUsuario(usuario);
}
@DeleteMapping("/delete/{id}")
    public List<Usuario> deleteUsers(@PathVariable Long id){
        return service.deletarUsuario(id);
}
}