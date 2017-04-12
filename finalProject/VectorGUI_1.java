package finalProject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import java.util.ArrayList;
import java.util.Vector; //using preset Vector class

import org.jzy3d.chart.AWTChart;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.javafx.JavaFXChartFactory;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

public class VectorGUI_1 extends Application {
	private static Vector<Double> vector1 = new Vector<Double>();
	private static Vector<Double> vector2 = new Vector<Double>();
	private static Vector<Double> vector3 = new Vector<Double>();
	private static StringBuffer str = new StringBuffer();

	public static void main(String[] args) {
		Application.launch(args);
	}

	private static void getVectorsIn3D(Coord3d x, Coord3d y, Coord3d z, ArrayList<Coord3d> arr) {
		arr.clear();
		arr.add(x);
		arr.add(y);
		arr.add(z);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;
		ArrayList<Coord3d> vectors = new ArrayList<Coord3d>();
		window.setTitle("Vectors");

		Button bGui = new Button("Open GUI");
		bGui.setOnAction(e -> {
			// Vector3D.main(new String[0]);
			// Jzy3d
			JavaFXChartFactory factory = new JavaFXChartFactory();
			AWTChart chart = getDemoChart(factory, "offscreen", vectors);
			ImageView imageView = factory.bindImageView(chart);

			// JavaFX
			StackPane pane = new StackPane();
			Scene scene = new Scene(pane);
			Stage sideStage = new Stage();
			sideStage.setScene(scene);
			sideStage.show();
			pane.getChildren().add(imageView);

			factory.addSceneSizeChangedListener(chart, scene);

			window.setWidth(500);
			window.setHeight(500);
		});

		// For V1
		TextField box1 = new TextField();
		box1.setText("V1");
		TextField box2 = new TextField();
		box2.setText("V1");
		TextField box3 = new TextField();
		box3.setText("V1");

		// For V2
		TextField box4 = new TextField();
		box4.setText("V2");
		TextField box5 = new TextField();
		box5.setText("V2");
		TextField box6 = new TextField();
		box6.setText("V2");

		// For Output
		TextField output = new TextField();
		output.setText("Output");

		// Buttons
		Button addButton = new Button("Add");
		Button subtractButton = new Button("Subtract");
		Button multiplyButton = new Button("Multiply");
		Button clearButton = new Button("Clear");

		addButton.setOnAction(e -> {
			vector1.clear();
			vector2.clear();
			vector3.clear();

			vector1.add(Double.valueOf(box1.getText()));
			vector1.add(Double.valueOf(box2.getText()));
			vector1.add(Double.valueOf(box3.getText()));

			vector2.add(Double.valueOf(box4.getText()));
			vector2.add(Double.valueOf(box5.getText()));
			vector2.add(Double.valueOf(box6.getText()));

			Double v3x = (Double.valueOf(box1.getText()) + (Double.valueOf(box4.getText())));
			Double v3y = (Double.valueOf(box2.getText()) + (Double.valueOf(box5.getText())));
			Double v3z = (Double.valueOf(box6.getText()) + (Double.valueOf(box3.getText())));
			vector3.add(v3x);
			vector3.add(v3y);
			vector3.add(v3z);
			Coord3d v1 = new Coord3d(Double.valueOf(box1.getText()), Double.valueOf(box2.getText()),
					Double.valueOf(box3.getText()));
			Coord3d v2 = new Coord3d(Double.valueOf(box4.getText()), Double.valueOf(box5.getText()),
					Double.valueOf(box6.getText()));

			Coord3d v3 = new Coord3d(v3x, v3y, v3z);
			getVectorsIn3D(v1, v2, v3, vectors);

			output.setText(toString(vector3));

		});

		subtractButton.setOnAction(e -> {
			vector1.clear();
			vector2.clear();
			vector3.clear();

			vector1.add(Double.valueOf(box1.getText()));
			vector1.add(Double.valueOf(box2.getText()));
			vector1.add(Double.valueOf(box3.getText()));

			vector2.add(Double.valueOf(box4.getText()));
			vector2.add(Double.valueOf(box5.getText()));
			vector2.add(Double.valueOf(box6.getText()));

			Double v3x = (Double.valueOf(box1.getText()) - (Double.valueOf(box4.getText())));
			Double v3y = (Double.valueOf(box2.getText()) - (Double.valueOf(box5.getText())));
			Double v3z = (Double.valueOf(box6.getText()) - (Double.valueOf(box3.getText())));
			vector3.add(v3x);
			vector3.add(v3y);
			vector3.add(v3z);
			Coord3d v1 = new Coord3d(Double.valueOf(box1.getText()), Double.valueOf(box2.getText()),
					Double.valueOf(box3.getText()));
			Coord3d v2 = new Coord3d(Double.valueOf(box4.getText()), Double.valueOf(box5.getText()),
					Double.valueOf(box6.getText()));

			Coord3d v3 = new Coord3d(v3x, v3y, v3z);
			getVectorsIn3D(v1, v2, v3, vectors);

			output.setText(toString(vector3));
		});

		multiplyButton.setOnAction(e -> {
			vector1.clear();
			vector2.clear();
			vector3.clear();

			vector1.add(Double.valueOf(box1.getText()));
			vector1.add(Double.valueOf(box2.getText()));
			vector1.add(Double.valueOf(box3.getText()));

			vector2.add(Double.valueOf(box4.getText()));
			vector2.add(Double.valueOf(box5.getText()));
			vector2.add(Double.valueOf(box6.getText()));

			Double v3x = (Double.valueOf(box1.getText()) * (Double.valueOf(box4.getText())));
			Double v3y = (Double.valueOf(box2.getText()) * (Double.valueOf(box5.getText())));
			Double v3z = (Double.valueOf(box6.getText()) * (Double.valueOf(box3.getText())));
			vector3.add(v3x);
			vector3.add(v3y);
			vector3.add(v3z);
			Coord3d v1 = new Coord3d(Double.valueOf(box1.getText()), Double.valueOf(box2.getText()),
					Double.valueOf(box3.getText()));
			Coord3d v2 = new Coord3d(Double.valueOf(box4.getText()), Double.valueOf(box5.getText()),
					Double.valueOf(box6.getText()));

			Coord3d v3 = new Coord3d(v3x, v3y, v3z);
			getVectorsIn3D(v1, v2, v3, vectors);
			output.setText(toString(vector3));
		});

		clearButton.setOnAction(e -> {
			box1.clear();
			box1.setText("V1");

			box2.clear();
			box2.setText("V1");

			box3.clear();
			box3.setText("V1");

			box4.clear();
			box4.setText("V2");

			box5.clear();
			box5.setText("V2");

			box6.clear();
			box6.setText("V2");

			output.clear();
			output.setText("Output");

			str.setLength(0);

		});

		VBox layout = new VBox(11);
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.getChildren().addAll(box1, box2, box3, box4, box5, box6, output, addButton, subtractButton,
				multiplyButton, clearButton, bGui);

		Scene scene1 = new Scene(layout, 500, 500);
		window.setScene(scene1);
		window.show();
	}

