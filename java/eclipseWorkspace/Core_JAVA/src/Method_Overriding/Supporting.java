package Method_Overriding;

public class Supporting extends Employee{
	double monthlyVarPay = 10000;
	//
	@Override
	public double SalCal(byte duration) {
		return (monthlyBasePay + monthlyVarPay) * duration;
	}
	
	public double SalCal(byte duration, double bonus) {
		return ((monthlyBasePay + monthlyVarPay) * duration) + bonus;
	}
}
