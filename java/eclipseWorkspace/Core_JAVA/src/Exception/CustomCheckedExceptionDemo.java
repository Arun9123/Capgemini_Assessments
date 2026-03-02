package Exception;

public class CustomCheckedExceptionDemo {
	public static Permit validateAge (int age) throws InvalidAgeException{
		if (age < 18) {
			throw new InvalidAgeException("Age must be 18 or above to register");
		}
		else if (age>=18 && age<21){
			System.out.println("Age is valid for: "+Permit.SOFT);
			System.out.println("Proceed for registration.");
			return Permit.SOFT;
		}
		else {
			System.out.println("Age is valid for: "+Permit.HARD);
			System.out.println("Proceed for registration.");
			return Permit.HARD;
		}
	}
	
	public static void main(String[] args) {
		try {
			validateAge(21);
		}
		catch(InvalidAgeException e) {
			System.out.println("Caught exception: "+e.getMessage());
		}
	}
}