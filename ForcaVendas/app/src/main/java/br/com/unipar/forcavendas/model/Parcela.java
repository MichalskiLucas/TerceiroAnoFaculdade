package br.com.unipar.forcavendas.model;

public class Parcela {
    int id;
    Double vlParcela;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getVlParcela() {
        return vlParcela;
    }

    public void setVlParcela(Double vlParcela) {
        this.vlParcela = vlParcela;
    }

    public Parcela(int id, Double vlParcela) {
        this.id = id;
        this.vlParcela = vlParcela;
    }
}
