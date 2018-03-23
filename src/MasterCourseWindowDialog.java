import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * @author Christopher McFall
 *
 * A window for adding courses to the master course list. Intended to be used only by advisors and/or program
 * coordinators.
 */
public class MasterCourseWindowDialog {

    private static Stage stage;
    private static GridPane grid;
    private static Scene scene;
    private static Label IDLabel, nameLabel, creditsLabel;
    private static TextField IDField, nameField;
    private static ChoiceBox<Integer> creditsField;

    // TODO ensure a blank choice is available
    private static Label prereqsLabel, coreqsLabel;
    private static ComboBox<BaseCourse> pre1, pre2, co1, co2;

    private static Button okButton, cancelButton;

    // Disable creation of this object
    private MasterCourseWindowDialog() { }

    /**
     * Initializes the window if it hasn't been initialize before. If it has already been initlialized this method
     * does nothing.
     */
    public static void init() {
    	
        if (stage != null) return;

        initializeobjects();
        initInputSanitizers();
        initButtons();
        setupCredits();
        fillInGridLabels();

        stage.setScene(scene); // show dialog
    }

    private static void setupCredits() {
        Integer numCreditsArray[] = {0, 1, 2, 3, 4, 5, 6};
        ObservableList<Integer> posCredits = FXCollections.observableList(Arrays.asList(numCreditsArray));
        creditsField.setItems(posCredits);
        creditsField.setValue(3);		
	}

	private static void fillInGridLabels() {
        grid.add(IDLabel,0, 1);
        grid.add(IDField, 1, 1, 2, 1);
        grid.add(nameLabel, 0, 2);
        grid.add(nameField, 1, 2, 2, 1);
        grid.addRow(3, creditsLabel, creditsField);
        grid.addRow(4, prereqsLabel, pre1, pre2);
        grid.addRow(5, coreqsLabel, co1, co2);

        grid.add(cancelButton, 1, 7);
        grid.add(okButton, 2, 7);		
	}

	private static void initializeobjects() {
        stage = null;
        grid = new GridPane();
        scene = new Scene(grid, 300, 180);
        IDLabel = new Label("Course ID: ");
        IDField = new TextField();
        nameLabel = new Label("Course Name: ");
        nameField = new TextField();
        creditsLabel = new Label("Credits: ");
        creditsField = new ChoiceBox<>();

        prereqsLabel = new Label("Prerequisites: ");
        pre1 = new ComboBox<>(MasterCourseList.get().getCourseList());
        pre2 = new ComboBox<>(MasterCourseList.get().getCourseList());

        coreqsLabel = new Label("Corequisites: ");
        co1 = new ComboBox<>(MasterCourseList.get().getCourseList());
        co2 = new ComboBox<>(MasterCourseList.get().getCourseList());

        okButton = new Button("Add Course");
        cancelButton = new Button("Close");
        
        stage = new Stage();
        stage.setTitle("New Course");
    }

	/**
     * Resets the fields and shows the window
     */
    public static void show() {
        resetScene();
        stage.show();
    }

    /**
     * hides the window
     */
    public static void hide() {
        stage.hide();
    }

    /**
     * clears text fields
     */
    private static void resetScene() {
        IDField.clear();
        nameField.clear();
    }

    private static void initInputSanitizers() {
        initIDSanitizer();
        initNameSanitizer();
    }

    /**
     * Ensures only alphanumeric characters can be typed into the text field
     */
    private static void initIDSanitizer() {
        IDField.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // TODO allow L after number
                    if (newValue.isEmpty() || newValue.matches("[a-zA-Z 0-9]+")) {
                        ((StringProperty) observable).setValue(newValue);
                    } else {
                        ((StringProperty) observable).setValue(oldValue);
                    }
                }
        );
    }

    /**
     * Ensures only characters a-z and spaces can be typed into the text field
     */
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
        okButton.setOnAction(e -> {
            MasterCourseListController.addCourse(IDField, nameField, creditsField,
                                                 pre1, pre2, co1, co2);
        });
    }

    private static void initCancelButton() {
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction(
                (e) -> hide()
        );
    }
}
