
package persistance.persXML;


import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utiles.IScore;
import utiles.FabriqueScore;

/**
 * Permet de charger et sauvegrader un score 
 * Utilisation du système de sérialisation de Java
 */
 
public class XMLScore implements IScore, Serializable {
    
    /**
     * Constructeur d'un XMLScore 
     */
    public XMLScore(){
        this(FabriqueScore.fabriqueScore());   
    }
    
    /**
     * Constructeur d'un XMLScore avec des parametres
     * @param model 
     */
    public XMLScore(IScore model) {
        this.model = model;
        pseudo = new SimpleStringProperty(model.getPseudoProperty());
        score = new SimpleIntegerProperty(model.getScoreProperty());  
    }
    
    /**
     * Création d'un model qui permet de ne pas sérialisé ce champs
     * elle ne fait pas partie de l'état persistant d'un objet
     */
    private transient IScore model;
    /**
     * getter d'un Iscore intitulé model
     * @return model
     */
    public IScore getModel() {   
        return model;
    }
    
    /**
     * Déclaration d'un pseudo
     */
    private final StringProperty pseudo;
    /**
     * Acceder à la propriété
     * @return model.lePseudoProperty()
     */
    @Override public StringProperty lePseudoProperty() {
        return model.lePseudoProperty();
    }
    
    /**
     * getter du pseudoProperty
     * @return IScore.super.getPseudoProperty()
     */
    @Override public String getPseudoProperty() {
        return IScore.super.getPseudoProperty();
    }
    
    /**
     * setter du pseudoProperty
     * @param value 
     */
    @Override public void setPseudoProperty(String value) { 
        IScore.super.setPseudoProperty(value); 
    }
     
    /**
     * Déclaration d'un score en int
     */
    private final IntegerProperty score;
    /**
     * Acceder à la propriété
     * @return model.leScoreProperty()
     */
    @Override  public IntegerProperty leScoreProperty() {
        return model.leScoreProperty();
    }
    
    /**
     * getter de scoreProperty
     * @return IScore.super.getScoreProperty()
     */
    @Override  public int getScoreProperty() {
        return IScore.super.getScoreProperty();
    }
    
    /**
     * setter de scoreProperty
     * @param value 
     */
    @Override  public void setScoreProperty(Integer value) {
        IScore.super.setScoreProperty(value);
    }
           
}