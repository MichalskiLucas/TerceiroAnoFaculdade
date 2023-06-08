package br.com.unipar.Hospital.Controller;

import br.com.unipar.Hospital.Model.Endereco;
import br.com.unipar.Hospital.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco insertEndereco(@RequestBody Endereco endereco) throws Exception{
        return enderecoService.insert(endereco);
    }

    @PutMapping
    public Endereco updateEndereco(@RequestBody Endereco endereco) throws Exception{
        return enderecoService.update(endereco);
    }

    @GetMapping
    public List<Endereco> findAll() throws Exception {
        return enderecoService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Endereco findById(@PathVariable Long id) throws Exception {
        return enderecoService.findById(id);
    }

}

