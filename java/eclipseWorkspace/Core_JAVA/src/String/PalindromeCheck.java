package String;
import java.util.*;

public class PalindromeCheck {
	static String s;
	public static void input() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a string: ");
		s=sc.next();
		sc.close();
	}
	public static boolean isPalindrome(String s) {
		int left=0;
		int right=s.length()-1;
		while (left<right) {
			if (s.charAt(left)!= s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	public static void main(String[] args) {
		input();
		if (isPalindrome(s.toLowerCase())) {
			System.out.println("Palindrome String");
		}
		else {
			System.out.println("NOT Palindrome String");
		}
	}
}
