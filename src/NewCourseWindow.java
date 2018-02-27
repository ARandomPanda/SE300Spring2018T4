import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;


public class NewCourseWindow {

    private static Stage stage = null;
    private static GridPane grid = new GridPane();
    private static Scene scene = new Scene(grid, 400, 300);
    private static Label IDLabel = new Label("Course ID: ");
    private static TextField IDField = new TextField();
    private static Label nameLabel = new Label("Course Name: ");
    private static TextField nameField = new TextField();
    private static Label creditsLabel = new Label("Credits: ");
    private static ChoiceBox<Integer> creditsField = new ChoiceBox<>();

    private static Button okButton = new Button("Add Course");
    private static Button cancelButton = new Button("Cancel");

    private NewCourseWindow() { }

    // Testing only
    // TODO remove when access from main window is added.
    public static void set(Stage s) {
        stage = s;
        initInputSanitizers();
        initButtons();
        Integer numCreditsArray[] = {0, 1, 2, 3, 4, 5, 6};
        ObservableList<Integer> posCredits = FXCollections.observableList(Arrays.asList(numCreditsArray));
        creditsField.setItems(posCredits);
        creditsField.setValue(3);
        grid.addColumn(0, IDLabel, nameLabel, creditsLabel, cancelButton);
        grid.addColumn(1, IDField, nameField, creditsField, okButton);
        stage.setScene(scene);
    }

    public static void init() {
        if (stage != null) return;

        stage = new Stage();

        initInputSanitizers();
        initButtons();

        Integer numCreditsArray[] = {0, 1, 2, 3, 4, 5, 6};
        ObservableList<Integer> posCredits = FXCollections.observableList(Arrays.asList(numCreditsArray));
        creditsField.setItems(posCredits);
        creditsField.setValue(3);

        grid.addColumn(0, IDLabel, nameLabel, creditsLabel, cancelButton);
        grid.addColumn(1, IDField, nameField, creditsField, okButton);
        stage.setScene(scene);
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
    }

    private static void initInputSanitizers() {
        initIDSanitizer();
        initNameSanitizer();
    }

    private static void initIDSanitizer() {
        // TODO incrementally sanitize i.e. allow letters until a space, then numbers
        IDField.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.isEmpty() || newValue.matches("[a-zA-Z 0-9]+")) {
                        ((StringProperty) observable).setValue(newValue);
                    } else {
                        ((StringProperty) observable).setValue(oldValue);
                    }
                }
        );
    }

    private static void initNameSanitizer() {
        nameField.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.isEmpty() || newValue.matches("[a-zA-Z ]+")) {
                        ((StringProperty) observable).setValue(newValue);
                    } else {
                        ((StringProperty) observable).setValue(oldValue);
                    }
                }
        );
    }

    private static void initButtons() {
        initOkButton();
        initCancelButton();
    }

    private static void initOkButton() {
        // TODO verify inputs, show error to user instead of throwing exception
        okButton.setDefaultButton(true);
        okButton.setOnAction(
                new MasterCourseListController.AddCourse(
                        IDField, nameField, creditsField, null, null)
        );
    }

    private static void initCancelButton() {
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction(
                (e) -> hide()
        );
    }
}
