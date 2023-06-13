package br.com.unipar.Hospital.Controller;

import br.com.unipar.Hospital.DTO.PacienteDto;
import br.com.unipar.Hospital.Model.Paciente;
import br.com.unipar.Hospital.Service.PacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/paciente")
@Api(description = "Controlador Rest Responsavel pela Operações que representam o objeto de Negócios Paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @ApiOperation(value = "Operação Responsavel pela inserção de um novo paciente no sistema")
    public Paciente insertPaciente(@RequestBody Paciente paciente) throws Exception{
        return pacienteService.insertPaciente(paciente);
    }

    @PutMapping
    @ApiOperation(value = "Operação Responsavel pela atualização de um paciente no sistema")
    public Paciente updatePaciente(@RequestBody Paciente paciente) throws Exception{
        return pacienteService.update(paciente);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Operação Responsavel pela inativação de um paciente no sistema")
    public Paciente deletePaciente(@PathVariable Long id) throws Exception{
        return pacienteService.deletaPaciente(id);
    }

    @GetMapping
    @ApiOperation(value = "Operação Responsavel pela consulta de todos os pacientes do sistema")
    public List<PacienteDto> findAll() throws Exception {
        return pacienteService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Operação Responsavel pela consulta de um dos pacientes dos sistema")
    public Paciente findById(@PathVariable Long id) throws Exception {
        return pacienteService.findById(id);
    }
}