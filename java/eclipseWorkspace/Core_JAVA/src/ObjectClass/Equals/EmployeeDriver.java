package ObjectClass.Equals;

public class EmployeeDriver {
	public static void main(String[] args) {
		Employee c1 = new Employee (5);
		Employee c2 = new Employee (5);
		Employee c3 = new Employee (6);
		Employee c4 = c1;
		
		System.out.println(c1.equals(c1));
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println(c1.equals(c4));	
	}
}
