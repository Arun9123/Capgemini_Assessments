package firstProject;

public class NonStaticPrinters {
	static int i=staticMethod();
	int j= nonStaticMethod();
	
	static {
		System.out.println("static{}");
	}
	{
		System.out.println("non-static{}");
	}
	
	public static int staticMethod() {
		System.out.println("Static var triggered");
		return 7;
	}
	public static int nonStaticMethod() {
		System.out.println("Non-static var triggered");
		return 8;
	}
	NonStaticPrinters() {
		System.out.println("Constructor");
	}
	public static void main(String[] args) {
		System.out.println("Start of main()");
		new NonStaticPrinters();
		new NonStaticPrinters();
		System.out.println("End of main()");
	}
}
