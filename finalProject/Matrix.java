
package finalProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Matrix {

	Scanner scan = new Scanner(System.in);

	private double[][] matrix;
	private int numRows;
	private int numCols;
	private boolean hasInverse;

	private double[][] transpose;

	private double[][] rREF; // reduced Row Echelon form

	private double determinant;

	private double[] eigenvalues;

	// Constructors and enterValues method

	public Matrix() {
	}

	public Matrix(int rows, int cols) {
		this.numRows = rows;
		this.numCols = cols;
		this.matrix = new double[rows][cols];
		this.enterValues(rows, cols);
		this.transpose = transpose(this.matrix);
	}

	public Matrix(double[][] m) throws Exception {
		this.matrix = m;
		this.numRows = m.length;
		this.numCols = m[0].length;
		this.hasInverse = isInvertible(this.matrix);
		this.transpose = transpose(this.matrix);
	}

	public Matrix(double[][] m, boolean isInvertible) {
		this.matrix = m;
		this.numRows = m.length;
		this.numCols = m[0].length;
		this.hasInverse = isInvertible;
		this.transpose = transpose(this.matrix);
	}

	private void enterValues(int r, int c) {
		System.out.println("Enter the values for your " + r + " by " + c + " array:");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				this.matrix[i][j] = scan.nextDouble();
			}
		}
	}

	// Getters and Setters

	public double[][] getMatrix() {
		return this.matrix;
	}

	public boolean getHasInverse() {
		return this.hasInverse;
	}

	public int getNumRows() {
		return this.numRows;
	}

	public int getNumCols() {
		return this.numCols;
	}

	// Addition; add two Matrices and return a new Matrix instance
	// After defining two matrices use this function like so:
	// Matrix A = new Matrix(2,2);
	// Matrix B = new Matrix(2,2);
	// Matrix x = Matrix.add(A, B);

	public static Matrix add(Matrix matrixA, Matrix matrixB) throws Exception {
		double[][] a = matrixA.getMatrix();
		double[][] b = matrixB.getMatrix();

		int rA = matrixA.getNumRows();
		int cA = matrixA.getNumCols();

		int rB = matrixB.getNumRows();
		int cB = matrixB.getNumCols();

		try {
			if (rA != rB && cA != cB) {
				throw new Exception("Matrix dimensions are not equivalent.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Matrix();
		}

		if (rA == rB && cA == cB) {
			double[][] newM = new double[rA][cA];
			for (int i = 0; i < rA; i++) {
				for (int j = 0; j < cA; j++) {
					newM[i][j] = a[i][j] + b[i][j];
				}
			}
			return new Matrix(newM);
		} else {
			return new Matrix();
		}
	}

	// Multiply two Matrices and return a new Matrix instance
	// After defining two matrices use this function like so:
	// Matrix A = new Matrix(2,2);
	// Matrix B = new Matrix(2,2);
	// Matrix x = Matrix.multiply(A, B);

	public static Matrix multiply(Matrix matrixA, Matrix matrixB) throws Exception {

		double[][] a = matrixA.getMatrix();
		double[][] b = matrixB.getMatrix();

		int rA = matrixA.getNumRows();
		int cA = matrixA.getNumCols();

		int rB = matrixB.getNumRows();
		int cB = matrixB.getNumCols();

		try {
			if (cA != rB) {
				throw new Exception("The number of rows in A is not equivalent to the number of columns in B.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Matrix();
		}

		double[][] product = new double[rA][cB];

		for (int r = 0; r < rA; r++) {
			for (int c = 0; c < cB; c++) {
				for (int k = 0; k < cA; k++) {
					product[r][c] = product[r][c] + a[r][k] * b[k][c];
				}
			}
		}
		return new Matrix(product);
	}

	// Inverse

	public static boolean isInvertible(double[][] matrix) throws Exception {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		boolean is2by2 = (rowCount == colCount) && (rowCount == 2);
		if (is2by2) {
			double a = matrix[0][0];
			double b = matrix[0][1];
			double c = matrix[1][0];
			double d = matrix[1][1];
			boolean mulDifTest = (a * d) - (b * c) != 0;
			return is2by2 && mulDifTest;
		} else if (rowCount == colCount) {
			Matrix m = new Matrix(matrix, false);
			double det = Matrix.getDeterminant(m);
			return det != 0;
		} else {
			return false;
		}
	}

	public static Matrix getInverse(Matrix A) throws Exception {
		double[][] matrix = A.getMatrix();
		if (A.hasInverse) {
			double[][] inverse = Matrix.solveInverse(matrix);
			return new Matrix(inverse);
		} else {
			throw new Exception("This matrix is not invertible.");
		}
	}

	public static double[][] solveInverse(double[][] matrix) {
		double a = matrix[0][0];
		double b = matrix[0][1];
		double c = matrix[1][0];
		double d = matrix[1][1];

		double m = 1 / (a * d - b * c);
		double[][] inverse = { { m * d, m * (-b) }, { m * (-c), m * a } };
		return inverse;
	}

	// Determinant
	// Parameters: Matrix and its dimension
	public static double getDeterminant(Matrix X) throws Exception {
		int numRow = X.getNumRows();
		int numCol = X.getNumCols();
		if (numRow != numCol) {
			throw new Exception("Matrix must be square in order to find determinant.");
		}

		double[][] M = X.getMatrix();
		int dim = numRow;

		return determinant(M, dim);
	}

	private static double determinant(double[][] M, int dim) throws Exception {
		double det = 0;

		if (dim == 1) {
			det = M[0][0];
		} else if (dim == 2) {
			det = M[0][0] * M[1][1] - M[1][0] * M[0][1]; // ad - bc
		} else {
			det = 0;
			for (int j1 = 0; j1 < dim; j1++) {
				double[][] m = new double[dim - 1][dim - 1];
				// m is the minor matrix
				for (int i = 1; i < dim; i++) { // because the first row is
												// always expanded upon in this
												// algorithm
					int j2 = 0;
					for (int j = 0; j < dim; j++) {
						if (j == j1){
							continue; // continue without processing statements
										// below
						}
						m[i - 1][j2] = M[i][j]; // otherwise, put it into the
												// minor
						j2++;
					}
				}
				det += Math.pow(-1.0, 1.0 + j1 + 1.0) * M[0][j1] * determinant(m, dim - 1); // to
																							// do
																							// large
																							// determinants
																							// it's
																							// -
																							// +
																							// -
																							// +
																							// ....etc
				System.out.println("determinant: " + det);
			}
		}
		return det;
	}

	// Row Reducing Matrix
	// Prints steps to console
	// Returns a new Matrix with the reduced

	public static Matrix rowReduce(Matrix M) {
		double[][] m = M.getMatrix();
		int pivotNum = 0; // index where currently examining
		int row = m.length;
		int col = m[0].length;
		int rowOn; // row currently examining
		boolean end = false;
		for (int r = 0; r < row && !end; r++) {
			print(m); // continuously print out the steps to row-reduce
			System.out.println();
			if (col <= pivotNum) {// When checking the elements in row, it
									// reached the end
				end = true;
				break; // terminate loop
			}
			rowOn = r;
			while (!end && m[rowOn][pivotNum] == 0) { // Checking the numbers
														// going down the
														// column, if that
														// number is 0, continue
														// down
				rowOn++; // Increment rowOn if that element is 0
				if (row == rowOn) { // hit the end of the matrix's column
					rowOn = r;
					pivotNum++; // Allows the matrix to check the next column
					if (col == pivotNum) { // We know that max number of pivots
											// is max number of row. m[0].length
											// is really how many rows there are
											// when you think about it.This
											// basically tells us when we hit
											// the end of the matrix.
						end = true;
						break;
					}
				}
			}

			if (!end && m[rowOn][pivotNum] != 0) {// goes here if that index
													// from above isn't 0
				swapRows(m, rowOn, r); // First thing it does is try to swap.
										// Won't affect matrix if it can't swap
										// anyway (aka "swap with itself")
				if (m[r][pivotNum] != 0) {// As long as that element isn't 0 ...
					multiplyRow(m, r, (1.0 / m[r][pivotNum])); // Multiply
																// CURRENT row
																// by scalar
																// multiple
				}
				for (rowOn = 0; rowOn < row; rowOn++) { // this for loop makes
														// everything else
														// (except pivot) 0 in
														// that column
					if (rowOn != r) { // if it's not the same row, then add
										// CURRENT row to the other rows
						addRows(m, m[rowOn][pivotNum], r, rowOn);
					}
				}
			}
		}
		return new Matrix(m, true);
	}

	private static void swapRows(double[][] m, int row1, int row2) {
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

	private static void multiplyRow(double[][] m, int row, double scalar) {
		// multiplying specific row with a scalar
		// no need for nested for loops
		for (int c1 = 0; c1 < m[0].length; c1++) {
			m[row][c1] = m[row][c1] * scalar;
		}
	}

	private static void addRows(double[][] m, double scalar, int add_scalar_times_this_row, int from_this_row) {
		// same as above, no need for nested for loops
		// meant to turn row element into 0
		for (int c1 = 0; c1 < m[0].length; c1++) {
			m[from_this_row][c1] = (m[from_this_row][c1]) - (scalar * m[add_scalar_times_this_row][c1]);
		}
	}

	private static void print(double[][] matrix) {
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

	// End of Row Reduce

	// Transpose of a matrix
	public static double[][] transpose(double[][] m) {
		int rows = m.length;
		int cols = m[0].length;
		// just flip order
		double[][] t = new double[cols][rows];
		for (int c = 0; c < m[0].length; c++) {
			for (int r = 0; r < m.length; r++) {
				t[c][r] = m[r][c];
			}
		}
		return t;
	}

	// End of Transpose

	// EIGS

	public static double[] getEigenValues(double[][] matrix) {
		RealMatrix n = new Array2DRowRealMatrix(matrix);
		EigenDecomposition eigs = new EigenDecomposition(n);
		double[] eigVals = eigs.getRealEigenvalues();
		return eigVals;
	}

	public static String getEigenVectors(double[][] matrix, int i) {
		RealMatrix n = new Array2DRowRealMatrix(matrix);
		EigenDecomposition eigs = new EigenDecomposition(n);
		RealVector v = eigs.getEigenvector(i);
		return v.toString();
	}

	// toString method - useful for command line based testing

	public String toString() {
		double[][] matrix = this.matrix;
		StringBuffer str = new StringBuffer();

		StringBuffer s = new StringBuffer();

		str.append("\n");
		for (int i = 0; i < matrix.length; i++) {
			s.append("[ ");
			for (int j = 0; j < matrix[i].length; j++) {
				String ss = j == matrix[i].length - 1 ? " " : ", ";
				s.append(matrix[i][j] + ss);
			}
			s.append("]\n");
			str.append(s);
			s.delete(0, s.length());
		}
		str.append("");

		return str.toString();
	}

	// parse Method
	public static Matrix parseUserInputToMatrix(String in) throws Exception {
		String validTokenPattern = "[\\[\\]\\d\\;\\,\\s]+";
		Pattern validTokens = Pattern.compile(validTokenPattern);

		if (!Pattern.matches(validTokenPattern, in)) {
			throw new Exception("String does not match.");
		} // else continue

		String numberPattern = "\\d+\\.*\\d*\\s*[\\,|\\;]*";
		Pattern numberMatcher = Pattern.compile(numberPattern);

		// get all the matches
		Matcher m = numberMatcher.matcher(in);

		ArrayList<ArrayList<Double>> outer = new ArrayList<ArrayList<Double>>();

		String match;
		double num;
		ArrayList<Double> inner = new ArrayList<Double>();

		boolean hasRowCountBeenSet = false;
		int rowCount = 0;

		while (m.find()) {
			match = in.substring(m.start(), m.end());
			if (match.contains(",")) {
				match = match.replace(",", "");
				num = Double.parseDouble(match);
				inner.add(num);
			} else {
				match = match.replaceAll(";", "");
				num = Double.parseDouble(match);
				inner.add(num);

				if (!hasRowCountBeenSet) {
					rowCount = inner.size();
					hasRowCountBeenSet = true;
				} else if (rowCount != inner.size())
					throw new Exception("Matrix rows not same size");

				ArrayList<Double> temp = (ArrayList<Double>) inner.clone();
				outer.add(temp);
				inner.clear();
			}
		}

		double[][] matrix = new double[outer.size()][rowCount];
		for (int row = 0; row < matrix.length; row++) {
			ArrayList<Double> v = outer.get(row);
			for (int col = 0; col < matrix[row].length; col++) {
				double d = v.get(col).doubleValue();
				System.out.println("D: " + d);
				matrix[row][col] = d;
			}
		}

		return new Matrix(matrix);
	}
}
