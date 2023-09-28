package org.example;

import org.example.product.Juice;
import org.example.product.Toxies;

public class Main {
    public static void main(String[] args) {

        DeliveryService deliveryService = new DeliveryService();
        deliveryService.setupOrder(
                new CompositeBox(
                        new Juice("SUCO", 399.00)
                ),
                new CompositeBox(
                        new Toxies("TOXICO 1", 25.55),
                        new Toxies("TOXICO 2", 25.00)
                ),
                new Juice("TREMBOLONA", 148.00)
        );
        System.out.println(deliveryService.calculateOrderPrice());
    }
}