
package finalProject;

public class Matrix {
	
	private double[][] matrix;
	
	public Inverse inverse;
	private boolean hasInverse; 
	
	private double[][] transpose;
	
	private double[][] rREF; //reduced Row Echelon form
	
	private double determinant;
	
	private double[] eigenvalues;
	
	public Matrix() {
		
	}
	
	public Matrix(double[][] matrix) {
		this.matrix = matrix;
		this.hasInverse = Inverse.isInvertible(matrix);
		this.rREF = solveRREF(matrix);
	}
	
	public double[][] getMatrix() {
		return this.matrix;
	}
	
	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
		this.hasInverse = Inverse.isInvertible(matrix);
		solveInverse();
		this.rREF = solveRREF(matrix);
	}

	public void solveInverse() {
		if (hasInverse) {
			double[][] inverse = Inverse.solveInverse(getMatrix());
			this.inverse = new Inverse(inverse);
		}
	}
	
	protected double[][] solveRREF(double[][] matrix) {
		
		// get reduced row echelon form
		double[][] result = matrix;
		
		// set the rREF variable
		return result;
	}
	
	public double[][] getRREF() {
		return this.rREF;
	}
	
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
