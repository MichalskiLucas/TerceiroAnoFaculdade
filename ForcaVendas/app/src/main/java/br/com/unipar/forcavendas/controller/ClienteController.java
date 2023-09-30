package br.com.unipar.forcavendas.controller;

import android.content.Context;

import java.util.ArrayList;

import br.com.unipar.forcavendas.ClienteActivity;
import br.com.unipar.forcavendas.dao.ClienteDAO;
import br.com.unipar.forcavendas.model.Cliente;
import br.com.unipar.forcavendas.model.Endereco;

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

    public String validaCliente(String cdCliente, String nmCliente, String nrCPF, String dtNasc, String cdEndereco) {
        String mensagem = "";
        if (cdCliente == null || cdCliente.isEmpty()){
            mensagem += "O codigo do cliente deve ser preenchido\n";
        }else{
            try{
                if(Integer.parseInt(cdCliente) <= 0){
                    mensagem += "O codigo do cliente deve ser maior que zero\n";
                }
            }catch (NumberFormatException ex){
                mensagem += "O codigo do cliente nao é um numero valido\n";
            }
        }

        if (nmCliente == null || nmCliente.isEmpty()){
            mensagem += "O nome do cliente deve ser preenchido\n";
        }

        if (nrCPF == null || nrCPF.isEmpty()){
            mensagem += "O CPF do cliente deve ser preenchido\n";
        }

        if(nrCPF.length() < 11){
            mensagem += "O CPF é invalido\n";
        }

        if (dtNasc == null || dtNasc.isEmpty()){
            mensagem += "A data de nascimento deve ser preenchida";
        }

        if (cdEndereco == null || cdEndereco.isEmpty()){
            mensagem += "O codigo do endereco deve ser preenchido\n";
        }else{
            try{
                if(Integer.parseInt(cdEndereco) <= 0){
                    mensagem += "O codigo do endereco deve ser maior que zero\n";
                }
            }catch (NumberFormatException ex){
                mensagem += "O codigo do endereco nao é um numero valido\n";
            }
        }


        return mensagem;
    }
}
