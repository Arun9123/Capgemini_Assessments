package JAVA_OOPS_statements;

interface ATMOperations {
    void withdraw(double amount) throws InvalidTransactionException;
    void withdraw(double amount, int pin) throws InvalidTransactionException;
}

// Checked Exception
class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String msg) {
        super(msg);
    }
}

// Unchecked Exception
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

abstract class ATMAccount implements ATMOperations {

    private String accountNumber;
    private String holderName;
    private double balance;
    private double dailyLimit;
    private double withdrawnToday = 0;

    protected ATMAccount(String accNo, String name, double balance, double limit) {
        this.accountNumber = accNo;
        this.holderName = name;
        this.balance = balance;
        this.dailyLimit = limit;
    }

    protected double getBalance() {
        return balance;
    }

    protected void deductBalance(double amount) {
        balance -= amount;
        withdrawnToday += amount;
    }

    protected void validate(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
   throw new InvalidTransactionException("Invalid withdrawal amount");
  }

        if (withdrawnToday + amount > dailyLimit) {
   throw new InvalidTransactionException("Daily limit exceeded");
  }

        if (amount > balance) {
   throw new InsufficientFundsException("Insufficient balance");
  }
    }
}

// Savings Account
class SavingsAccount extends ATMAccount {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance, 20000);
    }

    @Override
    public void withdraw(double amount) throws InvalidTransactionException {
        validate(amount);
        deductBalance(amount);
        System.out.println("Savings Account: Withdrawal successful");
    }

    @Override
    public void withdraw(double amount, int pin) throws InvalidTransactionException {
        if (pin != 1234) {
   throw new InvalidTransactionException("Invalid PIN");
  }

        withdraw(amount);
    }
}

// Salary Account
class SalaryAccount extends ATMAccount {

    public SalaryAccount(String accNo, String name, double balance) {
        super(accNo, name, balance, 50000);
    }

    @Override
    public void withdraw(double amount) throws InvalidTransactionException {
        validate(amount);
        deductBalance(amount);
        System.out.println("Salary Account: Withdrawal successful");
    }

    @Override
    public void withdraw(double amount, int pin) throws InvalidTransactionException {
        if (pin != 9999) {
   throw new InvalidTransactionException("Invalid PIN");
  }

        withdraw(amount);
    }
}

// Test Class
public class SecureATMSystem {

    public static void main(String[] args) {

        ATMAccount acc1 = new SavingsAccount("SA101", "Ravi", 30000);
        ATMAccount acc2 = new SalaryAccount("SAL202", "Anita", 80000);

        try {
            acc1.withdraw(5000, 1234);
            acc2.withdraw(20000, 9999);
        } catch (InvalidTransactionException e) {
            System.out.println(e.getMessage());
        }
    }
}