package finalProject;

import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MatrixSimpleControl {

	private Main_GUI main;

	@FXML
	private void MatrixSimpleBack2matrixPage() throws IOException {

		System.out.println("MatrixSimpleBack2matrixPage() BT clicked");

		main.MatrixSimpleCBackToMatrixPage();

	}

	@FXML
	Label myMessage;

	public void ClickMe() {
		Random random = new Random();
		int myRand = random.nextInt(100);

		myMessage.setText("Random number is " + Integer.toString(myRand));
	}

}
