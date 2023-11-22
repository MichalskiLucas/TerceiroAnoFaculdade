package com.example.financial.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public String cadastro() {
        return "cadastro/index";
    }

    @PostMapping("/cadastrar1")
    public String cadastrar(Usuario usuario) {
        try {
            usuarioService.cadastrar(usuario);
            //return "redirect:/login";
            return null;
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping
    public String salvarDisciplina(@Valid Usuario usuario,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes){

        List<String> msg = new ArrayList<>();
        msg.addAll(usuarioService.validate(usuario));

        if (bindingResult.hasErrors() || !msg.isEmpty()) {
            redirectAttributes.addFlashAttribute("usuario", usuario);

            for (ObjectError objectError : bindingResult.getAllErrors()) {
                msg.add(
                        ((FieldError) objectError).getField() + " " +
                                objectError.getDefaultMessage());
            }

            redirectAttributes.addFlashAttribute("msg", msg);

            return "redirect:/cadastro/criar";
        }

        usuarioService.cadastrar(usuario);

        return "redirect:/login";
    }


    @GetMapping("/criar")
    public ModelAndView cadastrar(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("cadastro/index");
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
