
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	// Instantiates the main window for the program 
	private Stage primaryStage = null;
	private Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
	private PersonalPlan p;
	private MasterCourseList m = MasterCourseList.get();

	//TODO remove, for testing purposes
	private void initPlan()
	{
		
		p = new PersonalPlan();
		BaseCourse[] b = new BaseCourse[5];
		b[0] = new BaseCourse("EGR 101", "EGR", 3, null, null);
		b[1] = new BaseCourse("UNIV 101", "College Success", 3, null, null);
		b[2] = new BaseCourse("SE 300", "Software Engineering Practices", 3, null, null);
		b[3] = new BaseCourse("EGR 101", "EGR", 3, null, null);
		b[4] = new BaseCourse("EGR 101", "EGR", 3, null, null);
		
		int count = 0;
		
		for (int i = 0; i < 6; i++)
		{
			Semester s = new Semester();
			
			for (int k = 0; k<5; k++)
			{
				s.addCourse(m.getCourseList().get(count));
				count ++;
			}
			p.addSemester(s);
		}
	}
	
	// Standard start program required to use JavaFX
	public void start(Stage stage)
	{
		initPlan();
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
		
		for (int i = 0; i < p.getSemesters().size(); i++)
		{
			ListView<String> semesterPane = new ListView<String>();
			
			Semester sTemp = p.getSemesters().get(i);
			
			ObservableList<String> test = setUpCourseList(sTemp);
			
			semesterPane.setItems(test);

			semesterGrid.add(semesterPane, i+1, 0);
		}

		semesterGrid.prefHeightProperty().bind(primaryStage.heightProperty().multiply(.6666));
		semesterGrid.prefWidthProperty().bind(primaryStage.widthProperty());
		
		return semesterGrid;
	}
	
	private ObservableList<String> setUpCourseList(Semester activeSemester)
	{
		ObservableList<String> listOfCourses = FXCollections.observableArrayList();
		
		for (int k = 0; k < activeSemester.getCourses().size(); k ++)
		{
			BaseCourse activeCourse = activeSemester.getCourses().get(k);
			listOfCourses.add(activeCourse.getID() + " " + activeCourse.getName());	
		}
		
		return listOfCourses;
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
	
	public static void main(String[] args)
	{
		launch();
	}
}
