package br.com.unipar.forcavendas.controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.WeakHashMap;

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

    public String validaCliente(String cdEndereco, String nmLogradouro, String cdNumero, String nmBairro, String nmCidade, String sgEstado) {
        String mensagem = "";
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

        if (nmLogradouro == null || nmLogradouro.isEmpty()){
            mensagem += "O nome do logradouro deve ser preenchido\n";
        }
        if (cdNumero == null || cdNumero.isEmpty()){
            mensagem += "O numero deve ser preenchido\n";
        }
        if (nmBairro == null || nmBairro.isEmpty()){
            mensagem += "O nome do bairro deve ser preenchido\n";
        }
        if (nmCidade == null || nmCidade.isEmpty()){
            mensagem += "O nome da cidade deve ser preenchido\n";
        }
        if (sgEstado == null || sgEstado.isEmpty()){
            mensagem += "A sigla do estado deve ser preenchido\n";
        }
        if (sgEstado.length() > 2){
            mensagem += "Sigla de estado incorreta\n";
        }
        return mensagem;
    }
}
