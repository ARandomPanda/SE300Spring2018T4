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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
	private ObservableList<Semester> semesterList;

	//TODO remove, for testing purposes
	private void initPlan()
	{
		p = new PersonalPlan();
		int count = 0;
		
		for (int i = 0; i < 7; i++)
		{
			Semester s = new Semester(Term.FALL, 2018);
			
			for (int k = 0; k<5; k++)
			{
				s.addCourse(new Course(new BaseCourse(DepartmentID.EGR, 101, "Intro to Engineering", 3, null, null)));
				count ++;
			}
			
			p.addSemester(s);
		}
	}
	
	// Standard start program required to use JavaFX
	public void start(Stage stage)
	{
		academicPlan = new AcademicPlan();
		//academicPlan.getPersonalPlan().getSemesters().addListener((ListChangeListener<Semester>) e -> System.out.println("Chage Made"));
		academicPlan.getPersonalPlan().addSemester(new Semester(Term.FALL, 2018));
		
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
	
	ListView<Semester> semesterGrid;
	private Scene setupScene()
	{
		BorderPane highestPane = new BorderPane(); // Highest level container for the window
		BorderPane topBorderPane = new BorderPane(); // placed in the tap border section of the highestPane
		Scene scene = new Scene(highestPane);
		semesterGrid = setUpSemesterPane();
		ListView<BaseCourse> list = showCoursePool(); // the listview of all the courses
		
		// forcing the course pool to be right above the list of semesters
		BorderPane.setAlignment(list,Pos.BOTTOM_RIGHT);
		
		academicPlan.getPersonalPlan().getSemesters().addListener((ListChangeListener<Semester>) e -> semesterGrid = setUpSemesterPane());
		
		topBorderPane.setTop(makeMenu());
		highestPane.setRight(list);
		highestPane.setTop(topBorderPane);
		highestPane.setBottom(semesterGrid);
		
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
								setText(item.toString());
								String tipText = item.getName() + "\n" + "Credit Count: " + item.getNumCredits();
								if (item.getCoreqs().size() == 0)
								{
									tipText += "\n" + "CoReqs: None";
								}
								else
								{
									tipText += "\n" + "Co-Reqs:";
									for (int i = 0; i < item.getCoreqs().size(); i++)
									{
										 tipText += "\n" + item.getCoreqs().get(i).getID() + " | " + item.getCoreqs().get(i).getName();
								
									}
								}
								if (item.getPrereqs().size() == 0)
								{
									tipText += "\n" + "Pre-Reqs: None";
								}
								else
								{
									tipText += "\n" + "PreReqs:";
									for (int i = 0; i < item.getPrereqs().size(); i++)
									{
										 tipText += "\n" + item.getPrereqs().get(i).getID() + " | " + item.getPrereqs().get(i).getName() +"\n";
								
									}
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
	
	// to be implemented
	private static class ToolTipSetUp extends ListCell<BaseCourse>
	{
		
	}
}
