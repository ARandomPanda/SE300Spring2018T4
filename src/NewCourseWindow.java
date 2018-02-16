import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewCourseWindow {

    private static Stage stage = null;

    private NewCourseWindow() { }

    // Testing only
    public static void set(Stage s) {
        stage = s;
    }

    public static void init() {
        if (stage == null) stage = new Stage();

        stage.setScene(initScene());
    }

    public static void show() {
        stage.show();
    }

    private static Scene initScene() {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 400, 300);
        Label IDLabel = new Label("Course ID: ");
        TextField IDField = new TextField();
        Label nameLabel = new Label("Course Name: ");
        TextField nameField = new TextField();
        Label creditsLabel = new Label("Credits: ");
        TextField creditsField = new TextField();

        grid.addColumn(0, IDLabel, nameLabel, creditsLabel);
        grid.addColumn(1, IDField, nameField, creditsField);

        return scene;
    }
}
