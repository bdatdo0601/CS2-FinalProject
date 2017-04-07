package finalProject;

import java.util.Scanner;

public class MultiplyMatrix {
	public static int[][] multiply(int[][] a, int[][] b) {

		int rowsInA = a.length;
		int columnsInA = a[0].length; // same as rows in B
		int rowsInB = b.length;
		int columnsInB = b[0].length;

		int[][] C = new int[rowsInA][columnsInB]; // stores results in new
													// matrix (dimensions =
													// outer dimensions of A *
													// B)

		for (int r = 0; r < rowsInA; r++) {

			for (int c = 0; c < columnsInB; c++) {
				for (int k = 0; k < columnsInA; k++) {
					C[r][c] = C[r][c] + a[r][k] * b[k][c]; // C[row][col] = # in
															// row of A *
															// corresponding #
															// in col of B
				}
			}
		}
		return C;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter number of rows in matrix A: ");
		int rowsInA = scan.nextInt();

		System.out.print("Enter number of columns in matrix A: ");
		int columnsInA = scan.nextInt();

		System.out.println("Enter number of rows in matrix B: ");
		int rowsInB = scan.nextInt();

		while (rowsInB != columnsInA) {
			System.out.println(
					"Sorry, but in order for this to work, number of columns in A must match number of rows in B: ");
			rowsInB = scan.nextInt();
		}

		System.out.print("Enter number of columns in matrix B: ");
		int columnsInB = scan.nextInt();

		int[][] A = new int[rowsInA][columnsInA];

		int[][] B = new int[rowsInB][columnsInB];

		System.out.println("Enter values inside matrix A");

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j] = scan.nextInt();
			}
		}
		System.out.println("Enter values inside matrix B");

		for (int r = 0; r < B.length; r++) {
			for (int c = 0; c < B[0].length; c++) {
				B[r][c] = scan.nextInt();
			}
		}

		int[][] result = multiply(A, B); // special method to multiply the 2
											// matrices

		System.out.println("Product of A and B is");

		for (int r = 0; r < result.length; r++) {
			for (int c = 0; c < result[0].length; c++) {
				System.out.print(result[r][c] + " ");
			}

			System.out.println();
		}

		scan.close();

	}

}
