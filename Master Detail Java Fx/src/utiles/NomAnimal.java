
package utiles;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Permet de Créer un nom d'animal pour le modifier et le récupérer
 */
public class NomAnimal {
    
    /**
    * Création d'un SimpleStringProperty
    */
    private final StringProperty nomAnimal = new SimpleStringProperty();
        /**
         * getter du Nom animal
         * @return nomAnimal.get()
         */
        public String getNomAnimal() {
            return nomAnimal.get();
        }
        
        /**
         * setter du Nom animal
         * @param value 
         */
        public void setNomAnimal(String value) {
            nomAnimal.set(value);
        }
        
        /**
         * Acceder à la propriété
         * @return nomAnimal
         */
        public StringProperty nomAnimalProperty() {
            return nomAnimal;
        }
        
        /**
         * Contructeur d'un Nom Animal
         * @param nom 
         */
        public NomAnimal(String nom){
            nomAnimal.set(nom);
        }
}