	private AWTChart getDemoChart(JavaFXChartFactory factory, String toolkit, ArrayList<Coord3d> coord) {
		// -------------------------------
		// Define a function to plot
		Mapper mapper = new Mapper() {
			@Override
			public double f(double x, double y) {
				return x + y;
			}
		};

		// Define range and precision for the function to plot
		Range range = new Range(-3, 3);
		int steps = 80;

		// Create the object to represent the function over the given range.
		// THIS IS WHERE U PUT IN COORDINATES TO PLOT IN GRAPH:

		final Shape surface = Builder.buildDelaunay(coord);
		surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(),
				surface.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
		surface.setFaceDisplayed(true);
		surface.setWireframeDisplayed(false);

		// -------------------------------
		// Create a chart
		Quality quality = Quality.Advanced;
		quality.setSmoothPolygon(true);
		quality.setAnimated(true);

		// let factory bind mouse and keyboard controllers to JavaFX node
		AWTChart chart = (AWTChart) factory.newChart(quality, toolkit);
		chart.getScene().getGraph().add(surface);
		return chart;
	}

	// For format purposes
	public static String toString(Vector<Double> v) {
		str.setLength(0);

		str.append("<");
		for (int i = 0; i < v.size(); i++) {
			if (i == v.size() - 1) {
				str.append(v.get(i));
			} else {
				str.append(v.get(i) + ",");
			}
		}

		str.append(">");

		return str.toString();

	}

}
