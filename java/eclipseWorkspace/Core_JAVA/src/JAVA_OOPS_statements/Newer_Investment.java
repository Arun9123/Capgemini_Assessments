package JAVA_OOPS_statements;

import java.util.*;

class InvalidInvestmentException extends Exception {
    public InvalidInvestmentException(String message) {
    	super(message);
    }
}

class InvestmentRejectedException extends RuntimeException {
    public InvestmentRejectedException(String message) {
    	super(message);
    }
}

enum InvestmentType {
	EQUITY, DEBT
}

interface TransactionOperations {
    InvestmentTransaction applyTax(double percentage) throws InvalidInvestmentException;
    InvestmentTransaction applyBonus(double percentage) throws InvalidInvestmentException;
    void authorize();
}

abstract class InvestmentTransaction implements TransactionOperations {
    private final String transactionId;
    private final String investorName;
    protected final double investedAmount;
    private final InvestmentType investmentType;

    public InvestmentTransaction(String transactionId, String investorName, double investedAmount, InvestmentType investmentType) throws InvalidInvestmentException {
        if (investedAmount <= 0) {
            throw new InvalidInvestmentException("Validation Failed: Invested amount must be > 0.");
        }
        this.transactionId = transactionId;
        this.investorName = investorName;
        this.investedAmount = investedAmount;
        this.investmentType = investmentType;
    }

    public String getTransactionId() {
    	return transactionId;
    }
    public String getInvestorName() {
    	return investorName;
    }
    public double getInvestedAmount() {
    	return investedAmount;
    }
    public InvestmentType getInvestmentType() {
    	return investmentType;
    }

    @Override
    public String toString() {
        return String.format("[%s] ID: %s | Investor: %s | Amount: Rs.%.2f", 
                investmentType, transactionId, investorName, investedAmount);
    }
}

class EquityInvestment extends InvestmentTransaction {

    public EquityInvestment(String id, String name, double amount) throws InvalidInvestmentException {
        super(id, name, amount, InvestmentType.EQUITY);
    }

    @Override
    public InvestmentTransaction applyTax(double percentage) throws InvalidInvestmentException {
        if (percentage < 0 || percentage > 30) {
        	throw new InvalidInvestmentException("Tax range 0-30 only.");
        }        	
        // Returns a NEW object, keeping the original immutable
        double netAmount = this.investedAmount * (1 - (percentage / 100));
        return new EquityInvestment(this.getTransactionId() + "_TAXED", this.getInvestorName(), netAmount);
    }

    @Override
    public InvestmentTransaction applyBonus(double percentage) throws InvalidInvestmentException {
        if (percentage < 0 || percentage > 30) {
        	throw new InvalidInvestmentException("Bonus range 0-30 only.");
        }
        double netAmount = this.investedAmount * (1 + (percentage / 100));
        return new EquityInvestment(this.getTransactionId() + "_BONUS", this.getInvestorName(), netAmount);
    }

    @Override
    public void authorize() {
        System.out.println("Standard Equity Authorization: Low-risk verification passed.");
    }

    public void authorize(String securityCode) {
        if (!"EQ-99".equals(securityCode)) throw new InvestmentRejectedException("Unauthorized Equity Access!");
        System.out.println("Secure Equity Authorization: Level 2 verification passed.");
    }
}

class DebtInvestment extends InvestmentTransaction {

    public DebtInvestment(String id, String name, double amount) throws InvalidInvestmentException {
        super(id, name, amount, InvestmentType.DEBT);
    }

    @Override
    public InvestmentTransaction applyTax(double percentage) throws InvalidInvestmentException {
        if (percentage < 0 || percentage > 30) throw new InvalidInvestmentException("Tax range 0-30 only.");
        double netAmount = (this.investedAmount - 10) * (1 - (percentage / 100));
        return new DebtInvestment(this.getTransactionId() + "_TAXED", this.getInvestorName(), netAmount);
    }

    @Override
    public InvestmentTransaction applyBonus(double percentage) throws InvalidInvestmentException {
        if (percentage < 0 || percentage > 30) throw new InvalidInvestmentException("Bonus range 0-30 only.");
        double netAmount = this.investedAmount + (this.investedAmount * (percentage / 100));
        return new DebtInvestment(this.getTransactionId() + "_BONUS", this.getInvestorName(), netAmount);
    }

    @Override
    public void authorize() {
        System.out.println("Debt Authorization: Checking credit rating...");
    }

    public void authorize(String securityCode) {
        if (!"DB-01".equals(securityCode)) throw new InvestmentRejectedException("Unauthorized Debt Access!");
        System.out.println("Secure Debt Authorization: Institutional bond clearance passed.");
    }
}

class AmountComparator implements Comparator<InvestmentTransaction> {
    @Override
    public int compare(InvestmentTransaction t1, InvestmentTransaction t2) {
        return Double.compare(t1.getInvestedAmount(), t2.getInvestedAmount());
    }
}

public class Newer_Investment {
    public static void main(String[] args) {
        try {
            EquityInvestment original = new EquityInvestment("TXN001", "Alice", 10000.0);
            System.out.println("Original: " + original);
            EquityInvestment taxed = (EquityInvestment) original.applyTax(15.0);
            System.out.println("After Tax: " + taxed);
            System.out.println("Original still exists: " + original);

            taxed.authorize();
            taxed.authorize("EQ-99");
            
            // InvestmentTransaction fail = new DebtInvestment("TXN002", "Bob", -50);

        } catch (InvalidInvestmentException | InvestmentRejectedException e) {
            System.err.println("Transaction Failed: " + e.getMessage());
        }
    }
}