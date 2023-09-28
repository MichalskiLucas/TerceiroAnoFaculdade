package org.example;

public class MoneyPaymentForm implements PaymentForm{

    @Override
    public void pay(String paymentForm) {
        System.out.println("Payment made in Money");
    }
}
