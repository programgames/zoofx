
package utiles;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Permet de créer une vie pour pouvoir le modifier ou le récupérer
 */
public class Vie {
    
    /**
    * Creation d'un SimpleStringProperty
    */ 
    private final StringProperty Vie = new SimpleStringProperty();
        /**
         * getter de vie c'est à dire les points de vies
         * @return Vie.get()
         */
        public String getVie() {
            return Vie.get();
        }
        
        /**
         * setter de vie
         * @param value 
         */
        public void setVie(String value) {
            Vie.set(value);
        }
        
        /**
         * Acceder à la propriété
         * @return Vie
         */
        public StringProperty VieProperty() {
            return Vie;
        }
        
        /**
         * Constructeur de vie 
         * @param vie 
         */
        public Vie(String vie){
            Vie.set(vie);
        }
}
