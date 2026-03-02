package UncheckedExceptions;

public class CustomUncheckedException {
	public static void withdraw (double balance , double amount) {
		if (amount > balance) {
			throw new InsufficientBalanceException("Withdrawl amount exceeds the balance.");
		}
		System.out.println("Withdrawl succesful! Remaining balance: "+ (balance-amount));
	}
	public static void main(String[] args) {
		double balance = 5000;
		double withdrawlAmount = 6000;
		try {
			withdraw(balance, withdrawlAmount);
		}
		catch (InsufficientBalanceException e) {
			System.out.println("Exception caught: "+e.getMessage());
		}
	}
}