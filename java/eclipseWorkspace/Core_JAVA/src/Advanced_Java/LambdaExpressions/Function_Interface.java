package Advanced_Java.LambdaExpressions;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface A{
	void show(String msg);
}
public class Function_Interface {
	public static int sum (Integer a, Integer b) {
		return a+b;
	}
	public static int square (int a) {
		return (int)(Math.pow(a, 2));
	}
	public static int sumSquare(int a, int b) {
		BiFunction<Integer, Integer, Integer> f4 = (x,y) -> sum(x,y);
		int sum = f4.apply(a, b);
		Function<Integer, Integer> f5 = Function_Interface::square;
		return f5.apply(sum);
	}
	
	
	
	
	
	public void show(String msg) {
		System.out.println(msg.toLowerCase());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Function<Integer, Integer> f = (n) -> (int) Math.sqrt(n);
//		System.out.println(f.apply(4));
//		
//		Function<Integer, Double> f2 = Math::sqrt;
//		System.out.println(f2.apply(16));
		
//		BiFunction<Integer, Integer, Integer> f3 = (x,y) -> Function_Interface.sumSquare(x,y);
		BiFunction<Integer, Integer, Integer> f3 = Function_Interface::sumSquare;

		System.out.println("Enter the 2 numbers separated by spaces: ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		int res=f3.apply(a,b);
		System.out.println("The result of ("+a+"+"+b+")^2 is = "+res);
		sc.close();
		
		
		
		
		Function_Interface d = new Function_Interface();
		A arg = (msg) -> d.show(msg);
		arg.show("HELLO WORLD");
		
		A arg2 = d::show;
		arg2.show("HELLO EVERYONE!");
	}
}
