package br.com.unipar.forcavendasapp.controller;

import android.content.Context;

import java.util.ArrayList;

import br.com.unipar.forcavendasapp.dao.ItemDAO;
import br.com.unipar.forcavendasapp.model.Item;

public class ItemController {

    private Context context;

    public ItemController(Context context) {
        this.context = context;
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
