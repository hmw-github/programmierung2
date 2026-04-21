package kapitel3.payments;

import kapitel3.payments.processors.CreditCardProcessor;
import kapitel3.payments.processors.PaymentProcessor;

public class Main {
 public static void main(String[] args) {
     // Valid payments
     PaymentProcessor card   = new CreditCardProcessor("Hans Müller", "1234567890123456", 2027);
     //PaymentProcessor paypal = new PayPalProcessor("Hans Müller", "hans@example.com");
     //PaymentProcessor bank   = new BankTransferProcessor("Hans Müller", "DE89370400440532013000");

     card.process(49.99);
     //paypal.process(49.99);
     //bank.process(49.99);

     // Invalid payment — should throw
     System.out.println("--- Testing invalid card number ---");
     try {
         PaymentProcessor badCard = new CreditCardProcessor("Hans Müller", "1234", 2027);
         badCard.process(49.99);
     } catch (Exception e) {
         System.out.println("Caught expected exception: " + e.getMessage());
     }
 }
}

