package br.com.unipar.pizzaria.model;

public class Sabores {

    private String nomeSabor;

    public Sabores(String nomeSabor) {
        this.nomeSabor = nomeSabor;
    }

    public String getNomeSabor() {
        return nomeSabor;
    }

    public void setNomeSabor(String nomeSabor) {
        this.nomeSabor = nomeSabor;
    }

    public Sabores() {
    }

    @Override
    public String toString() {
        return nomeSabor;
    }
}
