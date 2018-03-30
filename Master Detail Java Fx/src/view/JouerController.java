
package view;

import java.io.IOException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import utiles.Score;
import model.JeuTraitement;
import utiles.Joueur;
import utiles.ScoreException;
import utiles.Manager;

/**
 * Permet de controler le jeu
 * elle permet de gérer la table de score du joueur
 * et le lancement du jeu
 */
public class JouerController extends Thread {
    
    /**
     * Déclaration des attributs
     */
    
    @FXML
    private TableView<Score> tableView;
    @FXML 
    private TextField lePseudo;
    @FXML 
    private TextField leScore;
    @FXML
    private Button buttonJouer;
    Score partie;
    
    /**
     * Utilisation du getteur du joueur pour recupérer son pseudo
     */
    Joueur joueurPseudo = ConnexionController.getJoueur();
    
    /**
     * Création d'un manager
     */
    private final ObjectProperty<Manager> manager = new SimpleObjectProperty<>(new Manager());
    
    /**
     * Permet de créer un nouveau score avec le pseudo du joueur
     * @throws ScoreException 
     */
    public JouerController() throws ScoreException {
        this.partie = new Score(joueurPseudo.getPseudo(),0);
    }
    
    /**
     * getter du manager
     * @return manager.get()
     */
    public Manager getManager() {
        return manager.get();
    }
    
    /**
     * setter du manager
     * @param value 
     */
     public void setManager(Manager value) { 
         manager.set(value);
     }
     
     /**
      * Permet d'accerder à la propriété
      * @return manager
      */
     public ObjectProperty<Manager> managerProperty() {
         return manager;
     }
     
    /**
    * Création d'une observable liste de score
    */
    ObservableList<Score> liste = FXCollections.observableArrayList();
    /**
     * Permet d'ajouter le score dans la liste de score pour l'afficher dans un tableau
     */
    protected void addScore() throws ScoreException{
        ObservableList<Score> data = tableView.getItems();
        data.add(new Score(partie.getLePseudo(),partie.getScoreProperty()));
        manager.get().getScoreCollection().add(new Score(partie.getLePseudo(),partie.getScoreProperty()));
    }
    
    /**
     * Permet d'initialiser un score
     * @throws ScoreException 
     */
    public void initScore() throws ScoreException{ 
        int i;
        ObservableList<Score> data = tableView.getItems();
        for(i = 0; i < this.getManager().getScoreCollection().size(); i++){
            try{
            data.add(new Score(this.getManager().getScoreCollection().get(i).getPseudoProperty(),this.getManager().getScoreCollection().get(i).getScoreProperty()));
            }
            catch (ScoreException e) {
                    System.out.println("erreur !");
            }
        }    
    }     
    
    /**
     * Action qui permet de ce lancer quand elle lance le controller
     */
    @FXML
    private void initialize() throws IOException {  
    }
    
    /**
     * Permet de créer le traitement du jeu en lui envoyant un pseudo et un score
     */
    public void initialiserJeu() throws ScoreException{
        buttonJouer.setText("Rejouer");
        JeuTraitement i = new JeuTraitement();
        partie =  i.initialisation(partie);
        if(tableView.getItems().size() < 5 ){
            addScore();
        }
        liste.add(0,partie);
 
    }
}
