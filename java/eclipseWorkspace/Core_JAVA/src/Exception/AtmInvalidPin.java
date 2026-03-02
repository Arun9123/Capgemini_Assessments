package Exception;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("serial")
class InvalidPinException extends Exception{
	public InvalidPinException(String msg) {
		super (msg);
	}
}
//public class AtmInvalidPin {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner (System.in);
//		int count = 0;
//		final int maxLimit = 3;
//		int pin = 1234;
//		while (++count <= maxLimit) {
//			System.out.println("Enter the pin: ");
//			try {
//				if (sc.nextInt() == pin) {
//					System.out.println("Hello User");
//					break;
//				}
//				else {
//					if(count < maxLimit) {
//						throw new InvalidPinException("Invalid pin! Try again. Attempts remaining: " + (maxLimit-count));
//					}
//				}
//			}
//			catch(InvalidPinException e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		sc.close();
//		if(count > 3) {
//			System.out.println("Maximum attempts reached! Contact your bank.");
//			System.exit(0);
//		}
//	}
//}


public class AtmInvalidPin {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		ArrayDeque<Integer> q = new ArrayDeque<>(Arrays.asList(1, 2, 3));
		final int maxLimit = 3;
		int pin = 1234;
		while (q.size() != 0) {
			q.poll();
			System.out.println("Enter the pin: ");
			try {
				if (sc.nextInt() == pin) {
					System.out.println("Hello User");
					break;
				}
				else {
					if(q.size() > 0) {
						throw new InvalidPinException("Invalid pin! Try again. Attempts remaining: " + (q.size()));
					}
				}
			}
			catch(InvalidPinException e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
		if(q.size() <= 0) {
			System.out.println("Maximum attempts reached! Contact your bank.");
			System.exit(0);
		}
	}
}
