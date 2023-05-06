import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("view/calculator.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root);*/

        Parent parent=FXMLLoader.load(getClass().getResource("view/calculator.fxml"));
        Scene scene=new Scene(parent);

        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
