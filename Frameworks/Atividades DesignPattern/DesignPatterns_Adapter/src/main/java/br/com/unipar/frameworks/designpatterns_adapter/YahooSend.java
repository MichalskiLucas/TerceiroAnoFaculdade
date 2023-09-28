package br.com.unipar.frameworks.designpatterns_adapter;

public class YahooSend implements EmailProvider {

    @Override
    public void apply(Email email) {
        System.out.println("Yahoo sendo enviado!");
    }

}
