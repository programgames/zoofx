
package view;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import persistance.persXML.XMLDataManager;
import utiles.Manager;
import utiles.ScoreException;
import utiles.Vie;

/**
 * Permet de controller la page de menu
 * elle gére les boutons
 * le lancement de la page pour selectionner son personnage
 * le lancement de la page du choix de la nourriture
 * le lancement du jeu
 * quitter le jeu
 */
public class MenuController {
    
    /**
     * Déclaration des attributs
     */
    @FXML
    private Button fermeJeu;
    @FXML
    private Label vie; 
    @FXML 
    private Button buttonJouer;
    
    /**
     * Déclaration d'un manager
     */
    private final Manager manager = new Manager();
    /**
     * Déclaration d'une vie static
     */
    private static Vie PointVie;
    /**
     * getter d'un point de vie
     * @return PointVie
     */
    public static Vie getPointVie(){
        return PointVie;
    }
    
    /**
     * setter d'un point de vie
     * @param valeur 
     */
    public static void setPointVie(Vie valeur){
        PointVie = valeur;
    }
    
    /**
     * Permet de créer la page detail animaux qui correspont au choix du personnage
     * @throws IOException 
     */
    @FXML
    public void ClicDetailAnimaux()throws IOException{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/ressource/DetailAnimaux.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Detail perso");
            stage.setWidth(575);
            stage.setHeight(450);
            stage.setScene(scene);
            stage.show();
        
    }
    
    /**
     * Permet de créer la page qui permet d'aller sur la page nourrire son animal
     * @throws IOException 
     */
    @FXML
    public void clicNourritureAnimal()throws IOException{    
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/ressource/NourritureAnimal.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Nourriture Animal");
            stage.setWidth(450);
            stage.setHeight(500);
            stage.setScene(scene);
            stage.show();
    }
    
    /**
     * Permet de lancer la fenetre de jeu
     * @throws IOException 
     */
   @FXML
    private void clicJouer() throws IOException, ScoreException{
        chargeScore();
        buttonJouer.setText("A cliquer");
        Stage stage = new Stage();
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/ressource/Jouer.fxml"));
        Parent root = fxmlloader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("/ressource/Jouer.fxml"));
        JouerController controller =  fxmlloader.getController();
        controller.setManager(manager);
        controller.initScore();
        stage.setTitle("Bienvenue dans le jeu");
        stage.setWidth(320);
        stage.setHeight(300);
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    
    /**
     * Permet de quitter le jeu
     */
    @FXML
    private void ClicFermeJeu(){
        Stage stage = (Stage) 
        fermeJeu.getScene().getWindow(); 
        stage.close(); 
    }
    
    /**
     * Permet de charger les scores
     */
    private void chargeScore(){
        if (manager.getScoreCollection().isEmpty()) {
            manager.setDataManager(new XMLDataManager());
            manager.chargeScore();
        }
    }
    
    /**
     * Permet de sauvegarder les scores
     */
    private void sauveScore() {
        manager.setDataManager(new XMLDataManager());
        manager.sauveScore();
    }
}
