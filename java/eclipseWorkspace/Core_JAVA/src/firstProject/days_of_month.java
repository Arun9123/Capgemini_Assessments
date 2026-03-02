package firstProject;
import java.util.*;

public class days_of_month {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the month number:");
		int month= scanner.nextInt();
		System.out.println("Enter the year:");
		int year= scanner.nextInt();
		scanner.close();
		switch(month) {
		case 2:
			if ((year%4==0 && year%100!=0) || year%400==0) {
				System.out.println("29 days");
			}
			else {
				System.out.println("28 days");
			}
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31 days");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30 days");
			break;
		}
;	}
}
