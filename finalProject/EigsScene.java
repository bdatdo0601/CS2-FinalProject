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

public class EigsScene {
static Matrix userMatrix;
	
	public static Scene eigsScene(Stage primaryStage) {
		
	// -----------------------------------------------
	// Labels
		HBox l_sceneTitle = new HBox(new Label("Eigen Functions\nWorks best with 2x2 & 3x3 matrices\nMake sure to parse first."));
		l_sceneTitle.setAlignment(Pos.CENTER);
		
		HBox l_instruction = new HBox(new Label("Enter matrix: "));
		l_instruction.setAlignment(Pos.CENTER);
		
		HBox l_result = new HBox(new Label("Parsed matrix: "));
		l_result.setAlignment(Pos.CENTER);
		
		HBox l_eigValues = new HBox(new Label("Eigen Values: "));
		l_eigValues.setAlignment(Pos.CENTER);
		
		HBox l_eigVectors = new HBox(new Label("Eigen Vectors: "));
		l_eigVectors.setAlignment(Pos.CENTER);
		
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
		HBox eigValOut = new HBox(new Label());
		eigValOut.setSpacing(10);
		eigValOut.setAlignment(Pos.CENTER);
		// ---
		HBox eigVecOut = new HBox(new Label());
		eigVecOut.setSpacing(10);
		eigVecOut.setAlignment(Pos.CENTER);
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
		HBox eigValBt = new HBox();
		eigValBt.setSpacing(10);
		eigValBt.setAlignment(Pos.CENTER);
		
		Button btEigVal = new Button("Eigen Values");
		// ---
		HBox eigVecBt = new HBox();
		eigVecBt.setSpacing(10);
		eigVecBt.setAlignment(Pos.CENTER);
		
		Button btEigVec = new Button("Eigen Vectors");
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
		btEigVal.setOnAction(e -> {
			double[] eigVals = Matrix.getEigenValues(userMatrix.getMatrix());
			StringBuffer s = new StringBuffer();
			for (int i = 0; i < eigVals.length; i++) {
				s.append(eigVals[i] + " ");
			}
			String str = s.toString();
			eigValOut.getChildren().clear();
			eigValOut.getChildren().add(new Label(str));
		});
		btEigVec.setOnAction(e -> {
			double[] eigVals = Matrix.getEigenValues(userMatrix.getMatrix());
			StringBuffer s = new StringBuffer();
			for (int i = 0; i < eigVals.length; i++) {
				s.append(Matrix.getEigenVectors(userMatrix.getMatrix(), i) + "\n");
			}
			
			String str = s.toString();
			eigVecOut.getChildren().clear();
			eigVecOut.getChildren().add(new Label(str));
		});
		// Button box getChildren().add()
		homeBt.getChildren().add(btHome);
		parseBt.getChildren().add(btParse);
		eigValBt.getChildren().add(btEigVal);
		eigVecBt.getChildren().add(btEigVec);
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
		GridPane.setConstraints(eigValBt, 0, 3);
		GridPane.setConstraints(eigVecBt, 1, 3);
		GridPane.setConstraints(l_eigVectors, 2, 3);
		//Row 5
		GridPane.setConstraints(l_eigValues, 0, 4);
		GridPane.setConstraints(eigVecOut, 2, 4);
		//Row 6
		GridPane.setConstraints(eigValOut, 0, 5);
		
		// GridPane add Children
		gp.getChildren().addAll(btHome, l_sceneTitle,
				l_instruction, l_result,
				inputBox, parseBt, parseOut,
				l_eigValues, l_eigVectors,
				eigValBt, eigVecBt, eigVecOut,
				eigValOut);
		
		root.getChildren().add(gp);
		
		// ------------- //
		return new Scene(root);
	}
}
