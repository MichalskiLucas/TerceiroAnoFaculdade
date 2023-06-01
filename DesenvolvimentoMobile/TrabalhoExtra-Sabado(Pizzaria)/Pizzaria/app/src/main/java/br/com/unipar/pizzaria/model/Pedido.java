package br.com.unipar.pizzaria.model;

import java.util.ArrayList;

public class Pedido {

    private int id;
    private String tamanho;
    private ArrayList<Sabores> sabores = new ArrayList<>();
    private boolean comBorda = false;
    private boolean comRefrigerante = false;
    private double valorPedido;

    public Pedido() {
    }
    public Pedido(int id, String tamanho, ArrayList<Sabores> sabores, boolean comBorda, boolean comRefrigerante, double valorPedido) {
        this.id = id;
        this.tamanho = tamanho;
        this.sabores = sabores;
        this.comBorda = comBorda;
        this.comRefrigerante = comRefrigerante;
        this.valorPedido = valorPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public ArrayList<Sabores> getSabores() {
        return sabores;
    }

    public void setSabores(ArrayList<Sabores> sabores) {
        this.sabores = sabores;
    }

    public boolean isComBorda() {
        return comBorda;
    }

    public void setComBorda(boolean comBorda) {
        this.comBorda = comBorda;
    }

    public boolean isComRefrigerante() {
        return comRefrigerante;
    }

    public void setComRefrigerante(boolean comRefrigerante) {
        this.comRefrigerante = comRefrigerante;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }
}
