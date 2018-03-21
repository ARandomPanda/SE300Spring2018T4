
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
		
		primaryStage.setTitle("Curriculum Map");
		
		primaryStage.setX(screenSize.getMinX());
		primaryStage.setY(screenSize.getMinY());
		primaryStage.setHeight(screenSize.getHeight());
		primaryStage.setWidth(screenSize.getWidth());
		primaryStage.setMinHeight(300);
		primaryStage.setMinWidth(500);
		primaryStage.setScene(setupScene());
		
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
		Scene scene = new Scene(highestPane);
		
		topBorderPane.setTop(makeMenu());
		highestPane.setTop(topBorderPane);
		highestPane.setBottom(setUpSemesterPane());
		
		return scene;
	}
	
	private GridPane setUpSemesterPane()
	{
		GridPane semesterGrid = new GridPane();
		for (int i = 0; i < 8; i++)
		{
			Pane semesterPane = new Pane();
			Label l = new Label("This is a Semester");
			
			semesterPane.prefWidthProperty().bind(primaryStage.widthProperty().multiply(.3333));
		
			semesterPane.getChildren().add(l);
			semesterGrid.add(semesterPane, i+1, 0);
		}
		
		// TODO Outdated code, need to be removed on final version
		
		/*Pane p1 = new Pane();
		Pane p2 = new Pane();
		Pane p3 = new Pane();
		
		p1.prefWidthProperty().bind(primaryStage.widthProperty().multiply(.3333));
		p2.prefWidthProperty().bind(primaryStage.widthProperty().multiply(.3333));
		p3.prefWidthProperty().bind(primaryStage.widthProperty().multiply(.3333));
		
		p1.setStyle("-fx-border-color: black");
		p2.setStyle("-fx-border-color: red");
		p3.setStyle("-fx-border-color: blue");
		
		semesterGrid.add(p1, 1, 0);
		semesterGrid.add(p2, 2, 0);
		semesterGrid.add(p3, 3, 0);*/

		semesterGrid.prefHeightProperty().bind(primaryStage.heightProperty().multiply(.6666));
		semesterGrid.prefWidthProperty().bind(primaryStage.widthProperty());
		
		return semesterGrid;
	}
	
	/**
	 * Creates the frame for the new menu
	 * 
	 * @return toolbar	The menu bar to be added in the window.
	 */
	private MenuBar makeMenu()
	{
		MenuBar toolBar = new ApplicationMenu().getMenuBar();
		MenuItem newCourse = new MenuItem("Display Master Course List");
		Menu toAdd = new Menu("To Open List");
		
		toAdd.getItems().add(newCourse);
		
		newCourse.setOnAction(e -> {
			MasterCourseListWindow.startAsChild(primaryStage);});
		
		toolBar.getMenus().add(toAdd);
		
		return toolBar;
	}

}
