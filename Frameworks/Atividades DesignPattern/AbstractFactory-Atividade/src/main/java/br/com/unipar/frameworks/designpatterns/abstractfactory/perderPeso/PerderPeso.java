package br.com.unipar.frameworks.designpatterns.abstractfactory.perderPeso;

import br.com.unipar.frameworks.designpatterns.abstractfactory.IPerderPeso;

public class PerderPeso implements IPerderPeso {
    @Override
    public void render() {
        System.out.println("Perdendo peso");
    }
}
