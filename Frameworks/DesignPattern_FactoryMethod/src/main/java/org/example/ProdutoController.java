package org.example;

import org.example.hamburguerVegano.VeganController;

import java.util.HashMap;
import java.util.Map;

public class ProdutoController extends VeganController {

    public void listProduct(){
        //aqui pega os dados do banco
        Map<String, Object> context = new HashMap<>();
        //Context é populado
        render("productsView.html", context);
    }

}
