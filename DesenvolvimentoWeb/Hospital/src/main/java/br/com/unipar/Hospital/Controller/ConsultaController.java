package br.com.unipar.Hospital.Controller;

import br.com.unipar.Hospital.DTO.ConsultaDto;
import br.com.unipar.Hospital.Model.Consulta;
import br.com.unipar.Hospital.Service.ConsultaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/consulta")
@Api(description = "Controlador Rest Responsavel pela Operações que representam o objeto de Negócios Consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @ApiOperation(value = "Operação Responsavel pela agendar uma nova consulta no sistema")
    public ConsultaDto insertConsulta(@RequestBody Consulta consulta) throws Exception{
        return consultaService.insert(consulta);
    }

    @PutMapping(path = "/cancelar")
    @ApiOperation(value = "Operação Responsavel pela cancelar uma consulta no sistema")
    public Consulta cancelaConsulta(@RequestBody Consulta consulta)throws Exception{
        return consultaService.cancelaConsulta(consulta);
    }

    @GetMapping
    @ApiOperation(value = "Operação Responsavel por buscar todas as consultas do sistema")
    public List<Consulta> findAll() {
        return consultaService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Operação Responsavel por buscar uma unica consulta no sistema")
    public Consulta findById(@PathVariable Long id) throws Exception {
        return consultaService.findById(id);
    }
}