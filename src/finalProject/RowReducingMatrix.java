package finalProject;

import java.util.Scanner;

public class RowReducingMatrix {

	public static void rowReduce(double[][] m) {
		int pivotNum = 0; // index where currently examining

		int row = m.length;

		int col = m[0].length;

		int rowOn; // row currently examining

		boolean end = false;

		for (int r = 0; r < row && !end; r++) {
			print(m); // continuously print out the steps to row-reduce

			System.out.println();

			if (col <= pivotNum) // When checking the elements in row, it
									// reached the end
			{
				end = true;
				break; // terminate loop
			}

			rowOn = r;

			while (!end && m[rowOn][pivotNum] == 0) // Checking the numbers
													// going down the column, if
													// that number is 0,
													// continue down
			{
				rowOn++; // Increment rowOn if that element is 0

				if (row == rowOn) // hit the end of the matrix's column
				{
					rowOn = r;

					pivotNum++; // Allows the matrix to check the next column

					if (col == pivotNum) // We know that max number of pivots is
											// max number of row. m[0].length is
											// really how many rows there are
											// when you think about it.This
											// basically tells us when we hit
											// the end of the matrix.
					{
						end = true;
						break;
					}
				}
			}

			if (!end && m[rowOn][pivotNum] != 0) // goes here if that index from
													// above isn't 0
			{
				swapRows(m, rowOn, r); // First thing it does is try to swap.
										// Won't affect matrix if it can't swap
										// anyway (aka "swap with itself")

				if (m[r][pivotNum] != 0) // As long as that element isn't 0 ...
				{
					multiplyRow(m, r, (1.0 / m[r][pivotNum])); // Multiply
																// CURRENT row
																// by scalar
																// multiple
				}

				for (rowOn = 0; rowOn < row; rowOn++) // this for loop makes
														// everything else
														// (except pivot) 0 in
														// that column
				{
					if (rowOn != r) // if it's not the same row, then add
									// CURRENT row to the other rows
					{
						addRows(m, m[rowOn][pivotNum], r, rowOn);
					}
				}
			}

		}
	}

	public static void swapRows(double[][] m, int row1, int row2) {
		// temporary array for swapping
		double[] temp = new double[m[0].length];

		// filling up swap array with the values in the first row
		for (int c = 0; c < m[0].length; c++) {
			temp[c] = m[row1][c];
		}

		for (int c2 = 0; c2 < m[0].length; c2++) {
			m[row1][c2] = m[row2][c2];
			m[row2][c2] = temp[c2];
		}
	}

	public static void multiplyRow(double[][] m, int row, double scalar) {
		// multiplying specific row with a scalar
		// no need for nested for loops
		for (int c1 = 0; c1 < m[0].length; c1++) {
			m[row][c1] = m[row][c1] * scalar;
		}
	}

	public static void addRows(double[][] m, double scalar, int add_scalar_times_this_row, int from_this_row) {
		// same as above, no need for nested for loops
		// meant to turn row element into 0
		for (int c1 = 0; c1 < m[0].length; c1++) {
			m[from_this_row][c1] = (m[from_this_row][c1]) - (scalar * m[add_scalar_times_this_row][c1]);
		}
	}

	public static void print(double[][] matrix) {
		// printing out the matrix like this: [ , , ]
		for (int r = 0; r < matrix.length; r++) {
			System.out.print("[ ");

			for (int c = 0; c < matrix[0].length; c++) {
				if (c == matrix[0].length - 1) {
					System.out.print(matrix[r][c]);
				} else {
					System.out.print(matrix[r][c] + ", ");
				}
			}

			System.out.println(" ]");
		}

	}

	// testing it out
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of rows: ");

		int row = scan.nextInt();

		System.out.println("Enter the number of cols: ");

		int col = scan.nextInt();

		System.out.println("Enter the elements of the matrix");

		double[][] matrix = new double[row][col];

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				matrix[r][c] = scan.nextDouble();
			}
		}

		System.out.println("The matrix: ");

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				System.out.print(matrix[r][c] + " ");
			}

			System.out.println();
		}

		System.out.println("The matrix row-reduced (Gaussian-Jordan Elimination) (Steps are shown): ");
		System.out.println();

		rowReduce(matrix);

		scan.close();
	}

}
