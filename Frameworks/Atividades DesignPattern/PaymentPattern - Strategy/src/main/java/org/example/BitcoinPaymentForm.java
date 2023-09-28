package org.example;

public class BitcoinPaymentForm implements PaymentForm{
    @Override
    public void pay(String paymentForm) {
        System.out.println("Payment made in Bitcoin");
    }
}
