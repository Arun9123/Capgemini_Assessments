package JAVA_OOPS_statements;

public class Online_Subscription_Management_System {

    public static void main(String[] args) {
    }

    interface SubscriptionActions {
        double calculateFinalPrice();
        void renew();
        void renew(int extensionPeriod);
    }

    static abstract class Subscription implements SubscriptionActions {
        private String subscriptionId;
        private String userName;
        private double amount;
        private boolean isActive;

        protected Subscription(String subscriptionId, String userName, double amount, boolean isActive) 
                throws InvalidSubscriptionException {
            if (amount <= 0) {
                throw new InvalidSubscriptionException("Subscription amount must be positive.");
            }
            this.subscriptionId = subscriptionId;
            this.userName = userName;
            this.amount = amount;
            this.isActive = isActive;
        }

        protected double getAmount() {
            return amount;
        }

        protected void checkStatus() {
            if (!isActive) {
                throw new SubscriptionExpiredException("Access denied: Subscription has expired.");
            }
        }

        protected void setStatus(boolean status) {
            this.isActive = status;
        }
    }

    static class MonthlySubscription extends Subscription {
        MonthlySubscription(String id, String user, double amount, boolean active) 
                throws InvalidSubscriptionException {
            super(id, user, amount, active);
        }

        @Override
        public double calculateFinalPrice() {
            checkStatus();
            return getAmount();
        }

        @Override
        public void renew() {
            setStatus(true);
        }

        @Override
        public void renew(int months) {
            setStatus(true);
        }
    }

    static class YearlySubscription extends Subscription {
        YearlySubscription(String id, String user, double amount, boolean active) 
                throws InvalidSubscriptionException {
            super(id, user, amount, active);
        }

        @Override
        public double calculateFinalPrice() {
            checkStatus();
            return getAmount() * 0.90; // 10% annual discount
        }

        @Override
        public void renew() {
            setStatus(true);
        }

        @Override
        public void renew(int years) {
            setStatus(true);
        }
    }

    // Checked Exception
    static class InvalidSubscriptionException extends Exception {
        InvalidSubscriptionException(String msg) { super(msg); }
    }

    // Unchecked Exception
    static class SubscriptionExpiredException extends RuntimeException {
        SubscriptionExpiredException(String msg) { super(msg); }
    }
}