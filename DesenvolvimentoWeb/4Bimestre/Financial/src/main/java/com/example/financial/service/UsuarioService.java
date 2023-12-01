package com.example.financial.service;

import com.example.financial.domain.Usuario;
import com.example.financial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String email, String senha){
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }

    public Usuario cadastrar(Usuario usuario){
        return usuarioRepository.saveAndFlush(usuario);
    }

    public List<String> validate(Usuario usuario){
        List<String> msg = new ArrayList<>();

        if(usuario.getNome() == null || usuario.getNome().isEmpty()) {
            msg.add("É necessário informar um nome");
        }

        if(!usuario.getEmail().contains("@")){
            msg.add("É necessário informar um e-mail válido");
        }

        return msg;
    }

}
