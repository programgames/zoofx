
package utiles;

import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Controle de la serialisation :
 * du chargement et de la sauvegarde des données 
 */

public class Manager {
    
    /**
     * Création d'une nouvelle liste observable vide. 
     */
    private ObservableList<IScore> scoreObs = FXCollections.observableArrayList();
    /**
    *  Création d'une simpleListeProperty de score
    */
    private final ListProperty<IScore> scoreCollection = new SimpleListProperty<>(scoreObs);
    /**
     * getter de la liste de score
     * @return scoreCollection.get()
     */
    public ObservableList<IScore> getScoreCollection() {
        return scoreCollection.get();
    }
    
    /**
     * setter de la liste de score
     * @param value 
     */
    public void setScoreCollection(ObservableList value) { 
        scoreCollection.set(value); 
    }
    
    /**
     * Acceder à la propriété
     * @return scoreCollection
     */
    public ReadOnlyListProperty<IScore> scoreCollectionProperty() {
        return scoreCollection;
    }
    
    /**
     * Déclaration du dataManger qui est le responsable 
     */
    private DataManager dataManager;
    /**
     * setter du dataManger
     * @param dm 
     */
    public void setDataManager(DataManager dm) {
        dataManager = dm;
    }  
    
    /**
     * Récuperation des données c'est à dire la liste de score 
     * responsabilité au dataManager
     */
    public void chargeScore() {
        if (dataManager != null) {                                 
            List<IScore> result = dataManager.chargeScore();
            if (result != null) {
                getScoreCollection().clear();
                getScoreCollection().addAll(dataManager.chargeScore());
            }
        }
    }
    
    /**
     * Sauvegarde des données c'est à dire la liste de score 
     * responsabilité au dataManager
     */
    public void sauveScore() {
        if (dataManager != null) {
            dataManager.sauveScore(getScoreCollection());
        }
    }
    
    /**
     * Constructeur d'un manager
     */
    public Manager() {      
    }
    
    /**
     * Constructeur d'un manager avec des parametres
     * @param dm 
     */
    public Manager(DataManager dm) {
        setDataManager(dm);
        if (dataManager != null) {
            chargeScore();  
        }
    }
}