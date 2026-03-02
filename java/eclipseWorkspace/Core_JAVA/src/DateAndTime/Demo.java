package DateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Demo {
	public static void main(String[] args) {
		
		// What: Creating Date Objects
		LocalDate today = LocalDate.now();
		LocalDate futureDate = today.plusDays(10);
		System.out.println(today);
		System.out.println(futureDate);
		
		// Why: Business rule validation
		if (futureDate.isAfter(today)) {
			System.out.println("Future date is valid");
		}
		
		//How: Calculate difference between dates
		Period period = Period.between(today, futureDate);
		System.out.println("Days between dates: "+period.getDays());
		
		//What: Date-Time for logs and auditing
		LocalDateTime currentTimestamp = LocalDateTime.now();
		
		//How: Formatting for UI/reports
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		System.out.println("Formatted date: "+ currentTimestamp.format(dateFormatter));
		System.out.println("Formatted date and time : "+ currentTimestamp.format(dateTimeFormatter));
		
		System.out.println("Original date still unchanged: "+today);
		
	}
}
