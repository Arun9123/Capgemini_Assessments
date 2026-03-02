package String;

public class ConvertToAlternateCase {
	public static String converter (String s) {
		String w="";
		for (int i=0; i<s.length(); i++) {
			char ch=s.charAt(i);
			if (!((ch>=65 && ch<=90) || (ch>=97 && ch<=122))) {
				w=w+ch;
			}
			else {
				if ((ch>=65 && ch<=90)) {
					w=w+(char)(ch+32);
				}
				else {
					w=w+(char)(ch-32);
				}
			}
		}
		return w;
	}
	public static void main(String[] args) {
		String s="B@s1a";
		System.out.println("Original string: "+s);
		String res= converter (s);
		System.out.println("Converted string: "+res);
	}
}
