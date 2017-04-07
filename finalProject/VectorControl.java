package finalProject;

import java.io.IOException;

import javafx.fxml.FXML;

public class VectorControl {

	private Main_GUI main;
	
	@FXML
	private void Vector2SelectionPage() throws IOException{
		
		System.out.println("Vector2SelectionPage() BT clicked");
		
		main.VectorBackToSelectionPage();
		
	}
	
	
	
	
	
}
