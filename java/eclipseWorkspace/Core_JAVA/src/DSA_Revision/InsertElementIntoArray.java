package DSA_Revision;
import java.util.*;

public class InsertElementIntoArray {
	public static int[] insertElement(int arr[], int k) {
		
		return arr;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter the value of n: ");
		n=sc.nextInt();
		int arr[]= new int[n+1];
		System.out.println("Enter the values in the array: ");
		for (int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter the new value: ");
		int k=sc.nextInt();
		insertElement(arr, k);
		sc.close();
	}
}
