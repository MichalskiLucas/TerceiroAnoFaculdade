package org.example;

public class CreditCardPaymentForm implements PaymentForm{
    @Override
    public void pay(String paymentForm) {
        System.out.println("Payment made in CreditCard");
    }
}
