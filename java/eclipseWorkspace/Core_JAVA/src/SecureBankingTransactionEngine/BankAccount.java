package SecureBankingTransactionEngine;

public interface BankAccount {
	String loginPin = "Arunabha";
	void getBalance(String pin);
	void deposit(double d);
	void withdraw(double d, String pin);
}
