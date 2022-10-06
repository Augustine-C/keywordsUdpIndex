import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        DataProcessor dataProcessor = new DataProcessor();
        // create a add data button
        Button addDataButton = new Button("Add Data");


        // create a text area to display dataProcessor result
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        //create padding around the text field
        textArea.setPadding(new Insets(10, 10, 10, 10));
        textArea.setText("test");


        BorderPane root = new BorderPane();

        //set addDataButton at the top center of root
        BorderPane.setAlignment(addDataButton, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(addDataButton, new Insets(50, 10, 10, 10));
        root.setTop(addDataButton);

        //set textField at the center of root
        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(textArea, new Insets(10, 10, 10, 10));
        root.setCenter(textArea);

        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();

        addDataButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Add Data");
            dialog.setHeaderText("Add Data");
            dialog.setContentText("Please enter data:");
            dialog.showAndWait();
            String data = dialog.getResult();
            try {
                dataProcessor.process(data);
                System.out.println(dataProcessor.getYearCount());
                // display data on testField
//                textArea.setText(dataProcessor.getYearCount().toString());
                textArea.setText(dataProcessor.getResult().toString());
            } catch (Exception exception) {
                exception.printStackTrace();
                //show warning alert
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Warning");
                alert.setContentText("Invalid data format");
                alert.showAndWait();
            }
        });


    }

    public static void main(String[] args) {
        launch();
    }

}
