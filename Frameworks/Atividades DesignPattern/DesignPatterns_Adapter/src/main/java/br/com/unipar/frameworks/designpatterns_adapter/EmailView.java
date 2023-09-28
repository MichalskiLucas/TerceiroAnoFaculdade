package br.com.unipar.frameworks.designpatterns_adapter;

public class EmailView {
    
    private Email email;
    
    public EmailView(Email email) {
        this.email = email;
    }
    
    public void apply(EmailProvider envio) {
        envio.apply(email);
    }

}
