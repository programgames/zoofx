package utiles;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 * Permet de Créer un aniaml
 */
public class Animal {
    
	/**
         * Creation d'un SimpleStringProperty
         */
    	private final StringProperty leNom = new SimpleStringProperty();
            /**
             * setter du Nom de l'animal
             * @param valeur 
             */
            public void setLeNom(String valeur){
                leNom.set(valeur);
            }
            
            /**
             * getter du Nom de l'animal
             * @return leNom.get()
             */
            public String getLeNom(){
                return leNom.get();
            }
            
            /**
             * Acceder à la propriété
             * @return leNom
             */
            public StringProperty leNomProperty(){
                return leNom;
            }
            
        /**
         * Creation d'un SimpleStringProperty
         */
	private final StringProperty leTexte = new SimpleStringProperty();
            /**
             * setter du texte de l'animal (la nourriture de l'animal)
             * @param valeur 
             */
            public void setLeTexte(String valeur){
                leTexte.set(valeur);
            }
            
            /**
             * getter du texte de l'animal
             * @return leTexte.get()
             */
            public String getLeTexte(){
                return leTexte.get();
            }
            
            /**
             * Acceder à la propriété
             * @return leTexte
             */
            public StringProperty leTexteProperty(){
                return leTexte;
            }
            
        /**
         * Création d'un SimpleObjectProperty qui est un objet Image
         */
        private final ObjectProperty<Image> uneImage = new SimpleObjectProperty<>();
            /**
             * getter de l'image
             * @return uneImage.get()
             */     
            public Image getUneImage() {
                return uneImage.get();
            }
            
            /**
             * setter de l'image 
             * @param value 
             */
            public void setUneImage(Image value) {
                uneImage.set(value);
            }
            /**
             * Acceder à la propriété
             * @return uneImage
             */
            public ObjectProperty uneImageProperty() {
                return uneImage;
            }

       /**
        * Constructeur d'un animal
        * @param nom
        * @param texte
        * @param image 
        */
	public Animal(String nom,String texte, Image image) {
                leNom.set(nom);
		leTexte.set(texte);
                uneImage.set(image);
        }
}