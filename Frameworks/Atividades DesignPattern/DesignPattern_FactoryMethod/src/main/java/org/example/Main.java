package org.example;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar.getInstance();

        new ProdutoController().listProduct();
        new ProdutoController2().listProduct();
    }
}