package Advanced_Java.LambdaExpressions;

interface Draw {
	void circle();
}

class C1 implements Draw{
	@Override
	public void circle(){
		System.out.println("C1 draw");
	}
}

public class LambdaFuntions {
	public static void main(String[] args) {
		C1 obj = new C1();
		obj.circle();
		
		Draw d2 = () -> {System.out.println("C2 draw");};
		d2.circle();
		
		Draw d3= () -> {System.out.println("C3 draw");};
		d3.circle();
	}
}
