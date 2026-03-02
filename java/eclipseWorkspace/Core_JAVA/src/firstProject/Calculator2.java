//package firstProject;
//import java.util.Scanner;
//
//public class Calculator2 {
//	static String operators="+-*/";
//	static Scanner scanner = new Scanner(System.in);
//	static double addition(double a, double b) {
//		return a+b;
//	}
//    static double subtraction(double a, double b) {
//		return a-b;
//	}
//    static double multiplication(double a, double b) {
//		return a*b;
//	}
//    static double division(double a, double b) {
//		return a/b;
//	}
//    static String input() {
//    	System.out.println("Enter the expression:");
//    	String s=scanner.nextLine();
//    	return s;
//    }
//    static void tokenizer(String st) {
//    	String w="";
//    	for (char ch: st.toCharArray()) {
//    		if(operators.indexOf(ch)!=-1) {
//    			w+=ch;
//    		}
//    		else {
//    			calculate(Double.parseDouble(w),ch);
//    		}
//    	}
//    }
//    static void calculate(double x, char ch) {
//    	System.out.println("Enter the first operand: ");
//    	double a= scanner.nextDouble();
//    	System.out.println("Enter the operator: ");
//    	char op= scanner.next().charAt(0);
//    	System.out.println("Enter the second operand: ");
//    	double b= scanner.nextDouble();
//    	double res=0.0;
//    	switch (op) {
//    	case '+':
//    		res = addition(a,b);
//    		break;
//    	case '-':
//    		res = subtraction(a,b);
//    		break;
//    	case '*':
//    	case 'x':
//    		res = multiplication(a,b);
//    		break;
//    	case '/':
//    		res = division(a,b);
//    	}
//    	System.out.println("Result: "+ res);
//    }
//    static boolean continue_input() {
//    	char ch='A';
//    	System.out.println("Do you want to continue - y/n ");
//		ch = scanner.next().charAt(0);
//		if (ch=='y' || ch=='Y')
//			return true;
//		else
//			return false;
//    }
//    public static void main(String args[]) {
//    	do {
//    		String s= input();
//    		tokenizer(s);
//    	}
//    	while (continue_input());
//    	scanner.close();
//    }
//}


package firstProject;

public class Calculator2 {

    static double add(double... numbers) {
        double sum = 0;
        for (double n : numbers) {
            sum += n;
        }
        return sum;
    }

    static double subtract(double... numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    static double multiply(double... numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        double result = 1;
        for (double n : numbers) {
            result *= n;
        }
        return result;
    }

    static double divide(double... numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Division by zero is not allowed");
            }
            result /= numbers[i];
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println("Addition: " + add(10, 20, 30, 40));
        System.out.println("Subtraction: " + subtract(100, 20, 10));
        System.out.println("Multiplication: " + multiply(2, 3, 4));
        System.out.println("Division: " + divide(100, 2, 5));
    }
}
