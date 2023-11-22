package com.example.financial.controller;

import com.example.financial.model.Usuario;
import com.example.financial.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/login")
public class LoginController {
    @Autowired
    UsuarioService usuarioService;
    @GetMapping
    public String login(){
        return "login/index";
    }
    @PostMapping(path = "/realizarLogin")
    public String realizarLogin(Usuario usuario) {
        usuario = usuarioService.login(usuario.getEmail(), usuario.getSenha());

        if (usuario.getId() != null){
            return "redirect: home/homePage";
        } else {
            return "login/index";
        }
    }
}
