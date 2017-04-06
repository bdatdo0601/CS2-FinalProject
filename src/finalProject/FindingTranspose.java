package finalProject;
import java.util.Scanner;

public class FindingTranspose 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("Enter number of rows and columns of matrix: "); 
		int row = scan.nextInt();
		int column = scan.nextInt(); 
		
		int [][] matrix = new int [row][column];
		
		System.out.println("Enter in elements in the matrix: "); 
		for(int r = 0; r<matrix.length; r++)
		{
			for(int c = 0; c<matrix[0].length; c++)
			{
				matrix[r][c] = scan.nextInt();
			}
		}
		
		System.out.println("Matrix before transpose: "); 
		for(int r = 0; r<matrix.length; r++)
		{
			for(int c = 0; c<matrix[0].length; c++)
			{
				System.out.print(matrix[r][c] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println("Matrix after transpose: "); 
		
		transpose(matrix); 
		
		scan.close();
		

	}
	
	public static void transpose(int[][] m)
	{
		//just flip order 
		
		for(int c = 0; c < m[0].length; c++)
		{
			for(int r = 0; r < m.length; r++)
			{
				System.out.print(m[r][c] + " ");
			}
			
			System.out.println();
		}
	}

}
