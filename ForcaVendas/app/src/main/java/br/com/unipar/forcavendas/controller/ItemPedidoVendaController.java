package br.com.unipar.forcavendas.controller;

import android.content.Context;

import java.util.ArrayList;

import br.com.unipar.forcavendas.dao.ItemDAO;
import br.com.unipar.forcavendas.dao.ItemPedidoVendaDAO;
import br.com.unipar.forcavendas.dao.PedidoVendaDAO;
import br.com.unipar.forcavendas.model.Item;
import br.com.unipar.forcavendas.model.ItemPedidoVenda;
import br.com.unipar.forcavendas.model.PedidoVenda;

public class ItemPedidoVendaController {
    private Context context;

    public ItemPedidoVendaController(Context context) {
        this.context = context;
    }

    public long salvarItemPedido(ItemPedidoVenda itemPedidoVenda){
        return ItemPedidoVendaDAO.getInstancia(context).insert(itemPedidoVenda);
    }

    public long atualizaItemPedido(ItemPedidoVenda itemPedidoVenda){
        return ItemPedidoVendaDAO.getInstancia(context).update(itemPedidoVenda);
    }

    public long apagaItemPedido(ItemPedidoVenda itemPedidoVenda){
        return ItemPedidoVendaDAO.getInstancia(context).delete(itemPedidoVenda);
    }

    public ArrayList<Item> retornarTodos(){
        return ItemDAO.getInstancia(context).getAll();
    }

    public Item retornaItemPedido(int id){
        return ItemDAO.getInstancia(context).getById(id);
    }
}
