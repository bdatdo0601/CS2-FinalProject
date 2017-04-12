package finalProject;

import java.util.Scanner;

public class EigenVector {
	// Testing it out
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter in dimension of square matrix: ");
		int dim = scan.nextInt();

		double[][] matrix = new double[dim][dim];

		System.out.print("Enter in values for matrix: ");

		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				matrix[r][c] = scan.nextDouble();
			}

		}

		print(matrix);
		System.out.println("Enter Eigenvalue: ");
		int eig = scan.nextInt();

		eigenVector(matrix, eig);

	}

	// Currently can only do for 2x2 or 3x3 matrices
	public static void eigenVector(double m[][], double eigVal) {
		System.out.println("A - r*I: ");

		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[0].length; c++) {
				if (r == c) {
					m[r][c] = m[r][c] - eigVal;
				}
			}
		}

		print(m);

		System.out.println();

		// Row-reducing matrix from above
		System.out.println("Creating augmented matrix: ");

		double[][] rowReduced = rowReduce(m);

		print(rowReduced);

		// Creating EigenVector
		double[] eigVector = new double[m.length];

		// 2x2 matrices:
		if (m[0].length == 2) {
			if (m[m.length - 1][m[0].length - 2] == 0) {
				eigVector[eigVector.length - 1] = 1;
			} else {
				eigVector[eigVector.length - 1] = 0 / (m[m.length][m[0].length - 2]);
			}

			eigVector[0] = -(eigVector[eigVector.length - 1]) / (m[0][0]);

			System.out.println("EigenVector is: ");
			for (int r = 0; r < eigVector.length; r++) {
				System.out.print("[" + eigVector[r] + ",");

				if (r == eigVector.length - 1) {
					System.out.print(eigVector[r] + "]");
				}

			}

		}

		// 3x3 matrices:
		if (m[0].length == 3) {

			if (m[m.length - 1][m[0].length - 2] == 0) {
				eigVector[2] = 1;
			}

			else {
				eigVector[2] = 0 / (m[m.length - 1][m[0].length - 2]);
			}

			eigVector[1] = -(eigVector[2]) / m[1][1];

			eigVector[0] = (-(eigVector[1]) - eigVector[2]) / m[0][0];

			printVector(eigVector);

		}

	}

	public static void printVector(double[] v) {
		System.out.println("EigenVector is: ");
		for (int r = 0; r < v.length; r++) {

			System.out.print("[" + v[r] + ",");

			if (r == v.length - 1) {
				System.out.print(v[r] + "]");
			}

		}
	}

	// Parameter: Matrix you want to row-reduce
	public static double[][] rowReduce(double[][] matrix) {
		int pivotNum = 0; // index where currently examining

		int row = matrix.length;

		int col = matrix[0].length;

		int rowOn; // row currently examining

		boolean end = false;

		for (int r = 0; r < row && !end; r++) {
			// print(m); //continuously print out the steps to row-reduce

			// System.out.println();

			if (col <= pivotNum) // When checking the elements in row, it
									// reached the end
			{
				end = true;
				break; // terminate loop
			}

			rowOn = r;

			while (!end && matrix[rowOn][pivotNum] == 0) // Checking the numbers
															// going down the
															// column, if that
															// number is 0,
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

			if (!end && matrix[rowOn][pivotNum] != 0) // goes here if that index
														// from above isn't 0
			{
				swapRows(matrix, rowOn, r); // First thing it does is try to
											// swap. Won't affect matrix if it
											// can't swap anyway (aka "swap with
											// itself")

				if (matrix[r][pivotNum] != 0) // As long as that element isn't 0
												// ...
				{
					multiplyRow(matrix, r, (1.0 / matrix[r][pivotNum])); // Multiply
																			// CURRENT
																			// row
																			// by
																			// scalar
																			// multiple
				}

				for (rowOn = 0; rowOn < row; rowOn++) // this for loop make
														// everything else
														// (except pivot) 0 in
														// that column
				{
					if (rowOn != r) // if it's not the same row, then add
									// CURRENT row to the other rows
					{
						addRows(matrix, matrix[rowOn][pivotNum], r, rowOn);
					}
				}
			}
		}

		return matrix;
	}

	// Methods used for above

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
		// multiplying specific row with a scalar no need for nested for loops
		for (int c1 = 0; c1 < m[0].length; c1++) {
			m[row][c1] = m[row][c1] * scalar;
		}
	}

	public static void addRows(double[][] m, double scalar, int add_scalar_times_this_row, int from_this_row) {
		// same as above, no need for nested for loops meant to turn row element
		// into 0
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

}
