package br.com.unipar.forcavendasapp.model;

public class Item {

    private int codigo;
    private String descricao;
    private Double vlrUnit;
    private String unMedida;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getVlrUnit() {
        return vlrUnit;
    }

    public void setVlrUnit(Double vlrUnit) {
        this.vlrUnit = vlrUnit;
    }

    public String getUnMedida() {
        return unMedida;
    }

    public void setUnMedida(String unMedida) {
        this.unMedida = unMedida;
    }

    public Item(int codigo, String descricao, Double vlrUnit, String unMedida) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.vlrUnit = vlrUnit;
        this.unMedida = unMedida;
    }

    public Item() {
    }
}
