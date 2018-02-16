
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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
		
		this.primaryStage.setScene(setupScene());
		
		this.primaryStage.show();
		
	}
	
	private Scene setupScene()
	{
		BorderPane highestPane = new BorderPane();
		BorderPane topBorderPane = new BorderPane();
		
		topBorderPane.setTop(makeMenu());
		highestPane.setTop(topBorderPane);
		
		Scene scene = new Scene(highestPane, 600, 600);
		
		return scene;
	}
	
	private MenuBar makeMenu()
	{
		MenuBar toolBar = new MenuBar();
		Menu dummy = new Menu("This is a Test");
		
		toolBar.getMenus().add(dummy);
		
		return toolBar;
	}

}
