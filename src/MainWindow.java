
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	private Stage primaryStage = null;
	
	
	public static void main(String[] args)
	{
		launch();
	}
	
	public void start(Stage primaryStage)
	{
		this.primaryStage = primaryStage;

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("This is a dummy window");
		
		this.primaryStage.setScene(new Scene(new BorderPane(), 600, 600));
		
		
		
		this.primaryStage.show();
		
	}

}
