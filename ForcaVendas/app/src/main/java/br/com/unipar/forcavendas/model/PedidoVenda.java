package br.com.unipar.forcavendas.model;

public class PedidoVenda {
    int codigo;
    Double valorTotal;
    String tpPagamento;
    int nrParcelas;

    int codEnderecoEntrega;

    public int getCodEnderecoEntrega() {
        return codEnderecoEntrega;
    }

    public void setCodEnderecoEntrega(int codEnderecoEntrega) {
        this.codEnderecoEntrega = codEnderecoEntrega;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTpPagamento() {
        return tpPagamento;
    }

    public void setTpPagamento(String tpPagamento) {
        this.tpPagamento = tpPagamento;
    }

    public int getNrParcelas() {
        return nrParcelas;
    }

    public void setNrParcelas(int nrParcelas) {
        this.nrParcelas = nrParcelas;
    }

    public PedidoVenda() {
    }

    public PedidoVenda(int codigo, Double valorTotal, String tpPagamento, int nrParcelas, int codEnderecoEntrega) {
        this.codigo = codigo;
        this.valorTotal = valorTotal;
        this.tpPagamento = tpPagamento;
        this.nrParcelas = nrParcelas;
        this.codEnderecoEntrega = codEnderecoEntrega;
    }
}
