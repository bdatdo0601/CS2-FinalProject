package finalProject;

import java.io.IOException;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class MatrixComplexControl {

	private Main_GUI main;
	
	@FXML
	private void MatrixComplexBack2matrixPage() throws IOException
	{
		System.out.println("MatrixSimpleBack2matrixPage() BT clicked");
		
		main.MatrixComplexCBackToMatrixPage();

	}
	

}
