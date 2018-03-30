
package test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {
    /**
     * Permet de créer la première fenetre de l'application
     * @param stage 
     */
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ressource/Connexion.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Welcome");
            stage.setWidth(500);
            stage.setHeight(400);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Main(String[] args) {
        launch(args);
    }
}
