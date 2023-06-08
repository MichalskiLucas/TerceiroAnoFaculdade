package br.com.unipar.Hospital.Service;

import br.com.unipar.Hospital.DTO.ConsultaDto;
import br.com.unipar.Hospital.Model.Consulta;
import br.com.unipar.Hospital.Model.Medico;
import br.com.unipar.Hospital.Model.Paciente;
import br.com.unipar.Hospital.Repository.ConsultaRepository;
import br.com.unipar.Hospital.Repository.MedicoRepository;
import br.com.unipar.Hospital.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

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

        if(consulta.getPaciente().getId() == null){
            throw new Exception("É necessário informar o paciente para realizar a consulta");
        }

        if (consulta.getDataHora() == null){
            throw new Exception("É necessário informar a data e a hora da consulta");
        }

        if(consulta.getDataHora().getHours() < 7 || consulta.getDataHora().getHours() > 19){
            throw new Exception("A clinica atende somente das 7:00 as 19:00");
        }

        if(consulta.getMedico() == null){
            buscaMedico(consulta);
        }


        validaAntecedencia(consulta);
        validaPacienteMedicoAtivo(consulta);
        validaConsultaDia(consulta);
        validaMedicoConsulta(consulta);
    }

    private void buscaMedico(Consulta consulta) throws Exception {
        List<Medico> medicos = medicoRepository.findMedicosSemConsultaParaData(consulta.getDataHora());

        if(medicos.size() == 0){
            throw new Exception("Não possuimos medicos disponiveis. Aguarde");
        }

        consulta.setMedico(medicos.get(0));
    }

    private void validaMedicoConsulta(Consulta consulta) throws Exception {
        List<Consulta> consultaValidate = consultaRepository.findConsultaByMedicoAndAndDataHora(consulta.getMedico(), consulta.getDataHora());

        if(consultaValidate.size() > 0){
            throw new Exception("Medico ja possui consulta mercada para essa data");
        }
    }

    private void validaConsultaDia(Consulta consulta) throws Exception {
        List<Consulta> consultaValidate = consultaRepository.findConsultaByPacienteAndDataHora(consulta.getPaciente(), consulta.getDataHora());

        if(consultaValidate.size() > 0){
            throw new Exception("Paciente ja possui consulta marcada para esse dia");
        }
    }

    private void validaPacienteMedicoAtivo(Consulta consulta) throws Exception {

        Optional<Paciente> paciente = pacienteRepository.findById(consulta.getPaciente().getId());

        if (!paciente.get().isAtivo()){
            throw new Exception("O paciente precisa estar ativo para realizar a consulta");
        }

        Optional<Medico> medico = medicoRepository.findById(consulta.getMedico().getId());
        if(!medico.get().isAtivo()){
            throw new Exception("O medico precisa estar ativo para realizar a consulta");
        }

    }

    private void validaAntecedencia(Consulta consulta) throws Exception{
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = consulta.getDataHora().toInstant();
        LocalDateTime dataTemporal = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        Long minutosDiferenca = ChronoUnit.MINUTES.between(currentDateTime, dataTemporal);
        if (minutosDiferenca < 30){
            throw new Exception("Para agendar uma consulta é necessário agendar com 30 minutos ou mais de antecedencia");
        }
    }

}

