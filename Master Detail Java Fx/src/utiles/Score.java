package utiles;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *  Classe des scores qui implemente Iscore
 */
public class Score implements IScore {
    
    /**
     * Acceder aux propriétés
     */
     private final StringProperty lePseudo= new SimpleStringProperty();
     private final IntegerProperty leScore = new SimpleIntegerProperty();
    /**
     * Constructeur de base du score
     */
    public Score(){
    }
    
    /**
     * Constructeur des scores avec paramatres
     * @param nom
     * @param Vscore
     */
    public Score(String nom,Integer Vscore) throws  ScoreException {
        if(Vscore < 0)
           throw new ScoreException();
        setPseudoProperty(nom);
        setScoreProperty(Vscore);
    }
    
    @Override
    /**
     * Acceder à la propriété
     * @return lePseudo
     */
    public StringProperty lePseudoProperty(){
        return lePseudo;
    }
    
    /**
     * getter du pseudo 
     * @return lePseudoProperty
     */
    public String getLePseudo(){ 
        return lePseudo.get();
    }
    
    /**
     * setter du pseudo 
     * @param value
     */
    public void setLePseudo (String value){
        lePseudo.set(value);
    }
    
     /**
     * Acceder à la propriété
     * @return leScore
     */
    @Override
    public IntegerProperty leScoreProperty() {
        return leScore;
    }
    
    /**
     * getter du score
     * @return leScoreProperty
     */
    public IntegerProperty getLeScore(){
        return leScore ;
    }
    
     /**
     * setter du score
     * @param value 
     */
    public void setLeScore (Integer value){
        leScore.set(value);
    }
}
