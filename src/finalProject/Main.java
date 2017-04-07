package finalProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
//		System.out.println("Add Matrices Example");
//		Matrix A = new Matrix(2,2);
//		Matrix B = new Matrix(2,2);
//		
//		Matrix X = Matrix.add(A, B);
//		System.out.println(X.toString());
//		
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

//		double[][] data = { {1, 0}, {0, 1} };
//		RealMatrix n = new Array2DRowRealMatrix(data);
//		EigenDecomposition eigs = new EigenDecomposition(n);
//		double[] eigVals = eigs.getRealEigenvalues();
		
//		System.out.println("Row Reduce Example");
//		Matrix A = new Matrix(2, 2);
//		System.out.println("Matrix A: ");
//		System.out.println(A.toString());
//		System.out.println("Row reduction steps:");
//		Matrix B = Matrix.rowReduce(A);
//		System.out.println("Matrix B: ");
//		System.out.println(B.toString());
		
		
		// Example input string = "[1 2; 3 4]"
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your array in Matlab syntax:");
		String in = input.nextLine();
		double[][] matrix = new double[2][2];
		
		String validTokenPattern = "[\\[\\]\\d\\;\\s]+";
		Pattern validTokens = Pattern.compile(validTokenPattern);
	
		if ( !Pattern.matches(validTokenPattern, in) ) {
			throw new Exception("String does not match.");
		} // else continue
		
		String numberPattern = "\\d+\\.*\\d*\\s*[\\,|\\;]*";
		Pattern numberMatcher = Pattern.compile(numberPattern);
		
		// get all the matches
		Matcher m = numberMatcher.matcher(in);
		
		ArrayList<Double> outer = new ArrayList<>();
		
		while(m.find()) {
			System.out.println(m);
		}
		
		
	}
}
