package nonPrimitiveTypecasting_UpCasting;

public class FamilyDriver {
	public static void main(String[] args) {
		Parent p = new Parent();
		System.out.println(p.p);
		p.pm();
		
		Child c= new Child();
		System.out.println(c.c);
		c.cm();
		System.out.println(c.p);
		c.pm();
		
		//Up casting
		Child c1 = new Child();
		Parent p1= c1;   //p1 is up casted variable
		System.out.println(p1.p);
		p1.pm();
//		System.out.println(p1.c);  Now Parent p will be able to access only the members of the parent class, NOT the members of the child class.
//		p1.cm();
	}
}
