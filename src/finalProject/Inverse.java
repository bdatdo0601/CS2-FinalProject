/*
 * Find The Inverse of a Matrix if it exists.
 * Test cases:
 * 1. 2 by 2 matrix that is invertible
 * 2. 2 by 2 matrix that is not invertible 
 * 3. n x m matrix 
 * 
 */

package finalProject;

public class Inverse {
	
	private double[][] originalMatrix;
	private double[][] inverseMatrix;
	private boolean isInv;
	public Inverse() {
		this.isInv = false;
	}
	
	public Inverse(double[][] matrix) {
		this.originalMatrix = matrix;
		this.isInv = isInvertible(matrix);
		if ( this.isInv ) setInverse(matrix);
	}
	
	public boolean isInvertible(double[][] matrix) {
		
		int rowCount = matrix.length;
		int colCount = matrix[0].length; 
		
		boolean is2by2 = (rowCount == colCount) && (rowCount == 2);
		
		double a = matrix[0][0];
		double b = matrix[0][1];
		double c = matrix[1][0];
		double d = matrix[1][1];
		
		boolean mulDifTest = (a*d) - (b*c) != 0;
		
		return is2by2 && mulDifTest;
		
	}
	
	public void setMatrix(double[][] matrix) {
		this.originalMatrix = matrix;
	}
	public void setInverse(double[][] matrix) {
		
		double a = matrix[0][0];
		double b = matrix[0][1];
		double c = matrix[1][0];
		double d = matrix[1][1];
		
		double m = 1 / (a*d - b*c);
		
		double[][] inverse = {{m*d, m*(-b)}, {m*(-c), m*a}};
		
		this.inverseMatrix = inverse;
	}
	
	public double[][] getMatrix() {
		return this.originalMatrix;
	}
	public double[][] getInverse() {
		return this.inverseMatrix;
	}
	
	public String toString() {
		double[][] inverse = getInverse();
		return "[ ["+inverse[0][0]+", "+inverse[0][1]+"], ["+inverse[1][0]+", "+inverse[1][1]+"] ]";
	}

}
