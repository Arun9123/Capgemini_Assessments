package ABC_DSA_training;

public class Stack_Implementation {
	static int top = -1;
	static int capacity = 5;
	public static void printStack(int stack[]) {
		System.out.println("Current stack: ");
		int top1 = top;
		while (top1>= 0) {
			System.out.print(stack[top1]+ " ");
			top1--;
		}
		System.out.println();
	}
	public static void push(int stack[], int ele) {
		if(top == capacity-1) {
			System.out.println("Stack overflow");
		}
		else {
			System.out.println("Added element: "+ele);
			top++;
			stack[top] = ele;
		}
	}
	public static void pop(int stack[]) {
		if(top == -1) {
			System.out.println("Empty stack");
		}
		else {
			int ele = stack[top];
			top--;
			System.out.println("Popped element: "+ele);
		}
	}
	
	public static void main(String[] args) {
		int stack[] = new int[capacity];
		push(stack, 1);
		push(stack, 2);
		push(stack, 3);
		printStack(stack);
		pop(stack);
		printStack(stack);
	}
}
