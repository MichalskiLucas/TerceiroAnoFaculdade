package com.example.financial.controller;

import com.example.financial.model.Usuario;
import com.example.financial.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/cadastro")
public class CadastroController {
    @Autowired
    UsuarioService usuarioService;
    @GetMapping
    public String cadastro(){
        return "cadastro/index";
    }

    @PostMapping
    public String cadastrar(Usuario usuario) throws Exception{
        try{
            usuarioService.cadastrar(usuario);
            return "login/login";
        }catch (Exception e){
            return "";
        }
    }
}
