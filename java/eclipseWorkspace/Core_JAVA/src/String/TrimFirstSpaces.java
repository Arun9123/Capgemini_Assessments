package String;

public class TrimFirstSpaces {
	static int i;
	public static void main(String[] args) {
		String s="    super soldier";
		System.out.println("Original string: "+s);
		System.out.println("Trimmed using .trim(): "+s.trim());
		for (i=0; i<s.length(); i++) {
			if (s.charAt(i)==' ') {
				continue;
			}
			else {
				break;
			}
		}
		System.out.println("Number of leading spaces: "+i);
		s=s.substring(i, s.length());
		System.out.println("Trimmed string: "+s);
	}
}
