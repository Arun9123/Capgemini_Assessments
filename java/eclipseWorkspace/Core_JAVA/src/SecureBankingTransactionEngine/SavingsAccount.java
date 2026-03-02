package SecureBankingTransactionEngine;

public class SavingsAccount implements BankAccount{
	private long accountNumber = 77890100;
	private String accountHolderName = "Arunabha Dutta";
	private double balance = 65000;
	private String pin = "Savings123";
	public void getBalance(String pin) {
		if (this.pin.equals(pin)) {
			System.out.println("Savings Account balance: "+this.balance);
		}
		else {
			System.out.println("Incorrect pin for Savings Account!");
		}
	}
	public void deposit(double d) {
		balance+=d;
		System.out.println(d + " credited succesfully to Savings Acc. no. " + this.accountNumber + 
				" with account holder name "+this.accountHolderName);
	}
	public void withdraw(double w, String pin) {
		if(!(this.pin.equals(pin))) {
			System.out.println("Incorrect pin for Savings account!");
		}
		else {
			if(w>balance) {
				System.out.println("Withdrawl amount can't be greater than balance "+balance);
			}
			else {
				balance-=w;
				System.out.println(w + " debited succesfully from Savings Acc. no. " + this.accountNumber + 
						" with account holder name "+this.accountHolderName);
				System.out.println("Savings account Balance: "+balance);
			}
		}
	}
	
}
