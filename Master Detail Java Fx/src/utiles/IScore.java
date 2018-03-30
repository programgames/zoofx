package utiles;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Interface pour les scores c'est à dire le pseudo et le score 
 */
public interface IScore {
    
    /**
     * Acceder aux propriétés
     */
    public StringProperty lePseudoProperty();
    
    public IntegerProperty leScoreProperty();
    
    /**
     * getter du pseudo 
     * @return lePseudoProperty
     */
    default public String getPseudoProperty(){
        return lePseudoProperty().get();
    }
    
    /**
     * setter du pseudo 
     * @param value
     */
    default public void setPseudoProperty(String value){
        lePseudoProperty().set(value);
    }
    
    /**
     * getter du score
     * @return leScoreProperty
     */
    default public int getScoreProperty(){
        return leScoreProperty().get();
    }
    
    /**
     * setter du score
     * @param value 
     */
    default public void setScoreProperty(Integer value){
        leScoreProperty().set(value);
    }
    
   
}