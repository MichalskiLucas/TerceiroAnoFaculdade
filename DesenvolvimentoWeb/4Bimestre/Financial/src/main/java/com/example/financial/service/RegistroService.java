package com.example.financial.service;

import com.example.financial.enums.TipoRegistroENUM;
import com.example.financial.domain.Registro;
import com.example.financial.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Registro> findReceita(){
        List<Registro> registros = new ArrayList<>();
        registros = registroRepository.findByTipoRegistroENUM(TipoRegistroENUM.RECEITA);
        return registros;
    }

    public Registro insert(Registro registro){
        LocalDate dataAtual = LocalDate.now();
        registro.setDataRegistro(dataAtual);

        return registroRepository.saveAndFlush(registro);
    }

    public BigDecimal getTotalLancamento(){
        List<Registro> registros = registroRepository.findByTipoRegistroENUM(TipoRegistroENUM.DESPESA);
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal vlLancamento;
        for(int i = 0; i< registros.size(); i++){
            vlLancamento = registros.get(i).getValor();
          total =  total.add(vlLancamento);
        }
        return total;
    }

    public BigDecimal getTotalReceita(){
        List<Registro> registros = registroRepository.findByTipoRegistroENUM(TipoRegistroENUM.RECEITA);
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal vlLancamento;
        for(int i = 0; i< registros.size(); i++){
            vlLancamento = registros.get(i).getValor();
            total =  total.add(vlLancamento);
        }
        return total;
    }
    public void delete(Long id){
        registroRepository.deleteById(id);
    }

    public Registro findById(Long id){
        return registroRepository.findById(id).get();
    }

}
