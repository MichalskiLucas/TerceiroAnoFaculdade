package org.example;

public class Main {
    public static void main(String[] args) {
        EnviandoMessage(new SendSms(new Notificacao()));
        EnviandoMessage(new SendWhatsApp(new Notificacao()));
        EnviandoMessage(new SendWhatsApp(new SendSms(new Notificacao())));
    }

    public static void EnviandoMessage(Notifier notifier){
        notifier.write("Pedido enviado = ");
    }
}