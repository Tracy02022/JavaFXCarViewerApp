package sample;


import javafx.application.Application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;



import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;





public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
  
        HomeController homeController = new HomeController(primaryStage);
      
    }

    public static void main(String[] args) throws FileNotFoundException {

        launch(args);
    }
}
