package Factory;

public class Laptop {
	private static Laptop laptop;
	
	private Laptop() {
		
	}
	public static Laptop laptopFactory() {
		if (laptop == null) {
			laptop = new Laptop();
		}
		return laptop;
	}
}
