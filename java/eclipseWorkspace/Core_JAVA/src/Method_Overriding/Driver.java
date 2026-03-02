package Method_Overriding;
import java.util.*;

public class Driver {
	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter 1  for IT, 2 for Supporting: ");
		int uc= userInput.nextInt();
		System.out.println("Enter the duration in months: ");
		byte duration = userInput.nextByte();
		
		switch (uc) {
		case 1:
			System.out.println(new IT().SalCal(duration));
			break;
		case 2:
			System.out.println(new Supporting().SalCal(duration));
			break;
		default:
			System.out.println("Enter 1 or 2 ");
		}	
	}
}
