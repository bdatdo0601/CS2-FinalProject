
package finalProject;

import java.util.Scanner;

public class Matrix {
	
	Scanner scan = new Scanner(System.in);
	
	private double[][] matrix;
	private int numRows;
	private int numCols;
	private boolean hasInverse; 
	
	private double[][] transpose;
	
	private double[][] rREF; //reduced Row Echelon form
	
	private double determinant;
	
	private double[] eigenvalues;
	

//	Constructors and enterValues method
	
	public Matrix () { }
	
	public Matrix(int rows, int cols) {
		this.numRows = rows;
		this.numCols = cols;
		this.matrix = new double[rows][cols];
		this.enterValues(rows, cols);
		this.hasInverse = isInvertible(this.matrix);
		this.transpose = transpose(this.matrix);
	}
	
	public Matrix(double[][] m) {
		this.matrix = m;
		this.numRows = m.length;
		this.numCols = m[0].length;
		this.hasInverse = isInvertible(this.matrix);
		this.transpose = transpose(this.matrix);
	}
	
	private void enterValues(int r, int c) {
		System.out.println("Enter the values for your " + r + " by " + c + " array:");
		for ( int i = 0; i < r; i++ ) {
			for ( int j = 0; j < c; j++ ) {
				this.matrix[i][j] = scan.nextDouble();
			}
		}
	}
	
//	Getters and Setters
	
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
//	After defining two matrices use this function like so:
//	Matrix A = new Matrix(2,2);
//	Matrix B = new Matrix(2,2);
//	Matrix x = Matrix.add(A, B);
	
	public static Matrix add(Matrix matrixA, Matrix matrixB) {
		double[][] a = matrixA.getMatrix();
		double[][] b = matrixB.getMatrix();
		
		int rA = matrixA.getNumRows();
		int cA = matrixA.getNumCols();
		
		int rB = matrixB.getNumRows();
		int cB = matrixB.getNumCols();
		
		try {
			if ( rA != rB && cA != cB ) {
				throw new Exception("Matrix dimensions are not equivalent.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Matrix();
		}
		
		if (rA == rB && cA == cB ) {
			double[][] newM = new double[rA][cA];
			for (int i = 0; i < rA; i++){
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
//	After defining two matrices use this function like so:
//	Matrix A = new Matrix(2,2);
//	Matrix B = new Matrix(2,2);
//	Matrix x = Matrix.multiply(A, B);
	
	public static Matrix multiply(Matrix matrixA, Matrix matrixB) {
		
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
		
		for ( int r = 0; r < rA; r++ ) {
			for ( int c = 0; c < cB; c++ ) {
				for ( int k = 0; k < cA; k++ ) {
					product[r][c] = product[r][c] + a[r][k] * b[k][c];
				}
			}
		}
		return new Matrix(product);
	}
	
// Inverse 
	
	public static boolean isInvertible(double[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length; 
		boolean is2by2 = (rowCount == colCount) && (rowCount == 2);
		if ( is2by2 ) {
			double a = matrix[0][0];
			double b = matrix[0][1];
			double c = matrix[1][0];
			double d = matrix[1][1];
			boolean mulDifTest = (a*d) - (b*c) != 0;
			return is2by2 && mulDifTest;
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
		
		double m = 1 / (a*d - b*c);
		double[][] inverse = {{m*d, m*(-b)}, {m*(-c), m*a}};
		return inverse;
	}
	
// Determinant
	//Parameters: Matrix and its dimension 
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
        
        if(dim == 1) {
            det = M[0][0];
        } else if (dim == 2) {
            det = M[0][0]*M[1][1] - M[1][0]*M[0][1]; //ad - bc
        } else {
            det = 0;
            for(int j1=0;j1<dim;j1++) {
                double[][] m = new double[dim-1][dim-1];
                //m is the minor matrix
                for(int i = 1; i < dim; i++) { //because the first row is always expanded upon in my algorithm
                    int j2=0;
                    for(int j=0;j<dim;j++) {
                        if(j == j1) continue; //continue without processing statements below
                        m[i-1][j2] = M[i][j]; //otherwise, put it into the minor
                        j2++;
                    }
                }
                det += Math.pow(-1.0,1.0+j1+1.0)* M[0][j1] * determinant(m, dim-1); //to do large determinants it's - + - + ....etc 
                System.out.println("determinant: " + det); 
            }   
        }
        return det;
    }

	
// Reduced Row Echelon Form
	public double[][] solveRREF(double[][] matrix) {
		
		// get reduced row echelon form
		double[][] result = matrix;
		
		// set the rREF variable
		return result;
	}
	
	public double[][] getRREF() {
		return this.rREF;
	}

// Transpose of a matrix
	public static double[][] transpose(double[][] m) {
		int rows = m.length;
		int cols = m[0].length;
		//just flip order 
		double[][] t = new double[cols][rows];
		for(int c = 0; c < m[0].length; c++) {
			for(int r = 0; r < m.length; r++) {
				t[c][r] = m[r][c];
			}
		}
		return t;
	}

	
// toString method - useful for command line based testing
	
	public String toString() {
		double[][] matrix = this.matrix;
		StringBuffer str = new StringBuffer();
		
		StringBuffer s = new StringBuffer();
		
		str.append("\n");
		for (int i = 0; i < matrix.length; i++) {
			s.append("  [ ");
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
	

	
	
	
}
