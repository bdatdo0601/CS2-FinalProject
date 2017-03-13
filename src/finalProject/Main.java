package finalProject;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		double[][] mA = {{1, 2}, {3, 4}};
//		
//		Matrix matrixA = new Matrix(mA);
//		matrixA.solveInverse();
//		System.out.println(matrixA.inverse.toString());
//		
//		Matrix m = new Matrix(mA);
//		System.out.println(m.toString());
//		double[][] matrixB = {{1, 2, 3, 4}, {5, 6, 7, 8}};
//		m.setMatrix(matrixB);
//		System.out.println(m.toString());
//		double[][] matrixC = {{1, 2}, {3, 4}, {5, 6} , {7, 8}};
//		m.setMatrix(matrixC);
//		System.out.println(m.toString());
		
		
		
		double[][] b = {{10, 20}, {30, 40}}; //create multidim array
		
		Matrix matrixB = new Matrix(b); //create instance of Matrix
		
		matrixB.solveInverse(); //get the inverse of matrixB
		
		System.out.println(matrixB.inverse.toString()); //print to console
		
		double[][] b2 = {{1, 2}, {3, 4}}; //create new multidim array
		
		matrixB.setMatrix(b2); //set the matrix 
		
		//By resetting the multidim array in matrixB we 
		// are auto generating the new inverse (if it exists)
		
		System.out.println(matrixB.inverse.toString()); //print new inverse to console
	}

}
