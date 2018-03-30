/**
 * @author Adam Babbit
 * @date 
 * 
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;

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
		
		int count = 0;
		
		for (int i = 0; i < 7; i++)
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
		//TODO Remove Line Below
		initPlan();
		
		primaryStage = stage;
		
		primaryStage.setTitle("Degree Plan");
		
		primaryStage.setX(screenSize.getMinX());
		primaryStage.setY(screenSize.getMinY());
		primaryStage.setHeight(screenSize.getHeight());
		primaryStage.setWidth(screenSize.getWidth());
		primaryStage.setMinHeight(300);
		primaryStage.setMinWidth(500);
		primaryStage.setScene(setupScene());
		
		primaryStage.show();
		
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
		ListView<BaseCourse> list = showCoursePool();
		
		
		BorderPane.setAlignment(list,Pos.BOTTOM_RIGHT);
		
		topBorderPane.setTop(makeMenu());
		highestPane.setCenter(list);
		highestPane.setTop(topBorderPane);
		highestPane.setBottom(setUpSemesterPane());
		
		return scene;
	}
	
	private ListView<BaseCourse> showCoursePool()
	{
		ListView<BaseCourse> coursePool = new ListView<BaseCourse>();
		
		coursePool.setMaxHeight(screenSize.getHeight() * 0.15);
		coursePool.setMaxWidth(screenSize.getWidth() * .5);
		
		coursePool.setOrientation(Orientation.HORIZONTAL);
		
		coursePool.setCellFactory(new Callback<ListView<BaseCourse>, ListCell<BaseCourse>>() {
			
			
				public ListCell<BaseCourse> call(ListView<BaseCourse> param){
					Tooltip tooltip = new Tooltip();
					ListCell<BaseCourse> cell = new ListCell<BaseCourse>() {
							public void updateItem(BaseCourse item, boolean empty){
								super.updateItem(item, empty);
								if (item != null){
									setText(item.getID());
									String tipText = item.getName() + "\n" + "Credit Count: " + item.getNumCredits();
									if (item.getCoreqs().size() == 0)
									{
										tipText += "\n" + "CoReqs: None";
									}
									if (item.getPrereqs().size() == 0)
									{
										tipText += "\n" + "PreReqs: None";
									}
									else
									{
										tipText += "\n" + "PreReqs: " + item.getPrereqs().get(0).getID() + " | " + item.getPrereqs().get(0).getName();
									}
									tooltip.setText(tipText);
									setTooltip(tooltip);
								}
							}
						};
						return cell;
					}
				});
		
		
		coursePool.setItems(m.getCourseList());
		
		return coursePool;
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
		
		listOfCourses.add(activeSemester.getTerm());
		
		for (int k = 0; k < activeSemester.getCourses().size(); k ++)
		{
			BaseCourse activeCourse = activeSemester.getCourses().get(k);
			listOfCourses.add(activeCourse.getID());	
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
		Menu toAdd = new Menu("Open List");
		
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
