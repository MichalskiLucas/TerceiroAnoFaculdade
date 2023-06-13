package br.com.unipar.Hospital.Controller;

import br.com.unipar.Hospital.DTO.ConsultaDto;
import br.com.unipar.Hospital.Model.Consulta;
import br.com.unipar.Hospital.Service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ConsultaDto insertConsulta(@RequestBody Consulta consulta) throws Exception{
        return consultaService.insert(consulta);
    }

    @PutMapping(path = "/cancelar")
    public Consulta cancelaConsulta(@RequestBody Consulta consulta)throws Exception{
        return consultaService.cancelaConsulta(consulta);
    }

    @GetMapping
    public List<Consulta> findAll() {
        return consultaService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Consulta findById(@PathVariable Long id) throws Exception {
        return consultaService.findById(id);
    }
}