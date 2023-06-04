package br.com.unipar.Hospital.Service;

import br.com.unipar.Hospital.Model.Endereco;
import br.com.unipar.Hospital.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco insert(Endereco endereco) throws Exception {
        validaInsercaoEndereco(endereco);
        enderecoRepository.saveAndFlush(endereco);
        return endereco;
    }

    public Endereco update(Endereco endereco) throws Exception{
        validaUpdate(endereco);
        enderecoRepository.saveAndFlush(endereco);
        return endereco;
    }

    public List<Endereco> findAll(){
        return enderecoRepository.findAll();
    }

    public Endereco findById(Long id) throws Exception {
        Optional<Endereco> retorno = enderecoRepository.findById(id);

        if (retorno.isPresent()){
            return retorno.get();
        }else{
            throw new Exception("Endereco não encontrado para o id ("+id+"). Verifique");
        }
    }

    private void validaUpdate(Endereco endereco) throws Exception{
        if (endereco.getId() == null){
            throw new Exception("Para atualizar o endereco é necessário enviar o ID.");
        }
        validarEndereco(endereco);
    }

    private void validaInsercaoEndereco(Endereco endereco) throws Exception{
        if(endereco.getId() != null){
            throw new Exception("Não é necessário informar o ID para inserir o endereco");
        }

        validarEndereco(endereco);

    }

    private void validarEndereco(Endereco endereco) throws Exception {

        if (endereco.getLogradouro() == null||endereco.getLogradouro().isBlank()||endereco.getLogradouro().isEmpty()){
            throw new Exception("É necessário informar o logradouro. Verifique");
        }

        if(endereco.getLogradouro().length() > 100){
            throw new Exception("Tamanho do logradouro deve ser menor que 100 caracteres");
        }

        if (endereco.getBairro() == null||endereco.getBairro().isBlank()||endereco.getBairro().isEmpty()){
            throw new Exception("É necessário informar o bairro. Verifique");
        }

        if(endereco.getBairro().length() > 100){
            throw new Exception("Tamanho do bairro deve ser menor que 100 caracteres");
        }

        if (endereco.getCidade() == null||endereco.getCidade().isBlank()||endereco.getCidade().isEmpty()){
            throw new Exception("É necessário informar a cidade. Verifique");
        }

        if(endereco.getCidade().length() > 100){
            throw new Exception("Tamanho da cidade deve ser menor que 100 caracteres");
        }

        if (endereco.getUf() == null||endereco.getUf().isBlank()||endereco.getUf().isEmpty()){
            throw new Exception("É necessário informar o UF. Verifique");
        }

        if(endereco.getUf().length() > 2){
            throw new Exception("Tamanho do UF deve ser menor que 2 caracteres");
        }

        if (endereco.getCep() == null||endereco.getCep().isBlank()||endereco.getCep().isEmpty()){
            throw new Exception("É necessário informar o CEP. Verifique");
        }

        if(endereco.getCep().length() > 10){
            throw new Exception("Tamanho do CEP deve ser menor que 10 caracteres");
        }

        if(endereco.getNumero().length() > 10){
            throw new Exception("Tamanho do numero deve ser menor que 10 caracteres");
        }

        if(endereco.getComplemento().length() > 100){
            throw new Exception("Tamanho do complemento deve ser menor que 100 caracteres");
        }

    }

}
