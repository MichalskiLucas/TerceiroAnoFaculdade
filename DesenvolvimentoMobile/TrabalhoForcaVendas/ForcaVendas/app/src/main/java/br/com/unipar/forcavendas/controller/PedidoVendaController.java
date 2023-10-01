package br.com.unipar.forcavendas.controller;

import android.content.Context;

import java.util.ArrayList;

import br.com.unipar.forcavendas.dao.ItemDAO;
import br.com.unipar.forcavendas.dao.PedidoVendaDAO;
import br.com.unipar.forcavendas.model.Item;
import br.com.unipar.forcavendas.model.PedidoVenda;

public class PedidoVendaController {
    private Context context;

    public PedidoVendaController(Context context) {
        this.context = context;
    }

    public long salvarPedido(PedidoVenda pedidoVenda){
        return PedidoVendaDAO.getInstancia(context).insert(pedidoVenda);
    }

    public long atualizaPedido(PedidoVenda pedidoVenda){
        return PedidoVendaDAO.getInstancia(context).update(pedidoVenda);
    }

    public long apagaPedido(PedidoVenda pedidoVenda){
        return PedidoVendaDAO.getInstancia(context).delete(pedidoVenda);
    }

    public ArrayList<Item> retornarTodos(){
        return ItemDAO.getInstancia(context).getAll();
    }

    public Item retornaPedido(int id){
        return ItemDAO.getInstancia(context).getById(id);
    }

    public String validaPedido(int codCliente, String tpPagamento) {
        String mensagem = "";
        if (String.valueOf(codCliente).equals("")){
            mensagem += "O cliente deve ser informado\n";
        }
        if (tpPagamento.equals("")){
            mensagem += "Tipo de pagamento deve ser informado \n";
        }
        return mensagem;
    }
}
