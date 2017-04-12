package finalProject;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main_GUI extends Application {

	private static Stage PrimaryStage;
	private static BorderPane MainLayout;
	private static Scene scene;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.PrimaryStage = primaryStage;
		this.PrimaryStage.setTitle("FINAL_CALCULATOR");
		// showMainView();

		// shown as the first step, open the app in the first page(home page)
		FXMLLoader Loader = new FXMLLoader();

		Loader.setLocation(Main_GUI.class.getResource("view/MainView.fxml"));
		// Loader.setLocation(Main_GUI.class.getResource("selection/selectionPage.fxml"));

		MainLayout = Loader.load();
		scene = new Scene(MainLayout);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();

		Main_GUI.PrimaryStage.setResizable(false);
		// set the window to 800x600 fixed
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////// Home
	///////////////////////////////////////////////////////////////////////////////////////////////////// Page

	// shown as the first step, open the app in the first page(home page)
	// private void showMainView() throws IOException {
	//

	// FXMLLoader Loader = new FXMLLoader();
	// Loader.setLocation(Main_GUI.class.getResource("view/MainView.fxml"));
	// MainLayout = Loader.load();
	// scene = new Scene(MainLayout);
	// PrimaryStage.setScene(scene);
	// PrimaryStage.show();
	// }
	/**
	 * // allow user to click the button to press "Enter" to go to the next //
	 * selection page ###################################1
	 */
	public static void showSelectionPage() throws IOException {

		// Pane selectionPage = loader2.load();
		// MainLayout.getChildren().clear();

		MainLayout.getChildren().clear();

		FXMLLoader loader2 = new FXMLLoader();
		loader2.setLocation(Main_GUI.class.getResource("SelectionPage.fxml"));

		System.out.println("showSelectionPagge() is called"); ///////////////

		Pane pane = loader2.load();
		MainLayout.setCenter(pane);

		// Work version
		// FXMLLoader loader2 = new FXMLLoader();
		// loader2.setLocation(Main_GUI.class.getResource("MyTest.fxml"));
		// BorderPane ct = loader2.load();
		// MainLayout.setCenter(ct);

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////// Selection
	///////////////////////////////////////////////////////////////////////////////////////////////////// Page
	/**
	 * // allow user to click the "Return"(from selection page) bt to return to
	 * // homepage #####################################2
	 */
	public static void showHomePage() throws IOException {

		System.out.println("showHomePage() is called");
		FXMLLoader loader3 = new FXMLLoader();
		loader3.setLocation(Main_GUI.class.getResource("view/MainView.fxml"));
		System.out.println("MainView.fxml is opened");
		Pane pane = loader3.load();
		MainLayout.setCenter(pane);

	}

	/**
	 * // allow user to click "Matrix" bt (from selection page) to Matrix page
	 * #3 ##########################################3
	 */
	public static void ToMatrixPage() throws IOException {

		System.out.println("ToMatrixPage() is called"); ///////////////
		FXMLLoader loader4 = new FXMLLoader();
		loader4.setLocation(Main_GUI.class.getResource("MatrixPage.fxml"));
		System.out.println("MatrixPage.fxml is opened"); ///////////////
		Pane pane = loader4.load();
		MainLayout.setCenter(pane);
	}

	/**
	 * // allow user to click "Vector" bt (from selection page) to Vector page
	 * #3 ##########################################4
	 */
	public static void ToVectorPage() throws IOException {

		System.out.println("ToVectorPage() is called"); ///////////////
		FXMLLoader loader4 = new FXMLLoader();
		loader4.setLocation(Main_GUI.class.getResource("VectorPage.fxml"));
		System.out.println("VectorPage.fxml is opened"); ///////////////
		Pane pane = loader4.load();
		MainLayout.setCenter(pane);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////// Matrix
	///////////////////////////////////////////////////////////////////////////////////////////////////// Page

	/**
	 * allow user to click the "Back" (from Matrix page) to to back to selection
	 * page ####################################5
	 * 
	 **/
	public static void MatrixBackToSelectionPage() throws IOException {

		System.out.println("BackToSelectionPage() is called");
		FXMLLoader loader3 = new FXMLLoader();
		loader3.setLocation(Main_GUI.class.getResource("SelectionPage.fxml"));
		System.out.println("SelectionPage.fxml is opened");
		Pane pane = loader3.load();
		MainLayout.setCenter(pane);
	}

	/**
	 * allow user to click the "Simple" (from Matrix page) to go to
	 * Matrix-simple calculator page page ####################################
	 * 
	 **/
	public static void MatrixToMatrixSimpleCPage() throws IOException {

		System.out.println("MatrixToMatrixSimplePage() is called");
		FXMLLoader loader6 = new FXMLLoader();
		loader6.setLocation(Main_GUI.class.getResource("Matrix-simpleC.fxml"));
		// System.out.println("SelectionPage.fxml is opened");
		Pane pane = loader6.load();
		MainLayout.setCenter(pane);
	}

	/**
	 * allow user to click the "Complex" (from Matrix page) to go to
	 * Matrix-Complex calculator page page ####################################
	 * 
	 **/
	public static void MatrixToMatrixComplexCPage() throws IOException {

		System.out.println("MatrixToMatrixComplexPage() is called");
		FXMLLoader loader9 = new FXMLLoader();
		loader9.setLocation(Main_GUI.class.getResource("Matrix-complexC.fxml"));
		// System.out.println("SelectionPage.fxml is opened");
		Pane pane = loader9.load();
		MainLayout.setCenter(pane);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////// Vector
	///////////////////////////////////////////////////////////////////////////////////////////////////// Page

	/**
	 * allow user to click the "Back" (from Vector page) to to back to selection
	 * page #####################################6
	 **/

	public static void VectorBackToSelectionPage() throws IOException {

		System.out.println("BackToSelectionPage() is called");
		FXMLLoader loader5 = new FXMLLoader();
		loader5.setLocation(Main_GUI.class.getResource("SelectionPage.fxml"));
		System.out.println("SelectionPage.fxml is opened");
		Pane pane = loader5.load();
		MainLayout.setCenter(pane);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////// Matrix
	///////////////////////////////////////////////////////////////////////////////////////////////////// Simple
	///////////////////////////////////////////////////////////////////////////////////////////////////// section

	/**
	 * allow user to click the "Back" (from matrix-Simple page) to go back to
	 * Matrix page ####################################
	 * 
	 **/
	public static void MatrixSimpleCBackToMatrixPage() throws IOException {

		System.out.println("MatrixSimpleCBackToMatrixPage() is called");
		FXMLLoader loader7 = new FXMLLoader();
		loader7.setLocation(Main_GUI.class.getResource("matrixPage.fxml"));
		// System.out.println("SelectionPage.fxml is opened");
		Pane pane = loader7.load();
		MainLayout.setCenter(pane);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////// Matrix
	///////////////////////////////////////////////////////////////////////////////////////////////////// Complex
	///////////////////////////////////////////////////////////////////////////////////////////////////// section

	/**
	 * allow user to click the "Back" (from matrix-Simple page) to go back to
	 * Matrix page ####################################
	 * 
	 **/
	public static void MatrixComplexCBackToMatrixPage() throws IOException {

		System.out.println("MatrixSimpleCBackToMatrixPage() is called");
		FXMLLoader loader8 = new FXMLLoader();
		loader8.setLocation(Main_GUI.class.getResource("matrixPage.fxml"));
		// System.out.println("SelectionPage.fxml is opened");
		Pane pane = loader8.load();
		MainLayout.setCenter(pane);
	}

	public static void Main_GUI(String[] args) {
		launch(args);
	}
}
