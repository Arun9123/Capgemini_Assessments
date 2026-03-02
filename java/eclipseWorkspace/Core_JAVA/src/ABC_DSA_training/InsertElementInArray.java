package ABC_DSA_training;

public class InsertElementInArray {
	public static void main(String[] args) {
		int arr[] = {1,2,4,5};
		int pos=2;
		int ele=3;
		int arr2[] = new int[arr.length+1];
		int x=0;
		for (int i = 0; i < arr2.length; i++) {
			if(i==pos) {
				arr2[x++]=ele;
			}
			else if (i < pos){
				arr2[x++]=arr[i];
			}
			else {
				arr2[x++]=arr[i-1];
			}
		}
		System.out.println("Old array: ");
		for (int i: arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("New array: ");
		for (int i: arr2) {
			System.out.print(i+" ");
		}
	}
}
