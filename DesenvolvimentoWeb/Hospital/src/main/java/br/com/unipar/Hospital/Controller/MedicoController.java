package br.com.unipar.Hospital.Controller;

import br.com.unipar.Hospital.DTO.MedicoDto;
import br.com.unipar.Hospital.Model.Medico;
import br.com.unipar.Hospital.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public Medico insertPaciente(@RequestBody Medico paciente) throws Exception{
        return medicoService.insert(paciente);
    }

    @PutMapping
    public Medico updatePaciente(@RequestBody Medico paciente) throws Exception{
        return medicoService.update(paciente);
    }

    @DeleteMapping(path = "/{id}")
    public Medico deleteMedico(@PathVariable Long id) throws Exception{
        return medicoService.deletaMedico(id);
    }

    @GetMapping
    public List<MedicoDto> findAll() throws Exception {
        return medicoService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Medico findById(@PathVariable Long id) throws Exception {
        return medicoService.findById(id);
    }
}