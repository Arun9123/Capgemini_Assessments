package ABC_DSA_training;
import java.util.*;

public class DeleteFromArray {
	public static int[] deleteIndex(int arr[], int pos) {
		if (pos > arr.length-1 || pos<0) {
			System.out.println("Index must be between 0 and "+ (arr.length-1));
			return arr;
		}
//		for (int i = 0; i < arr.length-1; i++) {
//			if(i>=pos) {
//				arr[i]=arr[i+1];
//			}
//		}
//		arr[arr.length-1]=0;
		
		return arr;
	}
	public int[] deleteElement(int arr[], int e) {
		return arr;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int arr[] = {1,2,3,4,5};
		System.out.println("Original array: ");
		for (int i: arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("Enter index to delete: ");
		int pos = sc.nextInt();
		System.out.println();
		if (!(Arrays.equals(arr, deleteIndex(arr, pos)))) {
			System.out.println();
			System.out.println("Modified array: ");
			for (int i: arr) {
				System.out.print(i+" ");
			}
		}
		sc.close();
	}
}
