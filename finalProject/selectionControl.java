package finalProject;

import java.io.IOException;

import javafx.fxml.FXML;

public class selectionControl {

	private Main_GUI main;

	@FXML 
	private void ReturnBt() throws IOException {

		main.showHomePage(); // #2

	}
	
	
	@FXML
	private void ToMatrix() throws IOException{
		System.out.println("ToMatrix() BT clicked");
		
		main.ToMatrixPage();     // #3   
		
	}
	
	
	@FXML
	private void ToVector() throws IOException{
		System.out.println("ToVector() BT clicked");
		
		main.ToVectorPage(); 	// #4
		
	}
	
	

}
