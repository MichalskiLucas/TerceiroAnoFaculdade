package com.example.financial.controller;

import com.example.financial.dto.LoginDTO;
import com.example.financial.model.Usuario;
import com.example.financial.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/login")
public class LoginController {
    @Autowired
    UsuarioService usuarioService;
    @GetMapping
    public String login(){
        return "login/index";
    }

    @PostMapping
    public String login(@Valid Usuario usuario,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

        List<String> msg = new ArrayList<>();

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("usuario", usuario);

            for (ObjectError objectError : bindingResult.getAllErrors()) {
                msg.add(
                        ((FieldError) objectError).getField() + " " +
                                objectError.getDefaultMessage());
            }

            redirectAttributes.addFlashAttribute("msg", msg);

            return "redirect:/login/logar";
        }

        usuarioService.login(usuario.getEmail(), usuario.getSenha());

        return "redirect:/home";
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
    @GetMapping("/logar")
    public ModelAndView logar(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("login/index");
        if (model.containsAttribute("usuario")) {
            modelAndView.addObject("usuario", model.getAttribute("usuario"));
            modelAndView.addObject("msg", model.getAttribute("msg"));

        } else {
            modelAndView.addObject("usuario", new Usuario());
            modelAndView.addObject("msg", new ArrayList<String>());
        }
        return modelAndView;
    }
}
