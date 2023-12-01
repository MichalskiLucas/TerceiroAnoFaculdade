package com.example.financial.controller;

import com.example.financial.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class HomeController {
    @Autowired
    private RegistroService registroService;
    @GetMapping
    public ModelAndView home(ModelMap model){
       // return "/home/homePage";


        ModelAndView modelAndView = new ModelAndView("/home/homePage");
        if (model.containsAttribute("registros"))
            modelAndView.addObject("registros", model.getAttribute("registros"));
        else{
            modelAndView.addObject("registros", registroService.findAll());
        }
        return modelAndView;
    }
}
