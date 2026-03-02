package VariableShadowingHiding.VariableShadowing;

public class Shadowing {
	int x = 10;
	static int y = 30;
	
	void main() {
		int x=20;
		int y=40;
		System.out.println("Hello");
	    System.out.println(x); //20
	    System.out.println(this.x); //10
	    System.out.println(y); //40
	    System.out.println(this.y); //30
	    System.out.println(Shadowing.y); //30
	}
}
