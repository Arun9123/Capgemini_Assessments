package objects;

public class Candidate {
	String name;
	long mobileNumber;
	boolean gender;
	
	public Candidate (String name, long mobileNumber, boolean gender) {
		this.name=name;
		this.mobileNumber=mobileNumber;
		this.gender=gender;
	}
	
	String address;
	
	public Candidate (String name, long mobileNumber, boolean gender, String address) {
		this(name, mobileNumber, gender);
		this.address=address;
	}
	public void study () {
		System.out.println("Studying hard");
	}
}
