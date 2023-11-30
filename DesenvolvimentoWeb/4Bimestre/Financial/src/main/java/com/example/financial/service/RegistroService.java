package com.example.financial.service;

import com.example.financial.enums.TipoRegistroENUM;
import com.example.financial.model.Categoria;
import com.example.financial.model.Registro;
import com.example.financial.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public List<Registro> findAll(){
        return registroRepository.findAll();
    }

    public List<Registro> findLancamento(){
        List<Registro> registros = new ArrayList<>();
        registros = registroRepository.findByTipoRegistroENUM(TipoRegistroENUM.DESPESA);
        return registros;
    }

    public Registro insert(Registro registro){
        return registroRepository.saveAndFlush(registro);
    }

    public void delete(Long id){
        registroRepository.deleteById(id);
    }

    public Registro findById(Long id){
        return registroRepository.findById(id).get();
    }

}
