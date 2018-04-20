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
    private static javafx.scene.control.Label label1, label2;
    private static javafx.scene.control.TextField field1, field2;
    private static javafx.scene.control.Button button1, button2;
    private static Semester s;
    private static AcademicPlan academicPlan;
    private static javafx.scene.control.Label termlabel, termlabel2, yearlabel;
    private static javafx.scene.control.TextField yearfield;
    private static javafx.scene.control.Button buttonAdd, buttonRemove, buttonClose;
    private static ComboBox<Term> term;
    private static ComboBox<Semester> existingterm;


    public static void addSemester(AcademicPlan a) {
        grid = new GridPane();
        academicPlan = a;
        
        label1 = new javafx.scene.control.Label("Term");
        field1 = new javafx.scene.control.TextField();
        label2 = new javafx.scene.control.Label("Year ");
        field2 = new javafx.scene.control.TextField();
        button1 = new Button("Add Semester");
        button2 = new Button("Cancel");

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

        button1.setOnAction((event) -> {
            s = new Semester(Term.SPRING, Integer.parseInt(field2.getText()));
        		academicPlan.getPersonalPlan().addSemester(s);
        		stage.close();
        });
        
        buttonAdd.setOnAction(e -> {

        			yearfield.textProperty().addListener( (observable, oldValue, newValue) -> {
                        if (newValue.isEmpty() || newValue.matches("[0-9 ]+")) {
                            ((StringProperty) observable).setValue(newValue);
                       } else {
                          	((StringProperty) observable).setValue(oldValue);
                        }
        			});

            Term newTerm = term.getSelectionModel().getSelectedItem();
            int inputyear = Integer.parseInt(yearfield.getText());
            academicPlan.getPersonalPlan().addSemester(new Semester(newTerm, inputyear));
            stage.close();

        });

        buttonClose.setOnAction((e) -> {
            stage.close();
        });

    }

    public static void removeSemester() 
    {
        grid = new GridPane();

        termlabel2 = new Label("Term");
        existingterm = new ComboBox<>(academicPlan.getPersonalPlan().getSemesters());
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
            academicPlan.getPersonalPlan().removeSemester(selectedTerm);
            stage.close();
        });

        buttonClose.setOnAction((event) -> {
            stage.close();
        });

    }
}
