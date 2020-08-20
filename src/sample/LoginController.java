package sample;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.layout.GridPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class LoginController {
    

    @FXML
    public TextField emailIdField;

    @FXML
    public PasswordField passwordField;
    
    @FXML
    public TextField emailIdField2;

    @FXML
    public PasswordField passwordField2;

    @FXML
    public Button submitButton;

    @FXML
    public Button regButton;

    @FXML
    public void login(ActionEvent event) throws SQLException, InterruptedException {
                Stage owner = (Stage)submitButton.getScene().getWindow();

                    if (emailIdField.getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                "Please enter your email id");
                        return;
                    }
                    if (passwordField.getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                "Please enter a password");
                        return;
                    }

                    String emailId = emailIdField.getText();
                    String password = passwordField.getText();

                    JdbcDao jdbcDao = new JdbcDao();
                    boolean flag = false;
                    try {
                        flag = jdbcDao.validate(emailId, password);
                    } catch (SQLException /*throwables*/e) {
                    }

                    if (!flag) {
                        infoBox("Please enter correct Email and Password or register", null, "Failed");
                    } else {
                       owner.close();
                       loadingCounter();  
                    }

    }

    @FXML
    public void register(ActionEvent event) throws SQLException, IOException {

        GridPane root = new GridPane();
        try {
            root = FXMLLoader.load(getClass().getResource("register.fxml"));
        } catch (IOException e) {
        }
        Stage window = new Stage();
        Scene scene2;
     
        scene2 = new Scene(root,600,300);

        window.setScene(scene2);
        window.setTitle("Register");
        window.show();
        
    }
    
    @FXML
    public void registerSubmit(ActionEvent event) {
        
        Stage owner = (Stage)regButton.getScene().getWindow();

        if (emailIdField2.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return;
        }
        if (passwordField2.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }

        String emailId = emailIdField2.getText();
        String password = passwordField2.getText();

        JdbcDao jdbcDao = new JdbcDao();
                    try {
                        jdbcDao.createUser(emailId, password);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }

        infoBox("User Created Successful! Please log in", "Register", "Success");
        owner.close();
        
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.show();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
    private void loadingCounter () throws InterruptedException {
        
            Stage primaryStage = new Stage(StageStyle.UNDECORATED);
            //Initialising path of the media file, replace this with your file path   
            String path = "loading.mp4";  
          
            //Instantiating Media class  
            Media media = new Media(new File(path).toURI().toString());  

            //Instantiating MediaPlayer class   
            MediaPlayer mediaPlayer = new MediaPlayer(media);  

            //Instantiating MediaView class   
            MediaView mediaView = new MediaView(mediaPlayer);  
    
            //by setting this property to true, the Video will be played   
            mediaPlayer.setAutoPlay(true);  

          
            //setting group and scene   
            Group root = new Group();  
            root.getChildren().add(mediaView);  
            Scene scene = new Scene(root,640,350); 
                       
            primaryStage.setScene(scene);  
            primaryStage.setTitle("Loading...");  
            primaryStage.show();

            mediaPlayer.setOnEndOfMedia(() -> {
                primaryStage.close();
                try {
                    new CarViewController().showAll();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

    }
    
}