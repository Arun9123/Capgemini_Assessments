package ABC_DSA_training.Day1_Test;

import java.util.*;

public class PatternMatching {
	static Scanner sc = new Scanner (System.in);
	public static String input () {
		String s = sc.nextLine();
		return s;
	}
	public static boolean patternCheck (String text, String pattern) {
		boolean found = false;
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j;
            for (j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == pattern.length()) {
                found = true;
                break;
            }
        }
        return found;
	}
    public static void main(String[] args) {
    	System.out.println("Enter the main string: ");
        String text = input();
        System.out.println("Enter the pattern: ");
        String pattern = input();
        if (patternCheck(text, pattern)) {
        	System.out.println("Pattern exists");
        }
        else {
        	System.out.println("Pattern does not exist");
        }
        sc.close();
    }
}