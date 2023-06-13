package br.com.unipar.Hospital.Controller;

import br.com.unipar.Hospital.Model.Endereco;
import br.com.unipar.Hospital.Service.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/endereco")
@Api(description = "Controlador Rest Responsavel pela Operações que representam o objeto de Negócios Endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    @ApiOperation(value = "Operação Responsavel pela inserção de um novo endereço no sistema")
    public Endereco insertEndereco(@RequestBody Endereco endereco) throws Exception{
        return enderecoService.insert(endereco);
    }

    @PutMapping
    @ApiOperation(value = "Operação Responsavel pela atualizacao de um endereço no sistema")
    public Endereco updateEndereco(@RequestBody Endereco endereco) throws Exception{
        return enderecoService.update(endereco);
    }

    @GetMapping
    @ApiOperation(value = "Operação Responsavel pela consulta de todos os endereços do sistema")
    public List<Endereco> findAll() throws Exception {
        return enderecoService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Operação Responsavel pela consulta de um endereço do sistema")
    public Endereco findById(@PathVariable Long id) throws Exception {
        return enderecoService.findById(id);
    }

}

