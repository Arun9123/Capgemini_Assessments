package DSA;

public class SetMatrixZero {
	static int [][] arr = {{1, 4, 7}, {2, 0, 8}, {3, 6, 9}};
	static {
		System.out.println("Original array: ");
		multDimArrayPrinter(arr);
	}
	static int noOfEleInMultDimArr=0;
	public static void multDimArrayPrinter (int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+ " ");
				++noOfEleInMultDimArr;
			}
			System.out.println();
		}
	}
	static Coordinate[] cords = new Coordinate[noOfEleInMultDimArr];
	static int cordsIndexHolder=0;
	public static void zeroElementCoordinateTracker(int [][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j]==0) {
					Coordinate coordinate = new Coordinate (i, j);
					cords [cordsIndexHolder++]= coordinate;
				}
			}
		}
	}
	
	public static void cordsPrinter (Coordinate [] cords) {
		System.out.println("Coordinates: ");
		for (int i = 0; i < cords.length; i++) {
			if(cords[i]!=null) {
				System.out.println("Row: "+ cords[i].row);
				System.out.println("Col: "+ cords[i].col);
			}
		}
	}
	public static void main(String[] args) {
		zeroElementCoordinateTracker(arr);
		cordsPrinter(cords);
	}
}

class Coordinate{
	int row, col;
	public Coordinate (int row, int col) {
		this.row=row;
		this.col=col;
	}
}