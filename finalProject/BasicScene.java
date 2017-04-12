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

public class BasicScene {
	public static Scene basicScene(Stage primaryStage) {
		// -----------------------------------------------
		// Labels
		HBox l_sceneTitle = new HBox(new Label("Basic Arithmetic"));
		l_sceneTitle.setAlignment(Pos.CENTER);

		HBox l_addText = new HBox(new Label("Add two matrices"));
		l_addText.setAlignment(Pos.CENTER);

		HBox l_addResult = new HBox(new Label("Sum of your matrices:"));
		l_addResult.setAlignment(Pos.CENTER);

		HBox l_mulText = new HBox(new Label("Multiply two matrices"));
		l_mulText.setAlignment(Pos.CENTER);

		HBox l_mulResult = new HBox(new Label("Product of your matrices:"));
		l_mulResult.setAlignment(Pos.CENTER);

		// -----------------------------------------------
		// TextFields

		HBox box_tf_Add1 = new HBox();
		box_tf_Add1.setSpacing(10);
		box_tf_Add1.setAlignment(Pos.CENTER);

		TextField tf_Add1 = new TextField();
		box_tf_Add1.getChildren().add(tf_Add1);
		// ---
		HBox box_tf_Add2 = new HBox();
		box_tf_Add2.setSpacing(10);
		box_tf_Add2.setAlignment(Pos.CENTER);

		TextField tf_Add2 = new TextField();
		box_tf_Add2.getChildren().add(tf_Add2);
		// ----

		HBox box_tf_Mul1 = new HBox();
		box_tf_Mul1.setSpacing(10);
		box_tf_Mul1.setAlignment(Pos.CENTER);

		TextField tf_Mul1 = new TextField();
		box_tf_Mul1.getChildren().add(tf_Mul1);
		// ---
		HBox box_tf_Mul2 = new HBox();
		box_tf_Mul2.setSpacing(10);
		box_tf_Mul2.setAlignment(Pos.CENTER);

		TextField tf_Mul2 = new TextField();
		box_tf_Mul2.getChildren().add(tf_Mul2);
		// ----
		// -----------------------------------------------
		// Output Labels
		HBox box_op_Add = new HBox(new Label());
		box_op_Add.setSpacing(10);
		box_op_Add.setAlignment(Pos.CENTER);
		// ---
		HBox box_op_Mul = new HBox(new Label());
		box_op_Mul.setSpacing(10);
		box_op_Mul.setAlignment(Pos.CENTER);
		// -----------------------------------------------
		// Buttons
		HBox homeBt = new HBox();
		homeBt.setSpacing(10);
		homeBt.setAlignment(Pos.CENTER);

		Button btHome = new Button("Home");
		// ---
		HBox addBt = new HBox();
		addBt.setSpacing(10);
		addBt.setAlignment(Pos.CENTER);

		Button btAdd = new Button("Add");
		// ---
		HBox mulBt = new HBox();
		mulBt.setSpacing(10);
		mulBt.setAlignment(Pos.CENTER);

		Button btMul = new Button("Multiply");
		// ---
		// Button .setOnAction -----------------------
		btHome.setOnAction(e -> {
			primaryStage.setScene(MainScene.mainScene(primaryStage));
		});
		btAdd.setOnAction(e -> {
			String input1 = tf_Add1.getText();
			String input2 = tf_Add2.getText();
			String sumString;
			try {
				Matrix m1 = Matrix.parseUserInputToMatrix(input1);
				Matrix m2 = Matrix.parseUserInputToMatrix(input2);

				Matrix sum = Matrix.add(m1, m2);
				sumString = sum.toString();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				sumString = "Error";
			}

			box_op_Add.getChildren().clear();
			Label sumLabel = new Label(sumString);
			box_op_Add.getChildren().add(sumLabel);
		});
		btMul.setOnAction(e -> {
			String input1 = tf_Mul1.getText();
			String input2 = tf_Mul2.getText();
			String productString;
			try {
				Matrix m1 = Matrix.parseUserInputToMatrix(input1);
				Matrix m2 = Matrix.parseUserInputToMatrix(input2);

				Matrix product = Matrix.multiply(m1, m2);
				productString = product.toString();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				productString = "Error";
			}

			box_op_Mul.getChildren().clear();
			Label productLabel = new Label(productString);
			box_op_Mul.getChildren().add(productLabel);
		});
		// Button box getChildren().add()
		homeBt.getChildren().add(btHome);
		addBt.getChildren().add(btAdd);
		mulBt.getChildren().add(btMul);
		// -----------------------------------------------

		Group root = new Group();

		GridPane gp = new GridPane();
		gp.getColumnConstraints().add(new ColumnConstraints(300));
		gp.getColumnConstraints().add(new ColumnConstraints(200));
		gp.getColumnConstraints().add(new ColumnConstraints(300));
		gp.setHgap(15);
		gp.setVgap(10);

		// Row 1
		GridPane.setConstraints(btHome, 0, 0);
		GridPane.setConstraints(l_sceneTitle, 1, 0);

		// Row 2
		GridPane.setConstraints(l_addText, 0, 1);
		GridPane.setConstraints(l_addResult, 2, 1);
		// Row 3
		GridPane.setConstraints(tf_Add1, 0, 2);
		GridPane.setConstraints(addBt, 1, 2);
		GridPane.setConstraints(box_op_Add, 2, 2);

		// Row 4
		GridPane.setConstraints(tf_Add2, 0, 3);

		// Row 2
		GridPane.setConstraints(l_mulText, 0, 4);
		GridPane.setConstraints(l_mulResult, 2, 4);
		// Row 3
		GridPane.setConstraints(tf_Mul1, 0, 5);
		GridPane.setConstraints(mulBt, 1, 5);
		GridPane.setConstraints(box_op_Mul, 2, 5);

		// Row 4
		GridPane.setConstraints(tf_Mul2, 0, 6);

		// GridPane add Children
		gp.getChildren().addAll(btHome, l_sceneTitle, l_addText, l_addResult, tf_Add1, addBt, box_op_Add, tf_Add2,
				l_mulText, l_mulResult, tf_Mul1, mulBt, box_op_Mul, tf_Mul2);

		root.getChildren().add(gp);

		// ------------- //
		return new Scene(root);
	}
}
