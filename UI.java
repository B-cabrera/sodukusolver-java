
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
        GridPane textGrid = new GridPane();
        Button enterButton = new Button("Enter");
        this.setProperties(enterButton,textGrid);
        

        root.getChildren().addAll(textGrid, enterButton);
        this.addFields(9,9,textGrid);

        root.setAlignment(Pos.TOP_CENTER);
        instructions.setTextAlignment(TextAlignment.CENTER);
        Scene firstScene = new Scene(root, 500,500);
        

        
        stage.setScene(firstScene);
        stage.setMinWidth(300);
        stage.setMinHeight(300);
        stage.setMaxWidth(500);
        stage.setMaxHeight(500);
        stage.setTitle("Sudoku Solver");
        stage.show();

        
    }

    public void setProperties(Button enterButton, GridPane gridOfText) {
        ArrayList<String> rList = new ArrayList<>();

        enterButton.setOnAction(e -> {
            try {
                for (Node a : gridOfText.getChildren()) {
                   TextField temp = (TextField) a;
                   
                   if (temp.getText().isEmpty()) {
                       rList.add("0");
                   } else {
                       rList.add(temp.getText());
                   }
                   
                }

                System.out.println("Data recieved: " + rList.toString());
                rList.clear();
            } catch (Exception b) {
                //TODO: handle exception
                System.out.println("Error caught: " + b.getMessage());
            }
        });
    }

    private void addFields(int len, int wid, GridPane grid) {

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                TextField tempField = new TextField();
            
                // Method to restrict input to numbers only
                tempField.textProperty().addListener((ChangeListener<? super String>) new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, 
                        String newValue) {
                        if (!newValue.matches("\\d*")) {
                            tempField.setText(newValue.replaceAll("[^\\d]", ""));
                        }
                    }

                
                });

                // Method to restrict the input to one number
                tempField.lengthProperty().addListener(new ChangeListener<Number>() {

                    @Override
                    public void changed(ObservableValue<? extends Number> observable,
                            Number oldValue, Number newValue) {
                        if (newValue.intValue() > oldValue.intValue()) {
                            // Check if the new character is greater than LIMIT
                            if (tempField.getText().length() >= 1) {
        
                                // if it's 11th character then just setText to previous
                                // one
                                tempField.setText(tempField.getText().substring(0, 1));
                            }
                        }
                    }
                });

                grid.add(tempField, i, j);
            }
        }
    }
}