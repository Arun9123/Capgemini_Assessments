package Factory;

public class Driver {
	public static void main(String[] args) {
		Laptop l3 = Laptop.laptopFactory();
		Laptop l4 = Laptop.laptopFactory();
		System.out.println(l3);
		System.out.println(l4);
	}
}
