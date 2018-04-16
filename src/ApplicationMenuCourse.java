import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ApplicationMenuCourse {

    private static Stage stage;
    private static GridPane grid;
    private static Scene scene;
    private static javafx.scene.control.Label label1, label2;
    private static javafx.scene.control.TextField field1, field2;
    private static javafx.scene.control.Button button1, button2;

    public static void addCourse() {
    }

    public static void addMajor() {
        grid = new GridPane();

        label1 = new javafx.scene.control.Label("Major");
        field1 = new javafx.scene.control.TextField();
        label2 = new javafx.scene.control.Label("Year ");
        field2 = new javafx.scene.control.TextField();
        button1 = new Button("Add Major");
        button1 = new Button("Cancel");

        grid.add(label1, 0, 0);
        grid.add(field1, 1, 0);
        grid.add(label2, 0, 1);
        grid.add(field2, 1, 1);
        grid.add(button1, 0, 2);
        grid.add(button2, 1, 2);

        scene = new Scene(grid, 250, 100);
        stage = new Stage();
        stage.setTitle("Add Major");
        stage.setScene(scene);
        stage.show();

        button1.setOnAction((event) -> {

        });

        button2.setOnAction((event) -> {
            stage.close();
        });


    }

    public static void addMinor() {
        grid = new GridPane();

        label1 = new javafx.scene.control.Label("Minor");
        field1 = new javafx.scene.control.TextField();
        button1 = new Button("Add Minor");
        button1 = new Button("Cancel");
        grid.add(label1, 0, 0);
        grid.add(field1, 1, 0);
        grid.add(button1, 0, 2);
        grid.add(button2, 1, 2);

        scene = new Scene(grid, 250, 100);
        stage = new Stage();
        stage.setTitle("Add Minor");
        stage.setScene(scene);
        stage.show();

        button1.setOnAction((event) -> {

        });

        button2.setOnAction((event) -> {
            stage.close();
        });

    }

    public static void removeCourse() {
        stage = new Stage();
        stage.setTitle("Remove Course");
        stage.setScene(scene);
        stage.show();
    }

    public static void removeMajor() {
        stage = new Stage();
        stage.setTitle("Remove Major");
        stage.setScene(scene);
        stage.show();

    }

    public static void removeMinor() {
        stage = new Stage();
        stage.setTitle("Remove Minor");
        stage.setScene(scene);
        stage.show();
    }
}
