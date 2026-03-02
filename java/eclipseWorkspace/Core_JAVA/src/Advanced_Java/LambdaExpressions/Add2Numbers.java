package Advanced_Java.LambdaExpressions;

interface Add {
	int sum(int a, int b);
}
public class Add2Numbers {
	public static void main(String[] args) {
		Add add = (int a, int b) -> {
			return a+b;
		};
		int res = add.sum(3,5);
		System.out.println(res);
	}
}
