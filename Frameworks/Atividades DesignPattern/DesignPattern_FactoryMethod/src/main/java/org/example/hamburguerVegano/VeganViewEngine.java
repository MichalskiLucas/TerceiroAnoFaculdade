package org.example.hamburguerVegano;

import org.example.hamburguerAngus.ViewEngine;

import java.util.Map;

public class VeganViewEngine implements ViewEngine {
    @Override
    public String render(String viewName, Map<String, Object> context) {
        return "Hamburguer Vegano" +
                "\nHamburgues de grão de bico" +
                "\nAlface" +
                "\nTomate";
    }
}
