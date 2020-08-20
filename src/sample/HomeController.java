/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author i857587
 */
public class HomeController {
     @FXML
     public Button firstButton;
     
    /**
     *
     */
    @FXML
     public void onClick () {
       
         Stage owner = (Stage)firstButton.getScene().getWindow();
         owner.close();
         try {
              BackGroundSetting backGroundSetting = new BackGroundSetting(owner);
         } catch (IOException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
     }
     
     
    public HomeController() {

    }
     public HomeController(Stage primaryStage) throws IOException {
        Button bt = new Button("Hey There ♪(^∇^*) Click me"); 
  
        bt.setStyle(
                "-fx-background-color: #efeef5; " +
                "-fx-background-radius: 50em; " +
                "-fx-min-width: 300px; " +
                "-fx-min-height: 300px; " +
                "-fx-max-width: 300px; " +
                "-fx-max-height: 300px;"
        );
 
        Group root = new Group(bt);
        
        Scene scene = new Scene(root, 400, 400);
        //Duration = 2.5 seconds
        Duration duration = Duration.millis(2500);
        //Create new translate transition
        TranslateTransition transition = new TranslateTransition(duration, bt);
        //Move in X axis by +200
        transition.setByX(200);
        //Move in Y axis by +100
        transition.setByY(100);
        //Go back to previous position after 2.5 seconds
        transition.setAutoReverse(true);
        //Repeat animation twice
        transition.setCycleCount(5);
        transition.play();
        
        primaryStage.setScene(scene);
        primaryStage.show();
        bt.setOnAction((ActionEvent e) -> {
            primaryStage.close();
            try {
                BackGroundSetting backGroundSetting = new BackGroundSetting(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
 
    }
    
}
