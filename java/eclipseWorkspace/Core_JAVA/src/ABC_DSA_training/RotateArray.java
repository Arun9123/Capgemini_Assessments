package ABC_DSA_training;
import java.util.*;

public class RotateArray {
	public static void printArray(int arr[]) {
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}
	public static int[] rotateClockwise(int arr[], int n) {
		int a[] = new int[arr.length];
		int x = 0;
		for (int i=n; i<arr.length; i++) {
			a[x++]=arr[i];
		}
		for (int i = 0; i < n; i++) {
			a[x++]=arr[i];
		}
		return a;
	}
	public static int[] rotateAntiClockwise(int arr[], int n) {
		int a[] = new int[arr.length];
		int x = 0;
		for (int i = arr.length-1; i > arr.length-1-n; i--) {
			a[x++]=arr[i];
		}
		for (int i=0; i<arr.length-n; i++) {
			a[x++]=arr[i];
		}
		return a;
	}
	public static void operate(int arr[], int n, int choice) {
		switch(choice) {
		case 1:
			printArray(rotateClockwise(arr, n));
			break;
		case 2:
			printArray(rotateAntiClockwise(arr, n));
			break;
		default:
			System.out.println("Enter choice as 1 or 2.");
			break;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println("Enter your choice:"
				+ "\n1. Clockwise rotation"
				+ "\n2. Anticlockwise rotation");
		int choice = sc.nextInt();
		System.out.println("Enter the number of rotations: ");
		int n = sc.nextInt();
		System.out.println("Original array: ");
		printArray(arr);
		System.out.println();
		System.out.println("Rotated array: ");
		operate(arr, n, choice);
		sc.close();
	}
}
