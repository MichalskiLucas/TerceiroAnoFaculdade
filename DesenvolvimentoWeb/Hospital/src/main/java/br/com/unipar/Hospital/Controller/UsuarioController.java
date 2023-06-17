package br.com.unipar.Hospital.Controller;

import br.com.unipar.Hospital.Model.Medico;
import br.com.unipar.Hospital.Model.Usuario;
import br.com.unipar.Hospital.Service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario insertUsuario(@RequestBody Usuario usuario) throws Exception{
        return usuarioService.insert(usuario);
    }


    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Usuario findById(@PathVariable Long id) throws Exception {
        return usuarioService.findById(id);
    }
    
    @DeleteMapping(path = "/{id}")
    public Usuario delete(@PathVariable Long id) throws Exception{
        return usuarioService.delete(id);
    }
}