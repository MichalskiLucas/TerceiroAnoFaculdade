package com.example.financial.service;

import com.example.financial.domain.Categoria;
import com.example.financial.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria insert(Categoria categoria){
        return categoriaRepository.saveAndFlush(categoria);
    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }

    public Categoria findById(Long id){
        return categoriaRepository.findById(id).get();
    }


}
