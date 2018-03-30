
package utiles;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Permet de Créer une partie de jeu
 */
public class Partie {
    
    /**
    * Creation d'un SimpleStringProperty
    */
    private StringProperty lePseudo= new SimpleStringProperty();
        /**
         * Acceder à la propriété
         * @return lePseudo
         */
        public StringProperty lePseudoProperty(){
            return lePseudo;
        }
        
        /**
         * getter du pseudo
         * @return lePseudo.get()
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
    * Creation d'un SimpleStringProperty
    */    
    private StringProperty image= new SimpleStringProperty();
        /**
         * Acceder à la propriété
         * @return image
         */
        public StringProperty imageProperty(){
            return image;
        }
        
        /**
         * getter de l'image 
         * @return image.get()
         */
        public String getImage(){ 
            return image.get();
        }
        
        /**
         * setter de l'image
         * @param value 
         */
        public void setImage (String value){
            image.set(value);
        }
        
    /**
    * Création d'un SimpleStringProperty
    */   
    private StringProperty nomAnimal= new SimpleStringProperty();
        /**
         * Acceder à la propriété
         * @return nomAnimal
         */
        public StringProperty nomAnimalProperty(){
            return nomAnimal;
        }
        
        /**
         * getter du nomAnimal
         * @return nomAnimal.get() 
         */
        public String getNomAnimal(){
            return nomAnimal.get();
        }
        
        /**
         * setter du nomAnimal
         * @param value 
         */
        public void setNomAnimal (String value){
            nomAnimal.set(value);
        }
         
}
