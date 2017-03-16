package finalProject;

import java.util.Scanner;

//An Huynh's Portion
public class Determinants 
{
	//Parameters: Matrix and its dimension 
    public static double determinant(double M[][],int dim)
    {
        double det = 0;
        
        if(dim == 1)
        {
            det = M[0][0];
        }
        
        else if (dim == 2)
        {
            det = M[0][0]*M[1][1] - M[1][0]*M[0][1]; //ad - bc
        }
        
        else
        {
            det = 0;
            
            for(int j1=0;j1<dim;j1++)
            {
                double[][] m = new double[dim-1][dim-1];
                //m is the minor matrix
         
                for(int i = 1; i < dim; i++) //because the first row is always expanded upon in my algorithm
                {
                    int j2=0;
                    
                    for(int j=0;j<dim;j++)
                    {
                        if(j == j1)
                            continue; //continue without processing statements below
                        
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
 

	public static void main(String[] args) 
	{
Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the number of rows: ");
        
        int row = scan.nextInt(); 
        
        System.out.println("Enter the number of cols: "); 
        
        int col = scan.nextInt(); 
        
        while(col != row)
        {
        	System.out.println("You can only find the determinant of square matrices, please double check your cols: "); 
        	col = scan.nextInt(); 
        }
 
        System.out.println("Enter the elements of the matrix");
        
        double[][] matrix = new double[row][col];
        
        int dim = row;
        
        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                matrix[r][c] = scan.nextDouble();
            }
        }
 
        System.out.println("The matrix: "); 
        
        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                System.out.print(matrix[r][c] + " ");
            }
            
            System.out.println();
        }
        
        System.out.println();
        
        System.out.println("The determinant of the Matrix is : "+ determinant(matrix, dim));
 
        scan.close();
    }

}


