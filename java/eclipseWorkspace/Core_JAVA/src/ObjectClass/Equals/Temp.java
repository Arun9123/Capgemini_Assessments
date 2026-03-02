package ObjectClass.Equals;

public class Temp {
	public static void main(String[] args) {
		String s1="qwerty";
		String s2="qwerty";
		String s3 = new String ("qwerty");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
	}
}
