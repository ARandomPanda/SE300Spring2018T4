import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MasterCourseListWindow extends Application {

    private static MasterCourseList masterCourseList = MasterCourseList.get();

    private static Stage stage = null;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        initWindow();
        stage.show();
    }

    public void startAsChild(Stage parentStage) {

    }

    private void initWindow() {
        initStage();
        initScene();
    }

    private static void initStage() {
        if (stage == null) {
            throw new NullPointerException();
        }

        stage.setTitle("Master Course List");
        // set size?
    }

    private static void initScene() {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 800);

        ListView<BaseCourse> courseListView = new ListView<>(masterCourseList.getCourseList());
        borderPane.setCenter(courseListView);


        MenuBar menuBar = createMenu();
        borderPane.setTop(menuBar);
        stage.setScene(scene);
    }

    private static MenuBar createMenu() {
        MenuItem create = new MenuItem("Create");
        create.setOnAction(new MasterCourseListController.CreateCourseWindow());
        MenuItem edit = new MenuItem("Edit");
        MenuItem delete = new MenuItem("Delete");

        Menu courseMenu = new Menu("Course");
        courseMenu.getItems().addAll(create);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(courseMenu);

        return menuBar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
