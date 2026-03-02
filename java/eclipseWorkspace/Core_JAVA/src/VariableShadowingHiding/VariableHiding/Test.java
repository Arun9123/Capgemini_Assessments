package VariableShadowingHiding.VariableHiding;

public class Test {
	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.x);
		
		Child c = new Child();
		System.out.println(c.x);
	}
}
