
package br.com.unipar.frameworks.designpatterns_adapter;

import br.com.unipar.frameworks.designpatterns_adapter.email.Gmail;

public class DesignPatterns_Adapter {

    public static void main(String[] args) {
        EmailView emailView = new EmailView(new Email());
        emailView.apply(new GmailSend(new Gmail()));
    }
}
