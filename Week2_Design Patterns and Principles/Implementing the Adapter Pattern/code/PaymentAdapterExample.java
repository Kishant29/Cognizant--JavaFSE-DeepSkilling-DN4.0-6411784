interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
}

class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Processing Stripe payment: $" + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPal;

    public PayPalAdapter(PayPalGateway payPal) {
        this.payPal = payPal;
    }

    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

public class PaymentAdapterExample {
    public static void main(String[] args) {
        PaymentProcessor payPal = new PayPalAdapter(new PayPalGateway());
        payPal.processPayment(100.50);

        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(75.25);
    }
}