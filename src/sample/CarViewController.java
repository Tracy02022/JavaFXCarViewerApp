package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.control.Button;



public class CarViewController {

    @FXML
    Button bmwinfo;
    
    /**
     *
     * @throws SQLException
     */
    @FXML
    public void showAll () throws SQLException {
        GridPane root = new GridPane();
        try {
            root = FXMLLoader.load(getClass().getResource("cars.fxml"));
        } catch (IOException e) {
        }

        Stage window = new Stage();
        Scene scene2;
     
        scene2 = new Scene(root,890,980);

        window.setScene(scene2);
        window.setTitle("Car Viewer");
        window.show();
    }
    
    @FXML
    public void showInfo () throws SQLException {
        JdbcDao jdbcDao = new JdbcDao();
        Cars car = jdbcDao.searchCar(1);
      
    }
    
}
