package br.com.unipar.frameworks.designpatterns.abstractfactory.perderPeso;

import br.com.unipar.frameworks.designpatterns.abstractfactory.IGanharMusculo;
import br.com.unipar.frameworks.designpatterns.abstractfactory.IPerderPeso;
import br.com.unipar.frameworks.designpatterns.abstractfactory.WidgetFactory;
import br.com.unipar.frameworks.designpatterns.abstractfactory.construirMusculos.Musculo;

public class PerderPesoFactory implements WidgetFactory {
    @Override
    public IGanharMusculo ganharMusculo() {
        return new Musculo();
    }

    @Override
    public IPerderPeso perderPeso() {
        return new Peso();
    }
}
