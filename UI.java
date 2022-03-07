import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
        Text instructions = new Text();
        instructions.setText("Enter a Sudoku Board");
        instructions.setX(150);
        instructions.setY(20);
        instructions.setFont(new Font(30));


        VBox root = new VBox(instructions);
        root.setAlignment(Pos.TOP_CENTER);
        instructions.setTextAlignment(TextAlignment.CENTER);
        Scene firstScene = new Scene(root, 500,500);

        
        stage.setScene(firstScene);
        stage.setTitle("Sudoku Solver");
        stage.show();

        
    }
}