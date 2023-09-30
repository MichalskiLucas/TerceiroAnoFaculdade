package br.com.unipar.forcavendas.controller;

import android.content.Context;

import java.util.ArrayList;

import br.com.unipar.forcavendas.dao.ItemDAO;
import br.com.unipar.forcavendas.model.Item;

public class ItemController {

    private Context context;

    public ItemController(Context context) {
        this.context = context;
    }

    public static String validaItems(String cdItem, String dsItem, String vlUnit, String unMedida) {
        String mensagem = "";
        if (cdItem == null || cdItem.isEmpty()){
            mensagem += "O codigo do item deve ser preenchido\n";
        }else{
            try{
                if(Integer.parseInt(cdItem) <= 0){
                    mensagem += "O codigo do item deve ser maior que zero\n";
                }
            }catch (NumberFormatException ex){
                mensagem += "O codigo do item nao é um numero valido\n";
            }
        }

        if (dsItem == null || dsItem.isEmpty()){
            mensagem += "A descricao do item deve ser prenchido\n";
        }

        if (vlUnit == null || vlUnit.isEmpty()){
            mensagem += "O valor unitario do item deve ser preenchido\n";
        }else{
            try {
                if(Double.parseDouble(vlUnit) <= 0){
                    mensagem += "O valor unitario deve ser maior que zero\n";
                }
            }catch (NumberFormatException ex){
                mensagem += "O valor unitario do item nao é um numero validao\n";
            }
        }

        if (unMedida == null || unMedida.isEmpty()){
            mensagem += "A unidade de medida deve ser preenchida";
        }
        return mensagem;
    }

    public long salvarItem(Item item){
        return ItemDAO.getInstancia(context).insert(item);
    }

    public long atualizaItem(Item item){
        return ItemDAO.getInstancia(context).update(item);
    }

    public long apagarItem(Item item){
        return ItemDAO.getInstancia(context).delete(item);
    }

    public ArrayList<Item> retornarTodos(){
        return ItemDAO.getInstancia(context).getAll();
    }

    public Item retornarItem(int id){
        return ItemDAO.getInstancia(context).getById(id);
    }


}
