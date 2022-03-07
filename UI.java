import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UI extends Application{

    /* This will be the file that I will be making
    the user interface in.
    */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene firstScene = new Scene(root, 500,500);

        stage.setScene(firstScene);
        stage.setTitle("Testing 1 2 3");
        stage.show();

        
    }
}