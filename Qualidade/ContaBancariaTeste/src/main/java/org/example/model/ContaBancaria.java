package org.example.model;

public class ContaBancaria {
    private String codigoConta;
    private String codigoBanco;
    private String nomeTitular;
    private String codigoAgencia;
    private Double saldo;

    public String historico = "";

    public ContaBancaria(String codigoConta, String codigoBanco, String nomeTitular, String codigoAgencia, Double saldo) {
        this.codigoConta = codigoConta;
        this.codigoBanco = codigoBanco;
        this.nomeTitular = nomeTitular;
        this.codigoAgencia = codigoAgencia;
        this.saldo = saldo;
    }

    public String getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(String codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public String getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(String codigoConta) {
        this.codigoConta = codigoConta;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public ContaBancaria() {
    }

    public double sacar(Double saldo, double valorSaque) throws Exception{
        if (valorSaque > saldo) {

            historico += "Não foi possivel realizar o saque saldo {"+saldo+"} e saque {"+valorSaque+"}\n";
            System.out.println(historico);
            throw new Exception("Saldo insuficiente para eferuar o saque");
        }

        saldo = saldo - valorSaque;

        historico += "Realizado saque no valor de {"+valorSaque+"} saldo atualizado para {"+saldo+"}\n";
        System.out.println(historico);
        return saldo;
    }

    public double depositar(Double saldo, double valorDeposito) {

        saldo = saldo + valorDeposito;

        historico += "Realizado deposito no valor de {"+valorDeposito+"} saldo atualizado para {"+saldo+"}\n";
        System.out.println(historico);
        return saldo;
    }

    public String getHistorico() {
        return historico;
    }
}
