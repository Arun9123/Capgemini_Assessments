package objects;

public class CandidateDriver {
	public static void main(String[] args) {
		Candidate c1 = new Candidate("Arun", 91, true);
		System.out.println(c1);
		System.out.println(c1.name);
		System.out.println(c1.mobileNumber);
		System.out.println(c1.gender);
		System.out.println(c1.address);
		System.out.println();
		Candidate c2 = new Candidate("Arun", 91, true, "Kolkata");
		System.out.println(c2);
		System.out.println(c2.name);
		System.out.println(c2.mobileNumber);
		System.out.println(c2.gender);
		System.out.println(c2.address);
	}
}
