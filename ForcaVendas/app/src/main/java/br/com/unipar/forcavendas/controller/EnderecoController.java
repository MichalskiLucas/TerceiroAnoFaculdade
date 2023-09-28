package br.com.unipar.forcavendas.controller;

import android.content.Context;

import java.util.ArrayList;

import br.com.unipar.forcavendas.dao.EnderecoDAO;
import br.com.unipar.forcavendas.dao.ItemDAO;
import br.com.unipar.forcavendas.model.Endereco;

public class EnderecoController {

    private Context context;

    public EnderecoController(Context context){
        this.context = context;
    }

    public long salvarEndereco(Endereco endereco){
        return EnderecoDAO.getInstancia(context).insert(endereco);
    }

    public long atualizarEndereco(Endereco endereco){
        return EnderecoDAO.getInstancia(context).update(endereco);
    }

    public long apagarEndereco(Endereco endereco){
        return EnderecoDAO.getInstancia(context).delete(endereco);
    }

    public ArrayList<Endereco> retornarTodos(){
        return EnderecoDAO.getInstancia(context).getAll();
    }

    public Endereco retornarEndereco(int id){
        return EnderecoDAO.getInstancia(context).getById(id);
    }

}
