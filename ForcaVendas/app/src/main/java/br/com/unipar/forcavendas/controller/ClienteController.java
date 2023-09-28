package br.com.unipar.forcavendas.controller;

import android.content.Context;

import java.util.ArrayList;

import br.com.unipar.forcavendas.dao.ClienteDAO;
import br.com.unipar.forcavendas.model.Cliente;

public class ClienteController {

    private Context context;

    public ClienteController(Context context) {
        this.context = context;
    }

    public long insereCliente(Cliente cliente){
        return ClienteDAO.getInstancia(context).insert(cliente);
    }

    public long atualizaCliente(Cliente cliente){
        return ClienteDAO.getInstancia(context).update(cliente);
    }

    public long apagaCliente(Cliente cliente){
        return ClienteDAO.getInstancia(context).delete(cliente);
    }

    public ArrayList<Cliente> retornaTodos(){
        return ClienteDAO.getInstancia(context).getAll();
    }

    public Cliente retornaCliente(int id){
        return ClienteDAO.getInstancia(context).getById(id);
    }
}
