package SecureBankingTransactionEngine;
import java.util.*;

public class HomePage {
	static Scanner userInput = new Scanner(System.in);
	public static int chooseAccountType() {
		int userChoice;
		System.out.println("Choose account type:"
				+ "\n1. Savings Account"
				+ "\n2. Current Account");
		userChoice = userInput.nextInt();
		userInput.nextLine();
		return userChoice;
	}
	public static int chooseOperation() {
		int userChoice;
		System.out.println("Enter your desired operation:"
				+ "\n1. Fetch balance"
				+ "\n2. Deposit amount"
				+ "\n3. Withdraw amount");
		userChoice = userInput.nextInt();
		userInput.nextLine();
		return userChoice;
	}
	public static void performOperation(BankAccount acc) {
		int operation = chooseOperation();
		if (operation < 1 || operation >3) {
			System.out.println("Enter either 1, 2 or 3.");	
		}
		else {
			if (operation == 1) {
				System.out.println("Enter transaction pin: ");
				String pin = userInput.nextLine();
				acc.getBalance(pin);
			}
			else if (operation == 2) {
				System.out.println("Enter amount to deposit: ");
				double deposit = userInput.nextDouble();
				userInput.nextLine();
				acc.deposit(deposit);
			}
			else if (operation == 3) {
				System.out.println("Enter amount to withdraw: ");
				double withdraw = userInput.nextDouble();
				userInput.nextLine();
				System.out.println("Enter transaction pin: ");
				String pin = userInput.nextLine();
				acc.withdraw(withdraw, pin);
				
			}
		}
	}
	public static boolean continueOperation() {
		System.out.println("Press 'y' to continue, else press any other key to exit: ");
		if (userInput.nextLine().toLowerCase().equals("y")) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println("Enter login pin: ");
		String loginPin = userInput.nextLine();
		if (BankAccount.loginPin.equals(loginPin)) {
			boolean flag = true;
			BankAccount acc = null;
			do {
				int accountType = chooseAccountType();
				if(accountType==1) {
					acc = new SavingsAccount();
				}
				else if(accountType==2) {
					acc = new CurrentAccount();
				}
				else {
					flag = false;
					System.out.println("Enter either 1 or 2.");
				}
			}
			while(flag == false);
			
			do {
				performOperation(acc);
			}
			while(continueOperation());
			System.out.println("----- Exiting Secure Banking Transaction System -----");
		}
		else {
			System.out.println("Incorrect login pin!");
		}
	}
}
