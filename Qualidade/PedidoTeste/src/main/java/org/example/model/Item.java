package org.example.model;

public class Item {
    int id;
    String descricao;
    double vlUnit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getVlUnit() {
        return vlUnit;
    }

    public void setVlUnit(double vlUnit) {
        this.vlUnit = vlUnit;
    }

    public Item() {
    }

    public Item(int id, String descricao, double vlUnit) {
        this.id = id;
        this.descricao = descricao;
        this.vlUnit = vlUnit;
    }
}
