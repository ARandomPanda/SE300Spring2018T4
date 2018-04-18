import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ApplicationMenuSemester {

    private static Stage stage;
    private static GridPane grid;
    private static Scene scene;
    private static javafx.scene.control.Label termlabel, termlabel2, yearlabel;
    private static javafx.scene.control.TextField yearfield;
    private static javafx.scene.control.Button buttonAdd, buttonRemove, buttonClose;
    private static ComboBox<Term> term;
    private static ComboBox<Semester> existingterm;

    public static void addSemester() {
        grid = new GridPane();

        termlabel = new javafx.scene.control.Label("Term");
        yearlabel = new javafx.scene.control.Label("Year ");
        term = new ComboBox<>();
        term.getItems().setAll(Term.values());
        yearfield = new javafx.scene.control.TextField();
        buttonAdd = new Button("Add Semester");
        buttonClose = new Button("Close");


        grid.add(termlabel, 0, 0);
        grid.add(term, 1, 0);
        grid.add(yearlabel, 0, 1);
        grid.add(yearfield, 1, 1);
        grid.add(buttonAdd, 0, 3);
        grid.add(buttonClose, 1, 3);

        stage = new Stage();
        scene = new Scene(grid, 250, 100);
        stage.setTitle("Add Semester");
        stage.setScene(scene);
        stage.show();

        buttonAdd.setOnAction((ActionEvent event) -> {

            yearfield.textProperty().addListener(
                    (observable, oldValue, newValue) -> {
                        if (newValue.isEmpty() || newValue.matches("[0-9 ]+")) {
                            ((StringProperty) observable).setValue(newValue);
                        } else {
                            ((StringProperty) observable).setValue(oldValue);
                        }
                    }
            );

            Term newTerm = term.getSelectionModel().getSelectedItem();
            int inputyear = Integer.parseInt(yearfield.getText());
            PersonalPlan.addSemester(new Semester(newTerm, inputyear));
            stage.close();

        });

        buttonClose.setOnAction((event) -> {
            stage.close();
        });

    }


    public static void removeSemester() {
        grid = new GridPane();

        termlabel2 = new Label("Term");
        existingterm = new ComboBox<>(PersonalPlan.getSemesters());
        buttonRemove = new Button("Remove Semester");
        buttonClose = new Button("Close");

        grid.add(termlabel2, 0, 0);
        grid.add(existingterm, 1, 0);
        grid.add(buttonRemove, 0, 2);
        grid.add(buttonClose, 1, 2);

        stage = new Stage();
        scene = new Scene(grid, 250, 100);
        stage.setTitle("Remove Semester");
        stage.setScene(scene);
        stage.show();

        buttonRemove.setOnAction((ActionEvent event) -> {

            Semester selectedTerm = existingterm.getSelectionModel().getSelectedItem();
            PersonalPlan.removeSemester(selectedTerm);
            stage.close();
        });

        buttonClose.setOnAction((event) -> {
            stage.close();
        });

    }
}
