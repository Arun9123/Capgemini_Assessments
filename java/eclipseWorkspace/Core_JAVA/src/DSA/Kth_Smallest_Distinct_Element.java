package DSA;
import java.util.*;

public class Kth_Smallest_Distinct_Element {
	static Scanner sc = new Scanner(System.in);
	static HashSet<Integer> input() {
		HashSet<Integer> set = new HashSet<>();
		System.out.println("Enter the number of elements in the array: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter element "+(i+1)+": ");
			int ele = sc.nextInt();
			set.add(ele);
			arr[i] = ele;
		}
		System.out.println("\nEntered array: ");
		for (int i: arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		return set;
	}
	static PriorityQueue<Integer> heapify(HashSet<Integer> set, int choice) {
		PriorityQueue<Integer> q;
		switch (choice) {
		case 1:
			q = new PriorityQueue<Integer>();
			break;
		case 2:
			q = new PriorityQueue<Integer>(Collections.reverseOrder());
			break;
		default:
			System.out.println("Invalid input! Defaulting to option 1.");
			q = new PriorityQueue<Integer>();
			break;
		}
		for (int i: set) {
			q.offer(i);
		}
		return q;
	}
	static PriorityQueue<Integer> chooseOption(HashSet<Integer> set) {
		System.out.println("Enter your choice:"
				+ "\n1. Kth smallest element"
				+ "\n2. Kth largest element");
		int choice = sc.nextInt();
		return heapify(set, choice);
	}
	static int findElement(PriorityQueue<Integer> pq, int K) {
		int ans=0;
		for (int i = 0; i < K; i++) {
            ans = pq.poll();
        }
        return ans;
	}
	static void operate (HashSet<Integer> set) {
		char cont = '\u0000';
		do {
			PriorityQueue<Integer> pq = chooseOption(set);
			System.out.println("Enter the value of K: ");
			int K = sc.nextInt();
			System.out.println("The required element is: "+findElement(pq, K));
			System.out.println("Press 'y' to continue, any other key to exit: ");
			cont = sc.next().charAt(0);
		}
		while (cont == 'y');
	}
	public static void main(String[] args) {
		HashSet<Integer> set = input();
		operate(set);
		System.out.println("------------ Exiting Program ------------");
	}
}
