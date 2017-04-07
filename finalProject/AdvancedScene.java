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

public class AdvancedScene {
	static Matrix userMatrix;
	
	public static Scene advancedScene(Stage primaryStage) {
		
	// -----------------------------------------------
	// Labels
		HBox l_sceneTitle = new HBox(new Label("Advanced Functions\nWorks best with nXn matrices\nMake sure to parse first."));
		l_sceneTitle.setAlignment(Pos.CENTER);
		
		HBox l_instruction = new HBox(new Label("Enter matrix: "));
		l_instruction.setAlignment(Pos.CENTER);
		
		HBox l_result = new HBox(new Label("Parsed matrix: "));
		l_result.setAlignment(Pos.CENTER);
		
		HBox l_transpose = new HBox(new Label("Transpose of matrix: "));
		l_transpose.setAlignment(Pos.CENTER);
		
		HBox l_determinant = new HBox(new Label("Determinant of matrix: "));
		l_determinant.setAlignment(Pos.CENTER);
		
		HBox l_invertible = new HBox(new Label("Matrix invertibility: "));
		l_invertible.setAlignment(Pos.CENTER);
		
	// -----------------------------------------------
	// TextFields
		HBox inputBox = new HBox();
		inputBox.setSpacing(10);
		inputBox.setAlignment(Pos.CENTER);
		
		TextField matrixInput = new TextField();
		
		inputBox.getChildren().add(matrixInput);
	// -----------------------------------------------
	// Output Labels
		HBox parseOut = new HBox(new Label());
		parseOut.setSpacing(10);
		parseOut.setAlignment(Pos.CENTER);
		// ---
		HBox transposeOut = new HBox(new Label());
		transposeOut.setSpacing(10);
		transposeOut.setAlignment(Pos.CENTER);
		// ---
		HBox determinantOut = new HBox(new Label());
		determinantOut.setSpacing(10);
		determinantOut.setAlignment(Pos.CENTER);
		// ---
		HBox invertibleOut = new HBox(new Label());
		invertibleOut.setSpacing(10);
		invertibleOut.setAlignment(Pos.CENTER);
		// ---
	// -----------------------------------------------	
	// Buttons
		HBox homeBt = new HBox();
		homeBt.setSpacing(10);
		homeBt.setAlignment(Pos.CENTER);
		
		Button btHome = new Button("Home");
		// ---
		HBox parseBt = new HBox();
		parseBt.setSpacing(10);
		parseBt.setAlignment(Pos.CENTER);
		
		Button btParse = new Button("Parse");
		// ---
		HBox transposeBt = new HBox();
		transposeBt.setSpacing(10);
		transposeBt.setAlignment(Pos.CENTER);
		
		Button btTranspose = new Button("Transpose");
		// ---
		HBox determinantBt = new HBox();
		determinantBt.setSpacing(10);
		determinantBt.setAlignment(Pos.CENTER);
		
		Button btDeterminant = new Button("Determinant");
		// ---
		HBox invertibleBt = new HBox();
		invertibleBt.setSpacing(10);
		invertibleBt.setAlignment(Pos.CENTER);
		
		Button btInvertible = new Button("Invertible");
		// ---
		// Button .setOnAction -----------------------
		btHome.setOnAction(e -> {
			primaryStage.setScene(MainScene.mainScene(primaryStage));
		});
		btParse.setOnAction(e -> {
			String input = matrixInput.getText();
			
			String userMatrixString;
			try {
				userMatrix = Matrix.parseUserInputToMatrix(input);
				userMatrixString = userMatrix.toString();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				userMatrix = new Matrix();
				userMatrixString = "Error";
			}
			
			parseOut.getChildren().clear();
			Label newLabel = new Label(userMatrixString);
			parseOut.getChildren().add(newLabel);
		});
		btTranspose.setOnAction(e -> {
			Matrix tr = new Matrix();
			try {
				tr = new Matrix(Matrix.transpose(userMatrix.getMatrix()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String trString = tr.toString();
			transposeOut.getChildren().clear();
			Label newLabel = new Label(trString);
			transposeOut.getChildren().add(newLabel);
		});
		btDeterminant.setOnAction(e -> {
			double d = -1;
			boolean wasChanged = false;
			try {
				d = Matrix.getDeterminant(userMatrix);
				wasChanged = true;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			determinantOut.getChildren().clear();
			Label newLabel;
			if (wasChanged) {
				 newLabel = new Label(Double.toString(d));
			} else {
				newLabel = new Label("Determinant could not be found.");
			}
			determinantOut.getChildren().add(newLabel);
		});
		btInvertible.setOnAction(e -> {
			boolean i = userMatrix.getHasInverse();
			String s = Boolean.toString(i);
			invertibleOut.getChildren().clear();
			invertibleOut.getChildren().add(new Label(s));
		});
		// Button box getChildren().add()
		homeBt.getChildren().add(btHome);
		parseBt.getChildren().add(btParse);
		transposeBt.getChildren().add(btTranspose);
		determinantBt.getChildren().add(btDeterminant);
		invertibleBt.getChildren().add(btInvertible);
	// -----------------------------------------------	
		Group root = new Group();
		
		GridPane gp = new GridPane();
		gp.getColumnConstraints().add(new ColumnConstraints(300));
		gp.getColumnConstraints().add(new ColumnConstraints(200));
		gp.getColumnConstraints().add(new ColumnConstraints(300));
		gp.setHgap(15);
		gp.setVgap(10);
		
		//Row 1
		GridPane.setConstraints(btHome, 0, 0);
		GridPane.setConstraints(l_sceneTitle, 1, 0);
		
		//Row 2
		GridPane.setConstraints(l_instruction, 0, 1);
		GridPane.setConstraints(l_result, 2, 1);
		//Row 3
		GridPane.setConstraints(inputBox, 0, 2);
		GridPane.setConstraints(parseBt, 1, 2);
		GridPane.setConstraints(parseOut, 2, 2);
		//Row 4
		GridPane.setConstraints(transposeBt, 0, 3);
		GridPane.setConstraints(determinantBt, 1, 3);
		GridPane.setConstraints(invertibleBt, 2, 3);
		//Row 5
		GridPane.setConstraints(l_transpose, 0, 4);
		GridPane.setConstraints(l_determinant, 1, 4);
		GridPane.setConstraints(l_invertible, 2, 4);
		//Row 6
		GridPane.setConstraints(transposeOut, 0, 5);
		GridPane.setConstraints(determinantOut, 1, 5);
		GridPane.setConstraints(invertibleOut, 2, 5);
		
		// GridPane add Children
		gp.getChildren().addAll(btHome, l_sceneTitle,
				l_instruction, l_result,
				inputBox, parseBt, parseOut,
				transposeBt, determinantBt, invertibleBt,
				l_transpose, l_determinant, l_invertible,
				transposeOut, determinantOut, invertibleOut);
		
		root.getChildren().add(gp);
		
		// ------------- //
		return new Scene(root);
	}
}
