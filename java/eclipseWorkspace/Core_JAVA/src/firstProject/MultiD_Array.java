package firstProject;

public class MultiD_Array {
	public static int total_elements(int arr[][]) {
//		int rows=arr.length;
//		int cols=arr[0].length;
//		return rows*cols;
		int c=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				c++;
			}
		}
		return c;
	}
	public static boolean check_column_matrix(int arr[][]) {
		for (int i=0; i<arr.length; i++) {
			if (arr[i].length!=1) {
				return false;
			}
		}
		return true;
	}
	public static void print_matrix (int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);;
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int [][] ar1 = new int [2][2];
		System.out.println(ar1);
		print_matrix(ar1);
		System.out.print("Total number of elements in array 1: ");
		System.out.println("Array 1:");
		System.out.println(total_elements(ar1));
		int ar2[][]= {{1,2,3}, {4,5}, {6}, {7}};
		System.out.println("Array 2:");
		print_matrix(ar2);
		System.out.print("Total number of elements in array 2: ");
		System.out.println(total_elements(ar2));
		try {
			ar2[1][2]=6;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		int ar3[][]= {{1}, {2}, {3}};
		System.out.println("Array 3:");
		print_matrix(ar3);
		if (check_column_matrix(ar3)) {
			System.out.println("Column matrix");
		}
		else {
			System.out.println("NOT Column matrix");
		}
	}
}
