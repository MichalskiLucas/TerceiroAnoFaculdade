package org.example.model;

import org.example.model.Item;

import java.util.ArrayList;

public class Pedido {
    int id;
    ArrayList<Item> itens = new ArrayList<>();
    Double vlrPedido;

    public Pedido(int id, ArrayList<Item> itens, Double vlrPedido) {
        this.id = id;
        this.itens = itens;
        this.vlrPedido = vlrPedido;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public Double getVlrPedido() {
        return vlrPedido;
    }

    public void setVlrPedido(Double vlrPedido) {
        this.vlrPedido = vlrPedido;
    }

    public Pedido adicionarPedido(Pedido pedido, Item item){

        ArrayList<Item> itens = new ArrayList<>();
        itens = pedido.getItens();
        itens.add(item);
        pedido.setItens(itens);

        return pedido;
    }


    public double validaPedido(Pedido pedido) throws Exception{
        if (pedido.getItens().get(0).getDescricao() == "") {
            throw new Exception("Erro");
        }

        return 1;

    }

}
