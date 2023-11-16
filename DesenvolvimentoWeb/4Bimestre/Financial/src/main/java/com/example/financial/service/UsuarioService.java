package com.example.financial.service;

import com.example.financial.model.Usuario;
import com.example.financial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String email, String senha){
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }
}
