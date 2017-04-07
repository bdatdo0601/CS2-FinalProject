package finalProject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		primaryStage.setTitle("Matrix Magicians");
		primaryStage.setScene(MainScene.mainScene(primaryStage));
		primaryStage.setHeight(400);
		primaryStage.show();
	}
		
	public static void main(String[] args) throws Exception {
		
		Application.launch(args);
	}

}
