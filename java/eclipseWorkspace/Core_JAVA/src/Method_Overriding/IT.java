package Method_Overriding;

public class IT extends Employee{
	double monthlyVarPay = 20000;
	//
	@Override
	protected double SalCal(byte duration) {
		return (monthlyBasePay + monthlyVarPay) * duration;
	}
	
	public double SalCal(byte duration, double bonus) {
		return ((monthlyBasePay + monthlyVarPay) * duration) + bonus;
	}
}
