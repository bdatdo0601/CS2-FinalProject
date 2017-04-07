package finalProject;

import java.util.Vector; //using preset Vector class
import java.util.Scanner;

public class Vectors 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		//Using Preset Vector Class
		Vector<Double> v1 = new Vector<Double>();
		Vector<Double> v2 = new Vector<Double>(); 
		Vector<Double> v3 = new Vector<Double>();
		
		System.out.println("Enter in values for Vector 1 (x, y, z) : ");
		populate(v1);
		printVector(v1);
		
		System.out.println();
		System.out.println("Enter in values for Vector 2 (x,y,z)");
		populate(v2);
		printVector(v2);
		
		System.out.println("Adding the 2 vectors: ");
		
		v3 = add(v1, v2);
		printVector(v3);
		
		System.out.println("Subtracting the 2 Vectors"); 
		v3.clear();
		v3 = subtract(v1,v2);
		printVector(v3);
		
		System.out.println("Multiplyingthe 2 Vectors"); 
		v3.clear();
		v3 = multiply(v1,v2);
		
	}
	
	public static Vector<Double> add (Vector<Double> v, Vector<Double> v2)
	{
		Vector<Double> vOut = new Vector<Double>();
		
		for(int i = 0; i<v.size(); i++)
		{
			vOut.add((v.get(i))+(v2.get(i)));
		}
		
		return vOut;
	}
	
	public static Vector<Double> subtract (Vector<Double> v, Vector<Double> v2)
	{
		Vector<Double> vOut = new Vector<Double>();
		
		for(int i = 0; i<v.size(); i++)
		{
			vOut.add((v.get(i))-(v2.get(i)));
		}
		
		return vOut;
	}
	
	public static Vector<Double> multiply (Vector<Double> v, Vector<Double> v2)
	{
		Vector<Double> vOut = new Vector<Double>();
		
		for(int i = 0; i<v.size(); i++)
		{
			vOut.add((v.get(i))*(v2.get(i)));
		}
		
		return vOut;
	}
	
	public static Vector<Double> populate(Vector<Double> v)
	{
		Scanner scan = new Scanner(System.in);
		
		//To catch errors
		try
		{
			for(int i = 0; i<3; i++)
			{
				v.add(scan.nextDouble());
				
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Error: Must Enter A Number");
			v.add(scan.nextDouble());
		}
		
		return v;
	}
	
	public static void printVector(Vector<Double> v )
	{
		System.out.print("<");
		for(int i = 0; i<v.size(); i++)
		{
			if(i==v.size()-1)
			{
				System.out.print(v.get(i));
			}
			else
			{
				System.out.print(v.get(i)+ ",");
			}
		}
		System.out.print(">");
	}

}
