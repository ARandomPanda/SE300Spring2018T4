
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	// Instantiates the main window for the program 
	private Stage primaryStage = null;
	
	
	public static void main(String[] args)
	{
		launch();
	}
	
	
	// Standard start program required to use JavaFX
	public void start(Stage primaryStage)
	{
		this.primaryStage = primaryStage;

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("This is a dummy window");
		
		this.primaryStage.setScene(setupScene());
		
		this.primaryStage.show();
		
	}
	
	/**
	 * Creates the Standard first scene of the program. Displays the first Window 
	 * including the Semesters, Classes, Class pool, and toolbars
	 * 
	 * @return scene		The Scene in which the other scenes are stored, This should be added directly to the Stage
	 */
	private Scene setupScene()
	{
		BorderPane highestPane = new BorderPane();
		BorderPane topBorderPane = new BorderPane();
		
		topBorderPane.setTop(makeMenu());
		highestPane.setTop(topBorderPane);
		
		Scene scene = new Scene(highestPane, 600, 600);
		
		return scene;
	}
	
	/**
	 * Creates the frame for the new menu
	 * 
	 * @return toolbar		The menu bar to be added in the window.
	 */
	private MenuBar makeMenu()
	{
		MenuBar toolBar = new MenuBar();
		Menu dummy = new Menu("This is a Test");
		MenuItem newCourse = new MenuItem("Opens Course List");
		
		
		newCourse.setOnAction(e -> {
			MasterCourseListWindow.startAsChild(primaryStage);});
		dummy.getItems().add(newCourse);
		toolBar.getMenus().add(dummy);
		
		return toolBar;
	}

}
