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
@RequestMapping(path = "/lancamento")
public class LancamentoController {

    @Autowired
    private RegistroService registroService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ModelAndView registro(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("lancamento/index");
        if (model.containsAttribute("lancamentos"))
            modelAndView.addObject("lancamentos", model.getAttribute("lancamentos"));
        else{
            modelAndView.addObject("lancamentos", registroService.findLancamento());
        }
        return modelAndView;
    }

    @GetMapping(path = "/criar")
    public ModelAndView retornaLancamento(ModelMap model){
        ModelAndView modelAndView = new ModelAndView("lancamento/inserir");
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
    public String removerLancamento(@PathVariable("id") Long id){
        registroService.delete(id);
        return "redirect:/lancamento";
    }
    @GetMapping(path = "/editar/{id}")
    public ModelAndView editarLancamento(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("lancamento/inserir");
        modelAndView.addObject("categorias", categoriaService.findAll());
        modelAndView.addObject("registro", registroService.findById(id));
        return modelAndView;
    }

    @PostMapping
    public String salvarLancamento(@Valid Registro registro,
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

            return "redirect:/lancamento/criar";
        }
        registro.setTipoRegistroENUM(TipoRegistroENUM.DESPESA);
        registroService.insert(registro);

        return "redirect:/lancamento/criar";
    }

}
