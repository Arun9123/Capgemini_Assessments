package ObjectClass.ToString;

public class Employee {
	int id;
	String name;
	
	Employee (int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Id: "+this.id+"\nName: "+this.name;
	}
}
