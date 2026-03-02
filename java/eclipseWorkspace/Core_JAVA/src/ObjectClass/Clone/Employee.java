package ObjectClass.Clone;

public class Employee implements Cloneable{
	int id;
	Employee (int id){
		this.id = id;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

