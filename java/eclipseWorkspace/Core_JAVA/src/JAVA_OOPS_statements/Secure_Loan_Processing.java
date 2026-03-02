package JAVA_OOPS_statements;

public class Secure_Loan_Processing {

    public static void main(String[] args) {
    }

    interface LoanOperations {
        double calculateInterest();
        void payEMI(double amount);
        void payEMI(double amount, double processingFee);
    }

    static abstract class LoanAccount implements LoanOperations {
        private String loanId;
        private String applicantName;
        private double loanAmount;
        private double balanceRemaining;

        protected LoanAccount(String loanId, String applicantName, double loanAmount) 
                throws InvalidLoanAmountException {
            if (loanAmount <= 0) {
                throw new InvalidLoanAmountException("Loan amount must be greater than zero.");
            }
            this.loanId = loanId;
            this.applicantName = applicantName;
            this.loanAmount = loanAmount;
            this.balanceRemaining = loanAmount;
        }

        protected double getBalanceRemaining() {
            return balanceRemaining;
        }

        protected void reduceBalance(double amount) {
            if (amount > balanceRemaining) {
                throw new OverpaymentException("Payment exceeds remaining balance.");
            }
            this.balanceRemaining -= amount;
        }

        protected double getLoanAmount() {
            return loanAmount;
        }
    }

    static class HomeLoan extends LoanAccount {
        HomeLoan(String id, String name, double amount) throws InvalidLoanAmountException {
            super(id, name, amount);
        }

        @Override
        public double calculateInterest() {
            return getBalanceRemaining() * 0.07;
        }

        @Override
        public void payEMI(double amount) {
            reduceBalance(amount);
        }

        @Override
        public void payEMI(double amount, double processingFee) {
            reduceBalance(amount);
        }
    }

    static class PersonalLoan extends LoanAccount {
        PersonalLoan(String id, String name, double amount) throws InvalidLoanAmountException {
            super(id, name, amount);
        }

        @Override
        public double calculateInterest() {
            return getBalanceRemaining() * 0.12; // 12% interest for Personal Loans
        }

        @Override
        public void payEMI(double amount) {
            reduceBalance(amount);
        }

        @Override
        public void payEMI(double amount, double processingFee) {
            reduceBalance(amount);
        }
    }

    // Checked Exception
    static class InvalidLoanAmountException extends Exception {
        InvalidLoanAmountException(String msg) { super(msg); }
    }

    // Unchecked Exception
    static class OverpaymentException extends RuntimeException {
        OverpaymentException(String msg) { super(msg); }
    }
}