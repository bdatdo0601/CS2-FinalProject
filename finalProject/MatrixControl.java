package finalProject;

import java.io.IOException;

import javafx.fxml.FXML;

public class MatrixControl {

	
	private Main_GUI main;
	
	@FXML
	private void MatrixPage2SelectionPage() throws IOException{
		
		main.MatrixBackToSelectionPage();
		
	}
	
	@FXML
	private void MatrixPage2MatrixSimpleCPage() throws IOException{
		
		main.MatrixToMatrixSimpleCPage();
		
	}
	
	@FXML
	private void MatrixPage2MatrixComplexCPage() throws IOException{
		
		main.MatrixToMatrixComplexCPage();
		
	}
	
	
}
