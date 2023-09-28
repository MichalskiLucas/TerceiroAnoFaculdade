package br.com.unipar.frameworks.designpatterns.abstractfactory.construirMusculos;

import br.com.unipar.frameworks.designpatterns.abstractfactory.IGanharMusculo;
import br.com.unipar.frameworks.designpatterns.abstractfactory.IPerderPeso;
import br.com.unipar.frameworks.designpatterns.abstractfactory.WidgetFactory;
import br.com.unipar.frameworks.designpatterns.abstractfactory.perderPeso.Peso;

public class GanharMusculosFactory implements WidgetFactory {
    @Override
    public IGanharMusculo ganharMusculo() {
        return new Musculo();
    }

    @Override
    public IPerderPeso perderPeso() {
        return new Peso();
    }

}
