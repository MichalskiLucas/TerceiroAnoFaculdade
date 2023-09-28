package br.com.unipar.frameworks.designpatterns.abstractfactory.construirMusculos;


import br.com.unipar.frameworks.designpatterns.abstractfactory.IGanharMusculo;

public class GanharMusculos implements IGanharMusculo {
    @Override
    public void render() {
        System.out.println("Ganhando musculos");
    }
}
