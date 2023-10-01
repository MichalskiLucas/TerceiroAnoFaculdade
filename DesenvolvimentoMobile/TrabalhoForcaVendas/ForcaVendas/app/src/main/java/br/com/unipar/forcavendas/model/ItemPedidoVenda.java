package br.com.unipar.forcavendas.model;

public class ItemPedidoVenda {
    int codigo;
    int codigoPedido;
    int codigoItem;
    String descItem;

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    int qtItem;
    Double vlUnitItem;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public int getQtItem() {
        return qtItem;
    }

    public void setQtItem(int qtItem) {
        this.qtItem = qtItem;
    }

    public Double getVlUnitItem() {
        return vlUnitItem;
    }

    public void setVlUnitItem(Double vlUnitItem) {
        this.vlUnitItem = vlUnitItem;
    }

    public ItemPedidoVenda() {
    }

    public ItemPedidoVenda(int codigo, int codigoPedido, int codigoItem, String descItem, int qtItem, Double vlUnitItem) {
        this.codigo = codigo;
        this.codigoPedido = codigoPedido;
        this.codigoItem = codigoItem;
        this.descItem = descItem;
        this.qtItem = qtItem;
        this.vlUnitItem = vlUnitItem;
    }
}
