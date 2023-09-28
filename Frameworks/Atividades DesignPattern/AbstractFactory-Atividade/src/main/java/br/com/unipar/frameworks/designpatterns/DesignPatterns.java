package br.com.unipar.frameworks.designpatterns;

import br.com.unipar.frameworks.designpatterns.abstractfactory.app.ContactForm;
import br.com.unipar.frameworks.designpatterns.abstractfactory.construirMusculos.GanharMusculosFactory;


public class DesignPatterns {

    public static void main(String[] args) {
       new ContactForm().render(new GanharMusculosFactory());
    }
}
