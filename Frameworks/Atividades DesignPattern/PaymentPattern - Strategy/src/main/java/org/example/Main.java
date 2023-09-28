package org.example;

public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();

        payment.payForm("Cartao de credito", new CreditCardPaymentForm());
        payment.payForm("Bitcoin", new BitcoinPaymentForm());
        payment.payForm("Paypal", new PayPalPaymentForm());
        payment.payForm("Money", new MoneyPaymentForm());
    }
}