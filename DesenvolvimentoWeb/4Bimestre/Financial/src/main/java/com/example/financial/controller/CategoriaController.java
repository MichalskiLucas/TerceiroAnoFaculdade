package com.example.financial.controller;

import com.example.financial.domain.Categoria;
import com.example.financial.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    }

    @GetMapping(path = "/criar")
    public ModelAndView retornaCategoria(ModelMap model){
        ModelAndView modelAndView = new ModelAndView("categoria/inserir");

        if (model.containsAttribute("categoria")) {
            modelAndView.addObject("categoria", model.getAttribute("categoria"));
            modelAndView.addObject("msg", model.getAttribute("msg"));

        } else {
            modelAndView.addObject("categoria", new Categoria());
            modelAndView.addObject("msg", new ArrayList<String>());
        }

        return modelAndView;
    }

    @PostMapping
    public String salvarCategoria(@Valid Categoria categoria,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes){

        List<String> msg = new ArrayList<>();

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("categoria", categoria);

            for (ObjectError objectError : bindingResult.getAllErrors()) {
                msg.add(
                        ((FieldError) objectError).getField() + " " +
                                objectError.getDefaultMessage());
            }

            redirectAttributes.addFlashAttribute("msg", msg);

            return "redirect:/categoria/criar";
        }

        categoriaService.insert(categoria);

        return "redirect:/categoria";
    }

    @GetMapping(path = "/remover/{id}")
    public String removerCategoria(@PathVariable("id") Long id){
        categoriaService.delete(id);
        return "redirect:/categoria";
    }
    @GetMapping(path = "/editar/{id}")
    public ModelAndView editarCategoria(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("categoria/inserir");
        modelAndView.addObject("categoria", categoriaService.findById(id));
        return modelAndView;
    }
}
