package br.com.unipar.Hospital.Service;

import br.com.unipar.Hospital.DTO.ConsultaDto;
import br.com.unipar.Hospital.Model.Consulta;
import br.com.unipar.Hospital.Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public ConsultaDto insert (Consulta consulta) throws Exception{
        validaInsercaoConsulta(consulta);
        consultaRepository.saveAndFlush(consulta);
        return ConsultaDto.getInstance(consulta);
    }

    public ConsultaDto update(Consulta consulta) throws Exception{
        validaUpdate(consulta);
        consultaRepository.saveAndFlush(consulta);
        return ConsultaDto.getInstance(consulta);
    }

    public List<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    public Consulta findById(Long id) throws Exception{
        Optional<Consulta> retorno = consultaRepository.findById(id);

        if (retorno.isPresent()){
            return retorno.get();
        }else{
            throw new Exception("Consulta não encontrada para o id ("+id+"). Verifique");
        }
    }

    private void validaUpdate(Consulta consulta) throws Exception{
        if (consulta.getId() == null){
            throw new Exception("É necessário informar o ID para atualizar a consulta");
        }
    }

    private void validaInsercaoConsulta(Consulta consulta) throws Exception{
        if (consulta.getId() != null){
            throw new Exception("Não é necessário informar o ID para cadastrar uma receita");
        }

        validaConsulta(consulta);
    }

    private void validaConsulta(Consulta consulta) throws Exception{
        if (consulta.getMedico().getId() == null){
            throw new Exception("É necessário informar um medico para realizar a consulta");
        }

        if(consulta.getPaciente().getId() == null){
            throw new Exception("É necessário informar o paciente para realizar a consulta");
        }

        if (consulta.getDataHora() == null){
            throw new Exception("É necessário informar a data e a hora da consulta");
        }
    }

}

