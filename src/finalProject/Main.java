package finalProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Add Matrices Example");
		Matrix A = new Matrix(2,2);
		Matrix B = new Matrix(2,2);
		
		Matrix X = Matrix.add(A, B);
		System.out.println(X.toString());
		
//		System.out.println("Multiply Matrices Example");
//		Matrix A = new Matrix(2,2);
//		Matrix B = new Matrix(2,2);
//		
//		Matrix X = Matrix.multiply(A, B);
//		System.out.println(X.toString());
		
//		System.out.println("Solving Inverse Example");
//		Matrix C = new Matrix(2, 2);
//		Matrix inverseC = Matrix.getInverse(C);
//		System.out.println(inverseC.toString());

	}
}
