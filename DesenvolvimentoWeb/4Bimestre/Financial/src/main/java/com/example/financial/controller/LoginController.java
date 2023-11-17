package com.example.financial.controller;

import com.example.financial.model.Usuario;
import com.example.financial.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/login")
public class LoginController {
    @Autowired
    UsuarioService usuarioService;
    @GetMapping
    public String login(){
        return "index";
    }
    @GetMapping(path = "/realizarLogin")
    public String realizarLogin(@RequestParam String email, @RequestParam String senha){
        Usuario usuario = usuarioService.login(email, senha);
        if (usuario == null){
            System.out.println("Null");
            return null;
        }else {
            System.out.println("NOT NULL");
            return null;
        }
    }
}
