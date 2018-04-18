import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ApplicationMenuCourse {

    private static Stage stage;
    private static GridPane grid;
    private static Scene scene;
    private static javafx.scene.control.Label labelMajor, labelYear, labelMinor;
    private static javafx.scene.control.TextField fieldMajor, fieldYear, fieldMinor;
    private static javafx.scene.control.Button buttonMajor, buttonMinor, buttonClose;

    public static void addCourse() {
        MasterCourseWindowDialog.init();
        MasterCourseWindowDialog.show();
    }

    public static void addMajor() {
        grid = new GridPane();

        labelMajor = new javafx.scene.control.Label("Major");
        fieldMajor = new javafx.scene.control.TextField();
        labelYear = new javafx.scene.control.Label("Year ");
        fieldYear = new javafx.scene.control.TextField();
        buttonMajor = new Button("Add Major");
        buttonClose = new Button("Close");

        grid.add(labelMajor, 0, 0);
        grid.add(fieldMajor, 1, 0);
        grid.add(labelYear, 0, 1);
        grid.add(fieldYear, 1, 1);
        grid.add(buttonMajor, 0, 2);
        grid.add(buttonClose, 1, 2);

        stage = new Stage();
        scene = new Scene(grid, 250, 100);
        stage.setTitle("Add Major");
        stage.setScene(scene);
        stage.show();

        buttonMajor.setOnAction((event) -> {

        });

        buttonClose.setOnAction((event) -> {
            stage.close();
        });


    }

    public static void addMinor() {
        grid = new GridPane();

        labelMinor = new javafx.scene.control.Label("Minor");
        fieldMinor = new javafx.scene.control.TextField();
        buttonMinor = new Button("Add Minor");
        buttonClose = new Button("Close");
        grid.add(labelMinor, 0, 0);
        grid.add(fieldMinor, 1, 0);
        grid.add(buttonMinor, 0, 2);
        grid.add(buttonClose, 1, 2);

        scene = new Scene(grid, 250, 100);
        stage = new Stage();
        stage.setTitle("Add Minor");
        stage.setScene(scene);
        stage.show();

        buttonMinor.setOnAction((event) -> {

        });

        buttonClose.setOnAction((event) -> {
            stage.close();
        });

    }

    public static void removeCourse() {

    }

    public static void removeMajor() {


    }

    public static void removeMinor() {
    }
}
