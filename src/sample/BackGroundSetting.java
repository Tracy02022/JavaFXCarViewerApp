package sample;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class BackGroundSetting {

    private LoginController handler = null;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path = null;

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private String title = null;

    public BackGroundSetting(Stage primaryStage) throws IOException {
        handler = new LoginController();
        setTitle("Welcome");
        create(primaryStage);
    }

    private void create(Stage primaryStage) throws IOException {
        //Creating a Group object

        GridPane root;
        root = FXMLLoader.load(getClass().getResource("login.fxml"));

        //Creating a scene object
        Scene scene = new Scene(root, 600, 400);
        //Setting title to the Stage
        primaryStage.setTitle(title);

        //Adding scene to the stage
        primaryStage.setScene(scene);

        primaryStage.setResizable(true);

        //Displaying the contents of the stage
        primaryStage.show();

    }

}
