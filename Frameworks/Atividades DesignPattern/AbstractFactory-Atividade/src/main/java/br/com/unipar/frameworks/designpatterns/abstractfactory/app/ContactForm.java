package br.com.unipar.frameworks.designpatterns.abstractfactory.app;

import br.com.unipar.frameworks.designpatterns.abstractfactory.WidgetFactory;

public class ContactForm {
    
    public void render(WidgetFactory factory) {
        factory.ganharMusculo().render();
        factory.perderPeso().render();

}
}
