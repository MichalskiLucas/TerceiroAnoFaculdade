package br.com.unipar.Hospital.Service.interfaces;

import br.com.unipar.Hospital.Model.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario insert(Usuario usuario) throws Exception;
    Usuario update(Usuario usuario) throws Exception;
    List<Usuario> findAll();
    Usuario findById(Long id) throws Exception;
    Usuario delete(Long id) throws Exception;
    void validaUpdatePaciente(Usuario usuario) throws Exception;
    void validaInsercaoPaciente(Usuario usuario) throws Exception;
}
