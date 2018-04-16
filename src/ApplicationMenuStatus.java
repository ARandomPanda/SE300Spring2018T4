import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ApplicationMenuStatus {

    private static Stage stage;
    private static GridPane grid;
    private static Scene scene;
    private static javafx.scene.control.Label label1, label2;
    private static javafx.scene.control.TextField field1, field2;
    private static javafx.scene.control.Button button1, button2;


    public static void markDoneCourse() {
        stage = new Stage();
        stage.setTitle("mark Course Done");
        stage.setScene(scene);
        stage.show();
    }

    public static void markDoneSemester() {
        stage = new Stage();
        stage.setTitle("Mark Semester Done");
        stage.setScene(scene);
        stage.show();
    }
}
