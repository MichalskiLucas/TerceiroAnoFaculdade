package com.example.financial.controller;

import com.example.financial.domain.Registro;
import com.example.financial.enums.TipoRegistroENUM;
import com.example.financial.service.CategoriaService;
import com.example.financial.service.RegistroService;
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
@RequestMapping(path = "/receita")
public class ReceitaController {


    @Autowired
    private RegistroService registroService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ModelAndView registro(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("receita/index");
        if (model.containsAttribute("receitas"))
            modelAndView.addObject("receitas", model.getAttribute("receitas"));
        else{
            modelAndView.addObject("receitas", registroService.findReceita());
        }
        return modelAndView;
    }

    @GetMapping(path = "/criar")
    public ModelAndView retornaReceita(ModelMap model){
        ModelAndView modelAndView = new ModelAndView("receita/inserir");
        modelAndView.addObject("categorias", categoriaService.findAll());
        if (model.containsAttribute("registro")) {
            modelAndView.addObject("registro", model.getAttribute("registro"));
            modelAndView.addObject("msg", model.getAttribute("msg"));

        } else {
            modelAndView.addObject("registro", new Registro());
            modelAndView.addObject("msg", new ArrayList<String>());
        }

        return modelAndView;
    }

    @GetMapping(path = "/remover/{id}")
    public String removerReceita(@PathVariable("id") Long id){
        registroService.delete(id);
        return "redirect:/receita";
    }
    @GetMapping(path = "/editar/{id}")
    public ModelAndView editarReceita(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("registro/inserir");
        modelAndView.addObject("categorias", categoriaService.findAll());
        modelAndView.addObject("receita", registroService.findById(id));
        return modelAndView;
    }

    @PostMapping
    public String salvarReceita(@Valid Registro registro,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes){

        List<String> msg = new ArrayList<>();

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registro", registro);

            for (ObjectError objectError : bindingResult.getAllErrors()) {
                msg.add(
                        ((FieldError) objectError).getField() + " " +
                                objectError.getDefaultMessage());
            }

            redirectAttributes.addFlashAttribute("msg", msg);

            return "redirect:/registro/criar";
        }
        registro.setTipoRegistroENUM(TipoRegistroENUM.RECEITA);
        registroService.insert(registro);

        return "redirect:/receita/criar";
    }
}
