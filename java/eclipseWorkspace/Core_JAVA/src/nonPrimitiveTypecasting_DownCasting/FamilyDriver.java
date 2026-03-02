package nonPrimitiveTypecasting_DownCasting;

public class FamilyDriver {
	public static void main(String[] args) {
//		Parent p = new Parent();
//		Child c = (Child)p;  //ClassCastException
		System.out.println("Start of main()");
		Child c = new Child();
		System.out.println(c);
		System.out.println(c.hashCode());
		Parent upCastedParentVar = c;    //due to inheritance, just like we can store any data type (int, long) into Object 
		System.out.println(upCastedParentVar);
		System.out.println(upCastedParentVar.hashCode());
		Child downCastedChildVar = (Child) upCastedParentVar;
		System.out.println(downCastedChildVar);
		System.out.println(downCastedChildVar.hashCode());
		System.out.println("Parent class member accessed using downCastedChildVar:"+ downCastedChildVar.p);
		System.out.println("Child class member accessed using downCastedChildVar:"+ downCastedChildVar.c);
		System.out.println("End of main()");
	}
}
