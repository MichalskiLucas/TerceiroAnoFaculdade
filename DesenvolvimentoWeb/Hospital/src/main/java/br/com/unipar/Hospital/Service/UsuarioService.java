package br.com.unipar.Hospital.Service;

import br.com.unipar.Hospital.Model.Medico;
import br.com.unipar.Hospital.Model.Usuario;
import br.com.unipar.Hospital.Repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario insert(Usuario usuario) throws Exception {
		validaInsercaoPaciente(usuario);
		usuarioRepository.saveAndFlush(usuario);
		return usuario;
	}

	public Usuario update(Usuario usuario) throws Exception {
		validaUpdatePaciente(usuario);
		usuarioRepository.saveAndFlush(usuario);
		return usuario;
	}

	public List<Usuario> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}

	public Usuario findById(Long id) throws Exception {
		Optional<Usuario> retorno = usuarioRepository.findById(id);

		if (retorno.isPresent()) {
			return retorno.get();
		} else {
			throw new Exception("Usuario não encontrado para o id (" + id + "). Verifique");
		}
	}
	
	public Usuario delete(Long id) throws Exception{
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Usuario usuarioObject = new Usuario();
        usuarioObject.setId(usuario.get().getId());
        usuarioObject.setNome(usuario.get().getNome());
        usuarioObject.setUsuarioAd(usuario.get().getUsuarioAd());
        usuarioObject.setSenha(usuario.get().getSenha());
        usuarioObject.setAtivo(false);
        return usuarioRepository.saveAndFlush(usuarioObject);
    }

	private void validaUpdatePaciente(Usuario usuario) throws Exception {
		if (usuario.getId() == null) {
			throw new Exception("É necessário informar o ID para atualizar o cadastro do usuario");
		}

	}

	private void validaInsercaoPaciente(Usuario usuario) throws Exception {
		if (usuario.getId() != null) {
			throw new Exception("Não é necessário informar o ID para inserir o usuario");
		}

		if (usuario.getNome() == null || usuario.getNome().isEmpty() || usuario.getNome().isBlank()) {
			throw new Exception("É necessário informar o nome do usuario para inseri-lo");
		}

		if (usuario.getUsuarioAd() == null || usuario.getUsuarioAd().isEmpty() || usuario.getUsuarioAd().isBlank()) {
			throw new Exception("É necessário informar o usuarioAD do usuario para inseri-lo");
		}

		if (usuario.getSenha() == null || usuario.getSenha().isEmpty() || usuario.getSenha().isBlank()) {
			throw new Exception("É necessário informar a senha do usuario para inseri-lo");
		}

	}

}
