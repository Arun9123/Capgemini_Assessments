package DSA;
import java.util.*;

//beautifulu -> beauutifuuuluuuu
public class StringAddRepeatedChars {
	public static void check_count(String s) {
		String visited="";
		for(int i =0; i<s.length(); i++) {
			int c=1;
			for (int j=i+1; j<s.length(); j++) {
				if(s.charAt(i)==s.charAt(j)) {
					
					c++;
				}
			}
			if(c>1 && !visited.contains(String.valueOf(s.charAt(i)))) {
				visited+=s.charAt(i);
				System.out.println(s.charAt(i)+":"+c);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the string:");
		String s=sc.next();
		check_count(s);
		sc.close();
	}
}