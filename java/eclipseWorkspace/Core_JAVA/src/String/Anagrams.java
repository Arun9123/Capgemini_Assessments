package String;

import java.util.Arrays;
import java.util.*;

public class Anagrams {
	static String s1, s2;
	static Scanner sc = new Scanner(System.in);
	public static void input() {
		System.out.println("Enter first string: ");
		s1=sc.next();
		System.out.println("Enter second string: ");
		s2=sc.next();
		
	}
	public static boolean isAnagram(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		char s1Arr[]= s1.toCharArray();
		Arrays.sort(s1Arr);
		char s2Arr[]= s2.toCharArray();
		Arrays.sort(s2Arr);
		for (int i = 0; i < s1Arr.length; i++) {
			if(s1Arr[i] != s2Arr[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		input();
		if(isAnagram(s1, s2)) {
			System.out.println("Anagrams");
		}
		else {
			System.out.println("NOT Anagrams");
		}
	}
}
