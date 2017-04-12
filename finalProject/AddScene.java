package finalProject;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class AddScene {

	public static Scene addScene() {
		Label test = new Label("Hello from AddScene");
		HBox testBox = new HBox();
		testBox.getChildren().add(test);
		return new Scene(testBox, 100, 100);
	}

}
