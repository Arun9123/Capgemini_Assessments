package DSA_Revision;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;

public class Student_Driver {
	public static void main(String[] args) {
		Student[] students = {
			    new Student(1, "Steve Rogers", "steve.rogers@gmail.com", "Male", 9876543210L,
			            LocalDate.of(2000, 5, 12), LocalTime.of(8, 30), 45000.00),

			    new Student(2, "Natasha Romanoff", "natasha.romanoff@gmail.com", "Female", 9876543211L,
			            LocalDate.of(1999, 3, 21), LocalTime.of(10, 15), 52000.00),

			    new Student(3, "Tony Stark", "tony.stark@gmail.com", "Male", 9876543212L,
			            LocalDate.of(2001, 7, 5), LocalTime.of(14, 45), 60000.00),

			    new Student(4, "Bruce Banner", "bruce.banner@gmail.com", "Male", 9876543213L,
			            LocalDate.of(1998, 11, 18), LocalTime.of(9, 0), 48000.00),

			    new Student(5, "Wanda Maximoff", "wanda.maximoff@gmail.com", "Female", 9876543214L,
			            LocalDate.of(2002, 1, 30), LocalTime.of(16, 20), 53000.00),

			    new Student(6, "Peter Parker", "peter.parker@gmail.com", "Male", 9876543215L,
			            LocalDate.of(2003, 9, 10), LocalTime.of(7, 50), 40000.00),

			    new Student(7, "Stephen Strange", "stephen.strange@gmail.com", "Male", 9876543216L,
			            LocalDate.of(1997, 6, 25), LocalTime.of(11, 40), 70000.00),

			    new Student(8, "Carol Danvers", "carol.danvers@gmail.com", "Female", 9876543217L,
			            LocalDate.of(2000, 12, 2), LocalTime.of(13, 10), 55000.00),

			    new Student(9, "Sam Wilson", "sam.wilson@gmail.com", "Male", 9876543218L,
			            LocalDate.of(1999, 4, 14), LocalTime.of(15, 5), 47000.00),

			    new Student(10, "Shuri Wakanda", "shuri.wakanda@gmail.com", "Female", 9876543219L,
			            LocalDate.of(2001, 8, 19), LocalTime.of(9, 25), 62000.00)
		};
//	Arrays.sort(students);
		
//	NameComparator nameComparator = new NameComparator();
//	Arrays.sort(students, nameComparator);
		
		
	// Anonymous class dobComparator below
	Comparator<Student> dobComparator = new Comparator<Student>(){
		public int compare(Student o1, Student o2) {
			return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
		}
	};
	Arrays.sort(students, dobComparator);
	
	// Anonymous class timeComparator below
//	Comparator<Student> timeComparator = new Comparator<Student>(){
//		public int compare(Student o1, Student o2) {
//			return o1.getTimeOfBirth().compareTo(o2.getTimeOfBirth());
//		}
//	};
	
	
	// Anonymous function (lambda function) timeComparator below
//	Arrays.sort(students, (Student o1, Student o2) -> o1.getTimeOfBirth().compareTo(o2.getTimeOfBirth()));
	
	// Multiple comparisons (one after another) (We also use a combination of both anonymous classes and lambda functions)
	Arrays.sort(students, dobComparator.thenComparing((Student o1, Student o2) -> o1.getTimeOfBirth().compareTo(o2.getTimeOfBirth())));
	
	for (Student student: students) {
		System.out.println(student);
	}
		
	}
}
