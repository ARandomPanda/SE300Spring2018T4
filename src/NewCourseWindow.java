import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewCourseWindow {

    private static Stage stage = null;
    private static GridPane grid = new GridPane();
    private static Scene scene = new Scene(grid, 400, 300);
    private static Label IDLabel = new Label("Course ID: ");
    private static TextField IDField = new TextField();
    private static Label nameLabel = new Label("Course Name: ");
    private static TextField nameField = new TextField();
    private static Label creditsLabel = new Label("Credits: ");
    private static TextField creditsField = new TextField();

    private static Button okButton = new Button("Add Course");
    private static Button cancelButton = new Button("Cancel");

    private NewCourseWindow() { }

    // Testing only
    public static void set(Stage s) {
        stage = s;
        initInputSanitizers();
        grid.addColumn(0, IDLabel, nameLabel, creditsLabel, cancelButton);
        grid.addColumn(1, IDField, nameField, creditsField, okButton);
        stage.setScene(scene);
    }

    public static void init() {
        if (stage == null) {
            stage = new Stage();
            initInputSanitizers();
            grid.addColumn(0, IDLabel, nameLabel, creditsLabel, cancelButton);
            grid.addColumn(1, IDField, nameField, creditsField, okButton);
            stage.setScene(scene);
        }
    }

    public static void show() {
        resetScene();
        stage.show();
    }

    public static void hide() {
        stage.hide();
    }

    private static void resetScene() {
        IDField.clear();
        nameField.clear();
        creditsField.clear();
    }

    private static void initInputSanitizers() {
        initCreditSanitizer();
        initIDSanitizer();
        initNameSanitizer();
    }

    private static void initCreditSanitizer() {
        creditsField.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.isEmpty() || newValue.matches("\\d")) {
                        ((StringProperty) observable).setValue(newValue);
                    } else {
                        ((StringProperty) observable).setValue(oldValue);
                    }
                }
        );
    }

    private static void initIDSanitizer() {

    }

    private static void initNameSanitizer() {

    }
}
