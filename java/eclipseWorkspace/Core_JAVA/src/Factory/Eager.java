package Factory;

public class Eager {
	private static Eager eager = new Eager ();
	private Eager () {
		System.out.println("Eager instance created");
	}
	public static Eager eagerFactory() {
		return eager;
	}
}
