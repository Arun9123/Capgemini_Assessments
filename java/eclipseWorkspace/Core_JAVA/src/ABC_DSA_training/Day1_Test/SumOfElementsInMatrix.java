package ABC_DSA_training.Day1_Test;
import java.util.*;

public class SumOfElementsInMatrix {
	static Scanner sc = new Scanner (System.in);
	public static int[][] input() {
		System.out.println("Enter the number of rows in the array: ");
		int row = sc.nextInt();
		System.out.println("Enter the number of columns in the array: ");
		int col = sc.nextInt();
		int a[][] = new int[row][col];
		System.out.println("Enter "+ (row*col) +" elements in the array:");	
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				System.out.println("Enter element ["+i+"]["+j+"] :");
				a[i][j] = sc.nextInt();
			}
		}
		return a;
	}
	public static void printMatrix(int arr[][]) {
		System.out.println("The resultant matrix is: ");
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void sumMatrix(int arr[][]) {
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				sum+=arr[i][j];
			}
		}
		System.out.println("Sum of the elements of the matrix is : "+sum);
	}
	
	public static int thirdLargestElement(int[] arr) {
	    int first = Integer.MIN_VALUE;
	    int second = Integer.MIN_VALUE;
	    int third = Integer.MIN_VALUE;
	    for (int num : arr) {
	        if (num > first) {
	            third = second;
	            second = first;
	            first = num;
	        }
	        else if (num > second) {
	            third = second;
	            second = num;
	        }
	        else if (num > third) {
	            third = num;
	        }
	    }
	    return third;
	}
	public static void main(String args[]) {
		int array[][] = input();
		printMatrix(array);
		sumMatrix(array);
	}
}
