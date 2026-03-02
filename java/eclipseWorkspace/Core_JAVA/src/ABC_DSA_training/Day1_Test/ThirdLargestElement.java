package ABC_DSA_training.Day1_Test;
import java.util.*;

public class ThirdLargestElement {
	static Scanner sc = new Scanner (System.in);
	public static int[] input() {
		System.out.println("Enter the number of elements in the array: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter "+n+" elements in the array:");
		for (int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		return a;
	}
	public static void printArray(int arr[]) {
		System.out.println("The array is: ");
		for (int i: arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static boolean validLength(int arr[]) {
		if (arr.length<3) {
			return false;
		}
		else {
			return true;
		}
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
		int array[] = input();
		printArray(array);
		if(validLength(array)) {
			System.out.println("The third largest element in the array is: "+ thirdLargestElement(array));
		}
		else {
			System.out.println("Array length must be greater than 3.");
		}
	}
}
