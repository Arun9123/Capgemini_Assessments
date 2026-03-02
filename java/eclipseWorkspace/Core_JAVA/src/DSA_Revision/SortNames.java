package DSA_Revision;

import java.util.*;

public class SortNames {
	private static List<String> sort (String arr[]){
		ArrayList<String> names = new ArrayList<>(Arrays.asList(arr));
		names.sort(null);
		return new ArrayList<>(names);
	}
	public static void main(String[] args) {
		String arr[]= {"Arunabha", "Pushkar", "Soumili", "Jyotiraditya"};
		System.out.println(sort(arr));
	}
}
