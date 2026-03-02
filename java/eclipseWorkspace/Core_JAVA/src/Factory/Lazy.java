package Factory;

public class Lazy {
	private static Lazy lazy;
	private Lazy () {
		System.out.println("Lazy instance created");
	}
	public static Lazy lazyFactory() {
		if (lazy == null) {
			lazy= new Lazy();
		}
		return lazy;
	}
}
