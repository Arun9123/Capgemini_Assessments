package ObjectClass.Equals;

public class CarDriver {
	public static void main(String[] args) {
		Car c1 = new Car ("HV", (byte)5);
		Car c2 = new Car ("HV", (byte)5);
		Car c3 = c1;
		
		System.out.println(c1.equals(c1));
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		
	}
}
