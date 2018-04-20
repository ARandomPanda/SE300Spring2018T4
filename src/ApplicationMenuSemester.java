import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    public static void addSemester(AcademicPlan a) {
        grid = new GridPane();
        academicPlan = a;
        
        label1 = new javafx.scene.control.Label("Term");
        field1 = new javafx.scene.control.TextField();
        label2 = new javafx.scene.control.Label("Year ");
        field2 = new javafx.scene.control.TextField();
        button1 = new Button("Add Semester");
        button2 = new Button("Cancel");

        grid.add(label1, 0, 0);
        grid.add(field1, 1, 0);
        grid.add(label2, 0, 1);
        grid.add(field2, 1, 1);
        grid.add(button1, 0, 3);
        grid.add(button2, 1, 3);


        scene = new Scene(grid, 250, 100);
        stage = new Stage();
        stage.setTitle("Add Semester");
        stage.setScene(scene);
        stage.show();

        button1.setOnAction((event) -> {
            s = new Semester(Term.SPRING, Integer.parseInt(field2.getText()));
        		academicPlan.getPersonalPlan().addSemester(s);
        		stage.close();
        });

        button2.setOnAction((event) -> {
            stage.close();
        });
    }


    public static void removeSemester() {
        stage = new Stage();
        stage.setTitle("Remove Semester");
        stage.show();


    }
}
