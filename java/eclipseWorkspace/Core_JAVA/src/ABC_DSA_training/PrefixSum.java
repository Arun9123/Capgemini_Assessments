package ABC_DSA_training;

public class PrefixSum {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int sum=0, x=0;
		int prefixSum[]=new int[arr.length];
		for (int i: arr) {
			sum+=i;
			prefixSum[x++]= sum;
		}
		System.out.println("Original array: ");
		for (int i: arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("Prefix sum array: ");
		for (int i: prefixSum) {
			System.out.print(i+" ");
		}
	}
}
