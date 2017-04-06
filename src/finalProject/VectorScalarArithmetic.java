package finalProject;
import java.util.Scanner; 

public class VectorScalarArithmetic 
{
	//To test methods
	public static void main(String[] args) 
	{
		//Make sure both vectors are same length
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to do A (Vector Addition). "+
							"B (Vector Subtraction), C (Vector Scalar Multiplication), D (Vector Multiplication) or E (Exit)? "); 
		
		String userResponse = scan.nextLine();
		
		if( userResponse.equalsIgnoreCase("A"))
		{
			System.out.println("Please Enter Length of both vectors: "); 
			int len = scan.nextInt();
			
			double [] A = new double[len];
			double [] B = new double[len]; 
			
			System.out.println("Please enter values inside first vector: "); 
			for(int i = 0; i<A.length; i++)
			{
				A[i] = scan.nextDouble(); 
			}
			
			System.out.println("Please enter values inside second vector: "); 
			for(int i = 0; i<B.length; i++)
			{
				B[i] = scan.nextDouble(); 
			}
			
			System.out.println("First Vector + Second Vector = " + vectorAddition(A,B));
		}
		
		if( userResponse.equalsIgnoreCase("B"))
		{
			System.out.println("Please Enter Length of both vectors: "); 
			int len = scan.nextInt();
			
			double [] A = new double[len];
			double [] B = new double[len]; 
			
			System.out.println("Please enter values inside first vector: "); 
			for(int i = 0; i<A.length; i++)
			{
				A[i] = scan.nextDouble(); 
			}
			
			System.out.println("Please enter values inside second vector: "); 
			for(int i = 0; i<B.length; i++)
			{
				B[i] = scan.nextDouble(); 
			}
			
			System.out.println("First Vector - Second Vector = " + vectorSubtraction(A,B));
		}
		
		if( userResponse.equalsIgnoreCase("C"))
		{
			System.out.println("Please Enter Length of vector: "); 
			int len = scan.nextInt();
			
			double [] A = new double[len];
			
			
			System.out.println("Please enter values inside first vector: "); 
			for(int i = 0; i<A.length; i++)
			{
				A[i] = scan.nextDouble(); 
			}
			
			System.out.println("Please enter value of scalar multiple: "); 
			
			double b = scan.nextDouble();
			
			System.out.println("Vector * scalar multiple = " + vectorScalarMultiplication(A,b));
		}
		
		if( userResponse.equalsIgnoreCase("D"))
		{
			System.out.println("Please Enter Length of both vectors: "); 
			int len = scan.nextInt();
			
			double [] A = new double[len];
			double [] B = new double[len]; 
			
			System.out.println("Please enter values inside first vector: "); 
			for(int i = 0; i<A.length; i++)
			{
				A[i] = scan.nextDouble(); 
			}
			
			System.out.println("Please enter values inside second vector: "); 
			for(int i = 0; i<B.length; i++)
			{
				B[i] = scan.nextDouble(); 
			}
			
			System.out.println("First Vector * Second Vector = " + vectorMultiplication(A,B));
		}
		
		if (userResponse.equalsIgnoreCase("E"))
		{
			System.exit(0);
			
		}
		
		
		while(!userResponse.equalsIgnoreCase("A") && !userResponse.equalsIgnoreCase("B") && !userResponse.equalsIgnoreCase("C") && !userResponse.equalsIgnoreCase("D") && !userResponse.equalsIgnoreCase("E"))
		{
			System.out.println("Invalid Response, Please re-enter: ");
			userResponse = scan.nextLine();
		}

		scan.close();

	}
	
	
	public static double[] vectorAddition(double[] a , double[] b)
	{
		double [] ans = new double[a.length];
		
		for(int i = 0; i < a.length; i++)
		{
			ans[i] = a[i] + b[i];
		}
		
		return ans;
	}
	
	public static double[] vectorScalarMultiplication(double[]a, double b)
	{
		double [] answer = new double[a.length]; 
		
		for(int i = 0; i < a.length; i++)
		{
			answer[i] = a[i] * b;
		}
		
		return answer;
		
	}
	
	public static double[] vectorMultiplication(double [] a , double [] b)
	{
		double [] answer = new double[a.length];  
		
		for(int i = 0; i < a.length; i++)
		{
			answer[i] = a[i] * b[i];
		}
		
		return answer;
	}
	
	public static double[] vectorSubtraction(double [] a, double[] b)
	{
		double [] answer = new double[a.length];  
		
		for(int i = 0; i < a.length; i++)
		{
			answer[i] = a[i] - b[i];
		}
		
		return answer;
	}

}
