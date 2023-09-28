package br.com.unipar.frameworks.designpatterns.abstractfactory.perderPeso;
import br.com.unipar.frameworks.designpatterns.abstractfactory.IPerderPeso;

public class Peso implements IPerderPeso {
    @Override
    public void render() {
        System.out.println("Perdendo o peso");
    }
}
