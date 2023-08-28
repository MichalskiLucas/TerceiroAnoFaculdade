package org.example;

public class SendWhatsApp implements Notifier {
    private Notifier notifier;

    public SendWhatsApp(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public void write(String message){

        notifier.write(WhatsApp(message));
    }

    private String WhatsApp(String message) {
        return message + "Enviando uma mensagem via WhatsApp";
    }

}
