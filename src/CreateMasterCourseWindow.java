import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;


public class CreateMasterCourseWindow {

    private static Stage stage = null;
    private static GridPane grid = new GridPane();
    private static Scene scene = new Scene(grid, 300, 180);
    private static Label IDLabel = new Label("Course ID: ");
    private static TextField IDField = new TextField();
    private static Label nameLabel = new Label("Course Name: ");
    private static TextField nameField = new TextField();
    private static Label creditsLabel = new Label("Credits: ");
    private static ChoiceBox<Integer> creditsField = new ChoiceBox<>();

    private static Label prereqsLabel = new Label("Prerequisites: ");
    private static ComboBox<BaseCourse> pre1 = new ComboBox<>(MasterCourseList.get().getCourseList());
    private static ComboBox<BaseCourse> pre2 = new ComboBox<>(MasterCourseList.get().getCourseList());

    private static Label coreqsLabel = new Label("Corequisites: ");
    private static ComboBox<BaseCourse> co1 = new ComboBox<>(MasterCourseList.get().getCourseList());
    private static ComboBox<BaseCourse> co2 = new ComboBox<>(MasterCourseList.get().getCourseList());

    private static Button okButton = new Button("Add Course");
    private static Button cancelButton = new Button("Close");

    private CreateMasterCourseWindow() { }


    public static void init() {
        if (stage != null) return;

        stage = new Stage();
        stage.setTitle("New Course");

        initInputSanitizers();
        initButtons();

        Integer numCreditsArray[] = {0, 1, 2, 3, 4, 5, 6};
        ObservableList<Integer> posCredits = FXCollections.observableList(Arrays.asList(numCreditsArray));
        creditsField.setItems(posCredits);
        creditsField.setValue(3);

        grid.add(IDLabel,0, 1);
        grid.add(IDField, 1, 1, 2, 1);
        grid.add(nameLabel, 0, 2);
        grid.add(nameField, 1, 2, 2, 1);
        grid.addRow(3, creditsLabel, creditsField);
        grid.addRow(4, prereqsLabel, pre1, pre2);
        grid.addRow(5, coreqsLabel, co1, co2);

        grid.add(cancelButton, 1, 7);
        grid.add(okButton, 2, 7);
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
