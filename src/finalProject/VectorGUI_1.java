package finalProject;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VectorGUI_1 extends Application
{

	Stage window;
	Scene scene;
	Button button;
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage;
		window.setTitle("Tutorial");
		
		TextField nameInput = new TextField();
		button = new Button("Click Me");
		
		//extract data and print out in terminal 
		//button.setOnAction(e -> System.out.println(nameInput.getText()));
		
		//extract and validate data 
		button.setOnAction(e -> isInt(nameInput, nameInput.getText()));
		
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(nameInput, button); 
		
		scene = new Scene(layout, 300, 250); 
		window.setScene(scene);
		window.show();
		
	}
	
	private boolean isInt(TextField input, String message)
	{
		//Since we are validating numbers, we have to catch NumberFormatSceptions
		try
		{
			//Adding Vectors 
		}
			
		catch(NumberFormatException e)
		{
			System.out.println("Error: Must enter in doubles");
		}
		
		return false;
		
	}


}
