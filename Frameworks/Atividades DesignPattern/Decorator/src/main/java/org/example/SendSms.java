package org.example;

public class SendSms implements Notifier {
    private Notifier notifier;

    public SendSms(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public void write(String message){

        notifier.write(Sms(message));
    }

    private String Sms(String message) {
        return message+" Enviando uma mensagem via SMS";
    }
}
