
package view;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utiles.Joueur;

/**
 * Permet de controler la page d'accueil 
 * elle permet d'afficher le pseudo
 * et les boutons
 */
public class PageAccueilController {
    
    /**
     * Déclaration des attributs
     */
    @FXML
    private Label namePseudo;
    @FXML 
    private Button menu;
    
    /**
     * Utilisation du getteur du joueur pour recupérer son pseudo
     */
    Joueur joueur = ConnexionController.getJoueur();
    
    /**
     * Permet de bind son pseudo sur la page d'accueil
     */
    public void initialize(){
        namePseudo.textProperty().bind(joueur.pseudoProperty());
    }
    
    /**
     * Permet de créer la page de menu
     * @throws IOException 
     */
    @FXML
    public void ClicMenu() throws IOException{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/ressource/Menu.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Menu");
            stage.setWidth(775);
            stage.setHeight(450);
            stage.setScene(scene);
            stage.show();
           
    }
    
    /**
     * Permet de fermer la page, une fois qu'on a cliquer sur le bouton menu du jeu
     */
    @FXML
    private void ClicFermerPage(){
    //getscene = Obtient la valeur de la scène de propriété.
    // getWindow = Obtient la valeur de la fenêtre de propriétés.
    Stage stage = (Stage) menu.getScene().getWindow();
    stage.close();
    }
    
}
