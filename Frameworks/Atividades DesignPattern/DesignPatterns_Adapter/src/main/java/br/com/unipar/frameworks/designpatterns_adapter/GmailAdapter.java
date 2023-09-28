package br.com.unipar.frameworks.designpatterns_adapter;

import br.com.unipar.frameworks.designpatterns_adapter.email.Gmail;

public class GmailAdapter extends Gmail
        implements EmailProvider {

    @Override
    public void apply(Email email) {
        init();
        render(email);
    }
    
}
