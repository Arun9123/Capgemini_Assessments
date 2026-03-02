package JAVA_OOPS_statements;

interface PaymentProcessor {
    void processPayment() throws InvalidPaymentException;
    void processPayment(String otp) throws InvalidPaymentException;
    void processPayment(boolean biometric) throws InvalidPaymentException;
}

// Checked Exception
class InvalidPaymentException extends Exception {
    public InvalidPaymentException(String message) {
        super(message);
    }
}

// Unchecked Exception
class PaymentFailedException extends RuntimeException {
    public PaymentFailedException(String message) {
        super(message);
    }
}

abstract class Payment implements PaymentProcessor {

    private String transactionId;
    private String userName;
    private double amount;

    protected Payment(String txnId, String user, double amount) {
        this.transactionId = txnId;
        this.userName = user;
        this.amount = amount;
    }

    protected double getAmount() {
        return amount;
    }

    protected void validateAmount() throws InvalidPaymentException {
        if (amount <= 0)
            throw new InvalidPaymentException("Invalid payment amount");
    }
}

// Credit Card Payment
class CreditCardPayment extends Payment {

    public CreditCardPayment(String txnId, String user, double amount) {
        super(txnId, user, amount);
    }

    @Override
    public void processPayment() throws InvalidPaymentException {
        validateAmount();
        System.out.println("Credit Card payment processed successfully");
    }

    @Override
    public void processPayment(String otp) throws InvalidPaymentException {
        if (!"1111".equals(otp))
            throw new InvalidPaymentException("Invalid OTP");

        processPayment();
    }

    @Override
    public void processPayment(boolean biometric) throws InvalidPaymentException {
        throw new InvalidPaymentException("Biometric not supported for Credit Card");
    }
}

// UPI Payment
class UPIPayment extends Payment {

    public UPIPayment(String txnId, String user, double amount) {
        super(txnId, user, amount);
    }

    @Override
    public void processPayment() throws InvalidPaymentException {
        validateAmount();
        System.out.println("UPI payment processed successfully");
    }

    @Override
    public void processPayment(String otp) throws InvalidPaymentException {
        throw new InvalidPaymentException("OTP not required for UPI");
    }

    @Override
    public void processPayment(boolean biometric) throws InvalidPaymentException {
        if (!biometric)
            throw new PaymentFailedException("Biometric authentication failed");

        processPayment();
    }
}

// Test Class
public class OnlinePaymentEngine {

    public static void main(String[] args) {

        PaymentProcessor p1 =
                new CreditCardPayment("TXN1001", "Rahul", 2500);

        PaymentProcessor p2 =
                new UPIPayment("TXN2001", "Sneha", 1500);

        try {
            p1.processPayment("1111");   // OTP based
            p2.processPayment(true);     // Biometric based
        } catch (InvalidPaymentException e) {
            System.out.println(e.getMessage());
        }
    }
}