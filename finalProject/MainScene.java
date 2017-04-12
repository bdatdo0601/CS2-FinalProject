package finalProject;

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

public class MainScene {
	public static Scene mainScene(Stage primaryStage) {
		// -----------------------------------------------
		// Labels
		HBox l_sceneTitle = new HBox(new Label("Matrix Magicians"));
		l_sceneTitle.setAlignment(Pos.CENTER);

		HBox l_parseExample = new HBox(new Label("User Input Parser\nExample: [ 1, 2, 3; 4, 5, 6; 7, 8, 9 ]"));
		l_parseExample.setAlignment(Pos.CENTER);

		// -----------------------------------------------
		// TextFields
		HBox parseBox = new HBox();
		parseBox.setSpacing(10);
		parseBox.setAlignment(Pos.CENTER);

		TextField parseInput = new TextField();

		parseBox.getChildren().add(parseInput);
		// -----------------------------------------------
		// Output Labels
		HBox parseOut = new HBox();
		parseOut.setSpacing(10);
		parseOut.setAlignment(Pos.CENTER);

		Label output = new Label();

		parseOut.getChildren().add(output);
		// -----------------------------------------------
		// Buttons
		HBox parseBt = new HBox();
		parseBt.setSpacing(10);
		parseBt.setAlignment(Pos.CENTER);

		Button btParse = new Button("Parse");
		// ---
		HBox basicArithmeticBt = new HBox();
		basicArithmeticBt.setSpacing(10);
		basicArithmeticBt.setAlignment(Pos.CENTER);

		Button btBasicArithmetic = new Button("Basic Arithmetic");
		// ---
		HBox advancedFunctionsBt = new HBox();
		advancedFunctionsBt.setSpacing(10);
		advancedFunctionsBt.setAlignment(Pos.CENTER);

		Button btAdvancedFunctions = new Button("Advanced Functions");
		// ---
		HBox eigsBt = new HBox();
		eigsBt.setSpacing(10);
		eigsBt.setAlignment(Pos.CENTER);

		Button btEigs = new Button("Eigen Functions");

		// Button .setOnAction -----------------------
		btParse.setOnAction(e -> {
			String input = parseInput.getText();

			Matrix userInput;
			String userMatrixString;
			try {
				userInput = Matrix.parseUserInputToMatrix(input);
				userMatrixString = userInput.toString();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				userInput = new Matrix();
				userMatrixString = "Error";
			}

			parseOut.getChildren().clear();
			Label newLabel = new Label(userMatrixString);
			parseOut.getChildren().add(newLabel);
		});

		btBasicArithmetic.setOnAction(e -> {
			primaryStage.setScene(BasicScene.basicScene(primaryStage));
		});
		btAdvancedFunctions.setOnAction(e -> {
			primaryStage.setScene(AdvancedScene.advancedScene(primaryStage));
		});
		btEigs.setOnAction(e -> {
			primaryStage.setScene(EigsScene.eigsScene(primaryStage));
		});
		// Button box getChildren().add()
		parseBt.getChildren().add(btParse);
		basicArithmeticBt.getChildren().add(btBasicArithmetic);
		advancedFunctionsBt.getChildren().add(btAdvancedFunctions);
		eigsBt.getChildren().add(btEigs);
		// -----------------------------------------------

		Group root = new Group();

		GridPane gp = new GridPane();
		gp.getColumnConstraints().add(new ColumnConstraints(300));
		gp.getColumnConstraints().add(new ColumnConstraints(200));
		gp.getColumnConstraints().add(new ColumnConstraints(300));
		gp.setHgap(15);
		gp.setVgap(10);
		// Row 1
		GridPane.setConstraints(l_sceneTitle, 1, 0);

		// Row 2
		GridPane.setConstraints(l_parseExample, 0, 1);

		// Row 3
		GridPane.setConstraints(parseBox, 0, 2);
		GridPane.setConstraints(parseBt, 1, 2);
		GridPane.setConstraints(parseOut, 2, 2);

		// Row 4
		GridPane.setConstraints(basicArithmeticBt, 0, 3);
		GridPane.setConstraints(advancedFunctionsBt, 1, 3);
		GridPane.setConstraints(eigsBt, 2, 3);

		// GridPane add Children
		gp.getChildren().addAll(l_sceneTitle, l_parseExample, parseBox, parseBt, parseOut, basicArithmeticBt,
				advancedFunctionsBt, eigsBt);

		root.getChildren().add(gp);

		// ------------- //
		return new Scene(root);
	}
}
