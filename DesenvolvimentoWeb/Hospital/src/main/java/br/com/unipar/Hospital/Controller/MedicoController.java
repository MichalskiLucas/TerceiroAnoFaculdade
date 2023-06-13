package br.com.unipar.Hospital.Controller;

import br.com.unipar.Hospital.DTO.MedicoDto;
import br.com.unipar.Hospital.Model.Medico;
import br.com.unipar.Hospital.Service.MedicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/medico")
@Api(description = "Controlador Rest Responsavel pela Operações que representam o objeto de Negócios Medico")

public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @ApiOperation(value = "Operação Responsavel pela inserção de um novo medico no sistema")
    public Medico insertPaciente(@RequestBody Medico paciente) throws Exception{
        return medicoService.insert(paciente);
    }

    @PutMapping
    @ApiOperation(value = "Operação Responsavel pela atualização de um medico no sistema")
    public Medico updatePaciente(@RequestBody Medico paciente) throws Exception{
        return medicoService.update(paciente);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Operação Responsavel pela inativação de um medico no sistema")
    public Medico deleteMedico(@PathVariable Long id) throws Exception{
        return medicoService.deletaMedico(id);
    }

    @GetMapping
    @ApiOperation(value = "Operação Responsavel pela consulta de todos os medicos do sistema")
    public List<MedicoDto> findAll() throws Exception {
        return medicoService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Operação Responsavel pela consulta de um medico no sistema")
    public Medico findById(@PathVariable Long id) throws Exception {
        return medicoService.findById(id);
    }
}