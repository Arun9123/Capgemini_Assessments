package firstProject;
import java.util.Scanner;

public class Calculator {
	static double addition(double a, double b) {
		return a+b;
	}
    static double subtraction(double a, double b) {
		return a-b;
	}
    static double multiplication(double a, double b) {
		return a*b;
	}
    static double division(double a, double b) {
		return a/b;
	}
    static void calculate() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter the first operand: ");
    	double a= scanner.nextDouble();
    	System.out.println("Enter the operator: ");
    	char op= scanner.next().charAt(0);
    	System.out.println("Enter the second operand: ");
    	double b= scanner.nextDouble();
    	double res=0.0;
    	switch (op) {
    	case '+':
    		res = addition(a,b);
    		break;
    	case '-':
    		res = subtraction(a,b);
    		break;
    	case '*':
    	case 'x':
    		res = multiplication(a,b);
    		break;
    	case '/':
    		res = division(a,b);
    	}
    	System.out.println("Result: "+ res);
    	scanner.close();
    }
    public static void main(String args[]) {
    	Scanner input = new Scanner(System.in);
    	char ch;
    	do {
    		calculate();
    		System.out.println("Do you want to continue - y/n ");
    		ch = input.next().charAt(0);
    		
    	}
    	while (ch=='y' || ch=='Y');
    	input.close();
    }
}
