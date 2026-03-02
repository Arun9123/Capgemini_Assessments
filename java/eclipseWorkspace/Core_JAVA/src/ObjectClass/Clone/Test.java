package ObjectClass.Clone;

public class Test {
	public static void main(String[] args) throws Exception{
		Employee e1 = new Employee(101);
		Employee e2 = (Employee) e1.clone();
		System.out.println(e1.id + " "+ e2.id);
		System.out.println(e1 + " "+ e2);
	}
}
