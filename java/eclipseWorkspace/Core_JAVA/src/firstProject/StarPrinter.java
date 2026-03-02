package firstProject;

public class StarPrinter {
	static int count=0;
	public static void printer(int count) {
		System.out.println("*");
		if (--count == 0) {
			return;
		}
		printer(count);
	}
	public static void printer2(int count2) {
		System.out.println("*");
		if (--count2 > 0) {
			printer2(count2);;
		}
	}
	public static void printer_inf(int count2) {
		System.out.println("*"+ ++StarPrinter.count);
		printer_inf(count2);
	}
	public static void main(String[] args) {
//		printer(3);
//		System.out.println();
//		printer2(3);
		printer_inf(5);
	}

}
