package br.com.unipar.Hospital.Service;

import br.com.unipar.Hospital.Enum.EspecialidadeEnum;
import br.com.unipar.Hospital.Model.Medico;
import br.com.unipar.Hospital.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico insert(Medico medico) throws Exception{
        validaInsercaoMedico(medico);
        medicoRepository.saveAndFlush(medico);
        return medico;
    }

    public Medico update(Medico medico) throws Exception{
        validaUpdate(medico);
        medicoRepository.saveAndFlush(medico);
        return medico;
    }

    public List<Medico> findAll() {
        return medicoRepository.findAllByOrderByNome();
    }

    public Medico findById(Long id) throws Exception {
        Optional<Medico> retorno = medicoRepository.findById(id);

        if (retorno.isPresent()){
            return retorno.get();
        }else{
            throw new Exception("Medico não encontrado para o id ("+id+"). Verifique");
        }
    }

    private void validaInsercaoMedico(Medico medico) throws Exception{
        if (medico.getId() != null){
            throw new Exception("Não é necessário informar o ID para inserir o medico");
        }

        validaMedico(medico);
    }

    private void validaMedico(Medico medico) throws Exception{
        if (medico.getCrm() == null || medico.getCrm().isBlank() || medico.getCrm().isEmpty()){
            throw new Exception("É necessário informar o CRM do medico para cadastra-lo");
        }
        if (medico.getCrm().length() > 6){
            throw new Exception("O CRM informado é invalido");
        }

        if (medico.getEmail() == null || medico.getEmail().isBlank() || medico.getEmail().isEmpty()){
            throw new Exception("É necessário informar o email para cadastrar o medico");
        }
        if (medico.getEmail().length() > 50){
            throw new Exception("O tamanho do campo de email é de 50 caracteres");
        }

        if (medico.getNome() == null || medico.getNome().isEmpty() || medico.getNome().isBlank()){
            throw new Exception("É necessário informar o nome do medico para cadastra-lo");
        }

        if (medico.getNome().length() > 100){
            throw new Exception("O tamanho maximo para o nome do medico é de 100 caracteres");
        }

        if (medico.getTelefone() == null || medico.getTelefone().isEmpty() || medico.getTelefone().isBlank()){
            throw new Exception("É necessário informar o telefone do medico para inseri-lo");
        }

        if (medico.getTelefone().length() > 20){
            throw new Exception("Tamanho do telefone é de 20 caracteres");
        }

        if (medico.getEndereco().getId() == null) {
            throw new Exception("É necessário informar o endereco do medico para cadastra-lo");
        }

        if (medico.getEspecialidade() ==  null){
            throw new Exception("É necessário informar a especialidade do medico para cadastra-lo");
        }

        validaEspecialidade(medico);
    }

    private void validaEspecialidade(Medico medico) throws Exception{
        if (medico.getEspecialidade().equals(EspecialidadeEnum.CARDIOLOGIA)){
            return;
        } else if (medico.getEspecialidade().equals(EspecialidadeEnum.DERMATOLOGIA)) {
            return;
        } else if (medico.getEspecialidade().equals(EspecialidadeEnum.GINECOLOGIA)) {
            return;
        } else if (medico.getEspecialidade().equals(EspecialidadeEnum.ORTOPEDIA)) {
            return;
        }else{
            throw new Exception("Não trabalhamos com essa especialidade");
        }

    }

    private void validaUpdate(Medico medico) throws Exception{
        if(medico.getId() == null){
            throw new Exception("É necessário informar o ID para atualizar o cadastro do medico");
        }
    }

}
