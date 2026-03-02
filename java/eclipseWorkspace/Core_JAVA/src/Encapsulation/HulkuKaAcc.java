package Encapsulation;

public class HulkuKaAcc {
	private double bal=6000.0;
	private short pin = 6598;
	public double getBalance(short pin) {
		if (this.pin == pin) {
			return this.bal;
		}
		return -1;
	}
	public void setBalCredit(double amt) {
		this.bal+=amt;
	}
	public void setBalDebit(double amt) {
		this.bal-=amt;
	}
}
