package String;

public class Hashcode_check_for_changed_string {
	public static void main(String[] args) {
		String s1="Arun";
		String s2="Arun";
		String s3= new String("Arun");
		System.out.println(s1+s1.hashCode());
		System.out.println(s2+s2.hashCode());
		System.out.println(s2+System.identityHashCode(s2));
		System.out.println(s3+System.identityHashCode(s3));
		if(s1==s2) {
			System.out.println("1 and 2 same");
		}
		else {
			System.out.println("1 and 2 NOT same");
		}
		if(s2==s3) {
			System.out.println("3 and 2 same");
		}
		else {
			System.out.println("3 and 2 NOT same");
		}
		if (s3 == (s3="Aruna")) {
			System.out.println("s3 re-assigned in same memory block");
		}
		else {
			System.out.println("s3 NOT re-assigned in same memory block");	
		}
	}
}
