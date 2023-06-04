package br.com.unipar.Hospital.Service;

import br.com.unipar.Hospital.Model.Endereco;
import br.com.unipar.Hospital.Model.Paciente;
import br.com.unipar.Hospital.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente insertPaciente(Paciente paciente) throws Exception{
        validaInsercaoPaciente(paciente);
        pacienteRepository.saveAndFlush(paciente);
        return paciente;
    }

    public Paciente update(Paciente paciente) throws  Exception {
        validaUpdatePaciente(paciente);
        pacienteRepository.saveAndFlush(paciente);
        return paciente;
    }

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente findById(Long id) throws Exception {
        Optional<Paciente> retorno = pacienteRepository.findById(id);

        if (retorno.isPresent()){
            return retorno.get();
        }else{
            throw new Exception("Paciente não encontrado para o id ("+id+"). Verifique");
        }
    }

    private void validaUpdatePaciente(Paciente paciente) throws Exception{
        if(paciente.getId() == null){
            throw new Exception("É necessário informar o ID para atualizar o cadastro do paciente");
        }

    }

    private void validaInsercaoPaciente(Paciente paciente) throws Exception{
        if (paciente.getId() != null ){
            throw new Exception("Não é necessário informar o ID para inserir o paciente");
        }

        if (paciente.getCpf() == null || paciente.getCpf().isEmpty() || paciente.getCpf().isBlank()){
            throw new Exception("É necessário informar o CPF do paciente para inseri-lo");
        }

        if (paciente.getCpf().length() != 11){
            throw new Exception("CPF informado é invalido");
        }

        if (paciente.getEmail() == null || paciente.getEmail().isEmpty() || paciente.getEmail().isBlank()){
            throw new Exception("É necessário informar o e-mail do paciente para inseri-lo");
        }

        if (paciente.getEmail().length() > 50) {
            throw new Exception("Tamanho do campo de email é de 50 caracteres");
        }

        if (paciente.getNome() == null || paciente.getNome().isEmpty() || paciente.getNome().isBlank()){
            throw new Exception("É necessário informar o nome do paciente para inseri-lo");
        }

        if (paciente.getNome().length() > 100){
            throw new Exception("Tamanho do campo de nome é de 100 caracteres");
        }

        if (paciente.getTelefone() == null || paciente.getTelefone().isEmpty() || paciente.getTelefone().isBlank()){
            throw new Exception("É necessário informar o telefone do paciente para inseri-lo");
        }

        if (paciente.getTelefone().length() > 20){
            throw new Exception("Tamanho do telefone é de 20 caracteres");
        }

        if (paciente.getEndereco().getId() == null) {
            throw new Exception("É necessário informar o endereco do paciente para cadastra-lo");
        }
    }

}
