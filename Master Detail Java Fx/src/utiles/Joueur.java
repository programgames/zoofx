
package utiles;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Permet de créer un Joueur 
 */
public class Joueur {
    
    /**
    * Création d'un SimpleStringProperty
    */
    private final StringProperty pseudo = new SimpleStringProperty();
        /**
         * getter du pseudo
         * @return pseudo.get() 
         */
        public String getPseudo() {
            return pseudo.get();
        }
        
        /**
         * setter du pseudo
         * @param value 
         */
        public void setPseudo(String value) {
            pseudo.set(value);
        }
        
        /**
         * Acceder à la propriété
         * @return pseudo
         */
        public StringProperty pseudoProperty() {
            return pseudo;
        }
        
        /**
         * Constructeur d'un joueur
         * @param Pseudo 
         */
        public Joueur(String Pseudo){
         pseudo.set(Pseudo);
        }
    
}
