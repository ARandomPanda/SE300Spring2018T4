import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;

/**
 * @author Christopher McFall
 *
 * This window lists each course in the master course list. Any modifications the user wishes to make to the master
 * course list should be made from this window.
 *
 * This window can be opened on its own from main, or from another stage using the startAsChild(Stage) method.
 */
public class MasterCourseListWindow extends Application {

    private static MasterCourseList masterCourseList = MasterCourseList.get();

    private static Stage stage = null;
    private static TableView<BaseCourse> masterCourseTable;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        initWindow();
        stage.show();
    }

    public static void startAsChild(Stage parentStage) {
        stage = new Stage();
        stage.initOwner(parentStage);
        initWindow();
        stage.show();
    }

    private static void initWindow() {
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
        Scene scene = new Scene(borderPane, 800, 800);

        initTableView();
        borderPane.setCenter(masterCourseTable);

        MenuBar menuBar = createMenu();
        borderPane.setTop(menuBar);
        stage.setScene(scene);
    }

    private static void initTableView() {

        masterCourseTable = new TableView<>(masterCourseList.getCourseList());

        // All columns are read only because the BaseCourse class has no properties.
        // TODO find a way to make writable while keeping BaseCourse Serializable
        TableColumn<BaseCourse, String> IDcol = new TableColumn<>("Course ID");
        IDcol.setCellValueFactory(p -> {
            return new ReadOnlyObjectWrapper<>(p.getValue().getID());
        });

        TableColumn<BaseCourse, String> nameCol = new TableColumn<>("Course Name");
        nameCol.setCellValueFactory(p -> {
            return new ReadOnlyObjectWrapper<>(p.getValue().getName());
        });

        TableColumn<BaseCourse, Integer> creditsCol = new TableColumn<>("Credits");
        creditsCol.setCellValueFactory(p -> {
            return new ReadOnlyObjectWrapper<>(p.getValue().getNumCredits());
        });

        // List the prerequisite courses in the column
        TableColumn<BaseCourse, String> prereqsCol = new TableColumn<>("Prerequisites");
        prereqsCol.setCellValueFactory(p -> {
            List<BaseCourse> prereqs = p.getValue().getPrereqs();
            StringBuilder sb;
            if (prereqs.isEmpty()) {
                sb = new StringBuilder("None");
            } else {
                sb = new StringBuilder();
                for (BaseCourse c : prereqs) {
                    sb.append(c.getID());
                    sb.append(", ");
                }
                if (sb.substring(sb.length() - 2).equals(", ")) {
                    sb.delete(sb.length() - 2, sb.length() - 1);
                }
            }

            return new ReadOnlyObjectWrapper<>(sb.toString());
        });

        // List the corequisite courses in the column
        TableColumn<BaseCourse, String> coreqsCol = new TableColumn<>("Corequisites");
        coreqsCol.setCellValueFactory(p -> {
            List<BaseCourse> coreqs = p.getValue().getCoreqs();
            StringBuilder sb;
            if (coreqs.isEmpty()) {
                sb = new StringBuilder("None");
            } else {
                sb = new StringBuilder();
                for (BaseCourse c : coreqs) {
                    sb.append(c.getID());
                    sb.append(", ");
                }
                if (sb.substring(sb.length() - 2).equals(", ")) {
                    sb.delete(sb.length() - 2, sb.length() - 1);
                }
            }
            return new ReadOnlyObjectWrapper<>(sb.toString());
        });

        masterCourseTable.getColumns().setAll(IDcol, nameCol, creditsCol, prereqsCol, coreqsCol);
    }

    private static MenuBar createMenu() {
        MenuItem create = new MenuItem("Create");
        create.setOnAction(new MasterCourseListController.CreateCourseWindow());
        MenuItem edit = new MenuItem("Edit");
        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction(new MasterCourseListController.DeleteCourse(masterCourseTable.getSelectionModel()));

        Menu courseMenu = new Menu("Course");
        courseMenu.getItems().addAll(create, delete);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(courseMenu);

        return menuBar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
