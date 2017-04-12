package finalProject;

import java.io.IOException;

import finalProject.Main_GUI;
import javafx.fxml.FXML;

public class MainItemsControl {

	private Main_GUI main;

	// control button to selection page
	@FXML
	private void MainEnterBt() throws IOException {

		main.showSelectionPage(); // #1

	}

	// @FXML
	// private void MainBackBt() throws IOException{
	//
	// main.showHomePage();
	//
	// }
}
