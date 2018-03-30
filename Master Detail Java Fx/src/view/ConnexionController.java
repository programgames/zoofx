
package view;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utiles.Joueur;

/**
 * Permet de controller la page de connexion
 * elle gere la récupération du pseudo
 * le bouton pour aller sur la page principale
 */
public class ConnexionController {
    
    /**
     * Déclaration des attributs
     */
    @FXML
    private TextField pseudo;
    @FXML 
    private Button btn;
    
    /**
     * Declaration d'un joueur static
     */
    private static Joueur joueur;
    /**
     * getter d'un joueur
     * @return joueur
     */
    public static Joueur getJoueur(){
        return joueur;
    }
    
    /**
     * setter d'un joueur
     * @param valeur 
     */
    public static void setJoueur(Joueur valeur){
        joueur = valeur;
    }
    
    /**
     * Création de la page d'acceuil du jeu
     * @throws IOException 
     */
    @FXML
    public void ClicConnexion() throws IOException{
        
        ConnexionController.setJoueur(new Joueur(pseudo.getText()));
        if (!pseudo.getText().isEmpty()){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/ressource/PageAccueil.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("PageAccueil");
            stage.setWidth(500);
            stage.setHeight(400);
            stage.setScene(scene);
            stage.show();
        }
        else{
            showMessage(Alert.AlertType.ERROR, null, "Remplr le champs de Pseudo pour continuer");
        }
    }
    
    /**
     * Permet de fermer la page Connexion pour aller sur la page d'accueil
     */
    @FXML
    private void ClicFermerPage(){
    //getscene = Obtient la valeur de la scène de propriété.
    // getWindow = Obtient la valeur de la fenêtre de propriétés.
    Stage stage = (Stage) btn.getScene().getWindow();
    stage.close();
    }
    
    /**
     * Permet de marquer un message d'erreur si aucun pseudo n'est enregistré
     */
    @FXML 
    public void ClicPseudo(){
        if (pseudo.getText()==null){
        showMessage(Alert.AlertType.ERROR, null, "Ceci est un message d'erreur qui ne fait rien si on clique sur OK.");
        }
    }
    
    /**
     * Permet la construction du message d'erreur car celui ci fait appel showMessage
     * @param type
     * @param header
     * @param message
     * @param lesBoutonsDifferents
     * @return 
     */
    private Optional<ButtonType> showMessage(Alert.AlertType type,String header,String message,ButtonType... lesBoutonsDifferents){
        Alert laFenetre = new Alert(type);
        laFenetre.setHeaderText(header);
        laFenetre.setContentText(message);
        if (lesBoutonsDifferents.length > 0) {
            laFenetre.getButtonTypes().clear();
            laFenetre.getButtonTypes().addAll(lesBoutonsDifferents);
        }
        return laFenetre.showAndWait();
    }
    
}
