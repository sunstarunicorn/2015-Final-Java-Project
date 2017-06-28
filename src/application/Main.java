// Name: Katelyn Peterson
// Class: CIS 2571-001 Fall 2015
// Instructor: Mohammad Morovati
// Date: Dec. 9th, 2015
// Prologue:  This class starts the Java application for ordering at a restaurant.

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

/**
 * <h1> Main </h1> 
 * The Main class starts the Java application for orders at Last Chance Diner.
 * 
 * @author Katelyn Peterson
 * @version 1.0
 * @since 12-9-2015 
 *
 */

public class Main extends Application 
{
	// Start Override
	// Function: public void start(Stage primaryStage) throws IOException
	// Parameters:  primaryStage - window for the application
	// Returns:		 zero
					
	/**
	  * This is the start method which loads accounts.fxml and sets up the application window.
	  * @param primaryStage  This is the window for the application.
	  */
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Order.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Last Chance Diner");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	// Function: public static void main (String[] args)
	// Parameters:  none - main
	// Returns:		 zero - main
					
	/**
	  * This is the main method which launches the application.
	  * @param args Unused.
	  */
	public static void main(String[] args) 
	{
		launch(args);
	}
}
