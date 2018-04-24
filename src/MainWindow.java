/**
 * @author Adam Babbit
 * @date 04/02/2018
 * 
 * @version 3.2
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
	private Stage primaryStage;
	private Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
	private AcademicPlan academicPlan;
	private MasterCourseList m = MasterCourseList.get();
	
	// Standard start program required to use JavaFX
	public void start(Stage stage)
	{
		academicPlan = new AcademicPlan();
		//academicPlan.getPersonalPlan().getSemesters().addListener((ListChangeListener<Semester>) e -> System.out.println("Chage Made"));
		academicPlan.getPersonalPlan().addSemester(new Semester(Term.FALL, 2018));
		academicPlan.getPersonalPlan().getSemesterList().get(0).addCourse((new Course(new BaseCourse(DepartmentID.EGR, 101, "Intro to engineering", 2 , null, null)))
				);
		
		primaryStage = stage;
		
		primaryStage.setTitle("Degree Plan");
		
		// Setting the size of the window to the size of the screen, maximizing the window.
		primaryStage.setX(screenSize.getMinX());
		primaryStage.setY(screenSize.getMinY());
		primaryStage.setHeight(screenSize.getHeight());
		primaryStage.setWidth(screenSize.getWidth());

		//Limiting the minimum size of the window as to not affect the UI display
		primaryStage.setMinHeight(300);
		primaryStage.setMinWidth(500);
		
		//Creating all the notes 
		primaryStage.setScene(setupScene());
		
		primaryStage.show();
		
	}
	
	/**
	 * Sets up the first scene of the program including the Semesters, Classes, Class Pool, and Toolbars
	 * 
	 * @return scene		The Scene in which the other scenes are stored, This should be added directly to the Stage
	 */
	
	private Scene setupScene()
	{
		BorderPane highestPane = new BorderPane(); // Highest level container for the window
		BorderPane topBorderPane = new BorderPane(); // placed in the tap border section of the highestPane
		BorderPane listViewPanes = new BorderPane();
		Scene scene = new Scene(highestPane);
		ListView<Semester> semesterGrid = setUpSemesterPane();
		ListView<BaseCourse> list = showCoursePool(); // the listview of all the courses
		
		// forcing the course pool to be right above the list of semesters
		BorderPane.setAlignment(list,Pos.BOTTOM_RIGHT);
		
		academicPlan.getPersonalPlan().getSemesterList().addListener((ListChangeListener<Semester>) e -> System.out.println("Change Made"));
		listViewPanes.setMaxHeight(screenSize.getHeight()/3);
		
		listViewPanes.setTop(semesterGrid);
		listViewPanes.setCenter(setUpCourseList());
		topBorderPane.setTop(makeMenu());
		highestPane.setRight(list);
		highestPane.setTop(topBorderPane);
		highestPane.setBottom(listViewPanes);
		
		return scene;
	}
	
	private ListView<BaseCourse> showCoursePool()
	{
		ListView<BaseCourse> coursePool = new ListView<BaseCourse>();
		
		coursePool.setMaxHeight(screenSize.getHeight() * 0.15);
		coursePool.setPrefWidth(screenSize.getWidth() * .5);
		
		coursePool.setOrientation(Orientation.HORIZONTAL);
		
		coursePool.setCellFactory(new Callback<ListView<BaseCourse>, ListCell<BaseCourse>>() {
			
			public ListCell<BaseCourse> call(ListView<BaseCourse> param){
				Tooltip tooltip = new Tooltip();
				ListCell<BaseCourse> cell = new ListCell<BaseCourse>() {
						public void updateItem(BaseCourse item, boolean empty){
							super.updateItem(item, empty);
							if (item != null){
								setText(item.toStringDetails());
								tooltip.setText(item.toString());
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
	
	private ListView<Semester> setUpSemesterPane()
	{
		PersonalPlan p = academicPlan.getPersonalPlan();
		/*GridPane semesterGrid = new GridPane();
		
		for (int i = 0; i < p.getSemesters().size(); i++)
		{
			ListView<BaseCourse> semesterPane = new ListView<BaseCourse>();
			semesterPane.setOrientation(Orientation.HORIZONTAL);
			Semester sTemp = p.getSemesters().get(i);
			ObservableList<BaseCourse> test = setUpCourseList(sTemp);
			
			semesterPane.setItems(test);
			semesterGrid.add(semesterPane, i+1, 0);
		}

		semesterGrid.prefHeightProperty().bind(primaryStage.heightProperty().multiply(.6666));
		semesterGrid.prefWidthProperty().bind(primaryStage.widthProperty());*/
		
		ListView<Semester> l = new ListView<Semester>(p.getSemesters());
		l.setOrientation(Orientation.HORIZONTAL);
		
		return l;
	}
	
	private GridPane setUpCourseList()
	{
		PersonalPlan activePlan = academicPlan.getPersonalPlan();
		GridPane panel = new GridPane();
		ListView<BaseCourse>	listOfCourses = new ListView<BaseCourse>();
		
		for (int i = 0; i<activePlan.getSemesters().size(); i++)
		{
			listOfCourses.setItems(setUpCourseList(activePlan.getSemesters().get(i)));
			panel.add(listOfCourses, i, 0);
		}
		
		return panel;
	}
	
	private ObservableList<BaseCourse> setUpCourseList(Semester activeSemester)
	{
		ObservableList<BaseCourse> listOfCourses = FXCollections.observableArrayList();
		
		//listOfCourses.add(activeSemester.getTerm().toString() + " " + activeSemester.getYear());
		
		for (int k = 0; k < activeSemester.getCourses().size(); k ++)
		{	
			Course activeCourse = activeSemester.getCourses().get(k);
			listOfCourses.add(activeCourse.getBaseCourse());	
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
		MenuBar toolBar = new ApplicationMenu(academicPlan).getMenuBar();
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
