package com.example.financial.controller;

import com.example.financial.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ModelAndView categoria(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("categoria/index");
        if (model.containsAttribute("categorias"))
            modelAndView.addObject("categorias", model.getAttribute("categorias"));
        else{
            modelAndView.addObject("categorias", categoriaService.findAll());
        }
        return modelAndView;
        //return "categoria/index";
    }
}
