package finalProject;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] matrixA = {{1, 2}, {3, 4}};
		
		Inverse inverseA = new Inverse(matrixA);
		
		System.out.println(inverseA.toString());
	}

}
