package firstProject;

import java.util.Scanner;

public class CheckDatatype {
	public static String typeCheck(String s) {
		String res="";
		return res;
	}
	public static void main(String[] args) {
		Object arr[] = new Object[5];
		Scanner userInput = new Scanner(System.in);
		for (int i=0; i< arr.length; i++) {
			arr[i]=userInput.nextLine();
		}
		System.out.println("Element" + "\t" + "Datatype");
		for (int i=0; i< arr.length; i++) {
			
		}
		userInput.close();
	}
}
