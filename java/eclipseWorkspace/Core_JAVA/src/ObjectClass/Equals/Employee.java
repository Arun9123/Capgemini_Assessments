package ObjectClass.Equals;

public class Employee {
	int id;
	
	Employee (int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals (Object obj) {
		System.out.println(getClass());
		System.out.println(obj.getClass());
		if (this == obj) {  //comparing same reference, then no need of further check
			return true;
		}
		
		if (obj == null || getClass() != obj.getClass()) { //null objects or different types of objects (in cases of comparison between objects of Employee and Car)
			return false;
		}
		Employee e = (Employee) obj; //objects are of same type, but have different addresses
		return this.id == e.id;
	}
}
