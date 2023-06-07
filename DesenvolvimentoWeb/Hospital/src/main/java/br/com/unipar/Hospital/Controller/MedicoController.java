package br.com.unipar.Hospital.Controller;

import br.com.unipar.Hospital.Model.Medico;
import br.com.unipar.Hospital.Service.MedicoService;
import org.hibernate.annotations.OrderBy;
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

    @GetMapping
    public List<Medico> findAll() throws Exception {
        return medicoService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Medico findById(@PathVariable Long id) throws Exception {
        return medicoService.findById(id);
    }
}