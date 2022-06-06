import java.util.Scanner;

public class AddMatrices {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the row/column size of the matrices: ");
		int size = scan.nextInt();
		System.out.println("First matrix: ");
		int A[][] = inputMatrix(size);
		System.out.println("Second matrix: ");
		int B[][] = inputMatrix(size);
		
        
		System.out.println("\nMatrix A:");
		printMatrix(A, size);
		System.out.println("\nMatrix B:");
		printMatrix(B, size);
		
		int C[][] = addMatrix(A, B, size);
		System.out.println("\nResultant matrix:");
		printMatrix(C, size);
		
		
	}
	
	public static int[][] inputMatrix(int size) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter elements for each row, separated by spaces: ");
		
		int M[][] = new int [size][size];
		
		for (int i=0; i < size; i++) {
			for (int j=0; j < size; j++) {
				M[i][j] = sc.nextInt();
				
			}
		}
		return M;
	}

	public static void printMatrix(int M[][], int size) {
		for (int i=0; i < size; i++) {
			for (int j=0; j < size; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] addMatrix(int A[][], int B[][], int size) {
		int C[][] = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}
}
