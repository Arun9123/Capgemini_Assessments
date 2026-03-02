package firstProject;

public class StaticPrinters {
	static int i=printer();
	public static void main(String args[]) {
		System.out.println("Start of main()");
		System.out.println("End of main()");
	}
	static {
		System.out.println("From static block");
	}
	public static int printer() {
		System.out.println("Printer printed");
		return 0;
	}
}
