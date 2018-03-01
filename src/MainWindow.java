
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	// Instantiates the main window for the program 
	private Stage primaryStage = null;
	private Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
	
	
	public static void main(String[] args)
	{
		launch();
	}
	
	
	// Standard start program required to use JavaFX
	public void start(Stage stage)
	{
		primaryStage = stage;
		
		primaryStage.setTitle("This is a dummy window");
		primaryStage.setScene(setupScene());
		
		primaryStage.setX(screenSize.getMaxX());
		primaryStage.setY(screenSize.getMaxY());
		primaryStage.setHeight(screenSize.getHeight());
		primaryStage.setWidth(screenSize.getWidth());
		
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
		// the Highest level pane that contains all the other panes
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
	 * @return toolbar	The menu bar to be added in the window.
	 */
	private MenuBar makeMenu()
	{
		MenuBar toolBar = new MenuBar();
		Menu dummy = new Menu("File");
		MenuItem newCourse = new MenuItem("Display Master Course List");
		
		
		newCourse.setOnAction(e -> {
			MasterCourseListWindow.startAsChild(primaryStage);});
		dummy.getItems().add(newCourse);
		toolBar.getMenus().add(dummy);
		
		return toolBar;
	}

}
