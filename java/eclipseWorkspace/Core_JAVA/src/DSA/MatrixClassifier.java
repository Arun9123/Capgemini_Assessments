package DSA;

import java.util.Scanner;

public class MatrixClassifier {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Matrix Classifier ===");
        
        boolean running = true;
        while (running) {
            int[][] matrix = inputJaggedMatrix();
            if (matrix != null) {
                printMatrix(matrix);
                classifyMatrix(matrix);
            }
            running = askToContinue();
        }
        
        System.out.println("\n[System] Program terminated. Have a great day!");
        scanner.close();
    }

    public static int[][] inputJaggedMatrix() {
        System.out.println("\nEnter matrix (Example: {{1,0,0},{0,1,0},{0,0,1}}): ");
        String input = scanner.next().trim();

        try {
            String content = input.substring(2, input.length() - 2);
            String[] rowStrings = content.split("\\},\\{");
            
            int[][] matrix = new int[rowStrings.length][];
            
            for (int i = 0; i < rowStrings.length; i++) {
                String[] elements = rowStrings[i].split(",");
                matrix[i] = new int[elements.length];
                for (int j = 0; j < elements.length; j++) {
                    matrix[i][j] = Integer.parseInt(elements[j].trim());
                }
            }
            return matrix;
        } catch (Exception e) {
            System.out.println("Error: Invalid format. Ensure you use {{a,b},{c,d}} with no spaces inside.");
            return null;
        }
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("\nDetected Matrix Structure:");
        for (int[] row : matrix) {
            System.out.print("| ");
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println("|");
        }
    }

    public static void classifyMatrix(int[][] matrix) {
        int rows = matrix.length;
        
        if (isJagged(matrix)) {
            System.out.println("Result: Jagged Array (Ragged Matrix)");
            System.out.println("Note: Mathematical properties (Identity, etc.) do not apply.");
            return;
        }

        int cols = matrix[0].length;
        System.out.println("\n--- Analysis Report ---");

        if (isSingleton(rows, cols)) {
            System.out.println("-> Singleton Matrix (is also Row and Column)");
        } else {
            if (rows == 1) System.out.println("-> Row Matrix");
            if (cols == 1) System.out.println("-> Column Matrix");
        }

        if (isSquare(rows, cols)) {
            System.out.println("-> Square Matrix");
            checkSquareSubTypes(matrix);
        } else {
            System.out.println("-> Rectangular Matrix");
        }

        if (isZeroMatrix(matrix)) System.out.println("-> Zero (Null) Matrix");
    }

    private static void checkSquareSubTypes(int[][] m) {
        if (isDiagonal(m)) {
            System.out.println("-> Diagonal Matrix");
            if (isScalar(m)) {
                if (m[0][0] == 1) System.out.println("-> Identity Matrix");
                else System.out.println("-> Scalar Matrix");
            }
        }
    }

    public static boolean isJagged(int[][] m) {
        int standardLength = m[0].length;
        for (int i = 1; i < m.length; i++) {
            if (m[i].length != standardLength) return true;
        }
        return false;
    }

    public static boolean isSquare(int r, int c) { return r == c; }

    public static boolean isSingleton(int r, int c) { return r == 1 && c == 1; }

    public static boolean isZeroMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row) if (val != 0) return false;
        }
        return true;
    }

    public static boolean isDiagonal(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i != j && m[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static boolean isScalar(int[][] m) {
        int firstDiag = m[0][0];
        for (int i = 0; i < m.length; i++) {
            if (m[i][i] != firstDiag) return false;
        }
        return true;
    }

    public static boolean askToContinue() {
        System.out.print("\nEnter 'y' to continue, or any other key to exit: ");
        String choice = scanner.next();
        return choice.equalsIgnoreCase("y");
    }
}