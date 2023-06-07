package br.com.unipar.Hospital.Controller;

import br.com.unipar.Hospital.Model.Paciente;
import br.com.unipar.Hospital.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente insertPaciente(@RequestBody Paciente paciente) throws Exception{
        return pacienteService.insertPaciente(paciente);
    }

    @PutMapping
    public Paciente updatePaciente(@RequestBody Paciente paciente) throws Exception{
        return pacienteService.update(paciente);
    }

    @DeleteMapping(path = "/{id}")
    public Paciente deletePaciente(@PathVariable Long id) throws Exception{
        return pacienteService.deletaPaciente(id);
    }

    @GetMapping
    public List<Paciente> findAll() throws Exception {
        return pacienteService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Paciente findById(@PathVariable Long id) throws Exception {
        return pacienteService.findById(id);
    }
}