package utiles;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 * Permet de Créer de la nourriture
 */
public class Nourriture {
    
        /**
        * Création d'un SimpleStringProperty
        */
	private final StringProperty leTexte = new SimpleStringProperty();
            /**
             * setter du texte c'est à dire la nourriture 
             * @param valeur 
             */
            public void setLeTexte(String valeur){
                leTexte.set(valeur);
            }
            
            /**
             * getter du texte
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
        * Creation d'un SimpleStringProperty
        */   
        private final StringProperty animalAssocie = new SimpleStringProperty();
            /**
             * setter de l'animal Associé c'est à dire l'animal qui mange la nourriture
             * @param valeur 
             */
            public void setAnimalAssocie(String valeur){
                animalAssocie.set(valeur);
            }
            
            /**
             * getter de l'animal associé
             * @return animalAssocie.get()
             */
            public String getAnimalAssocie(){
                return animalAssocie.get();
            }
            
            /**
             * Acceder à la propriété
             * @return animalAssocie
             */
            public StringProperty animalAssocieProperty(){
                return animalAssocie;
            }
            
        /**
        * Creation d'un SimpleStringProperty
        */  
        private final StringProperty leDetail = new SimpleStringProperty();
            /**
             * setter du detail c'est à dire le nombre de point de vie que ca permet d'avoir quand on mange cette nourriture
             * @param valeur 
             */
            public void setLeDetail(String valeur){
                leDetail.set(valeur);
            }
            
            /**
             * getter du détail
             * @return 
             */
            public String getLeDetail(){
                return leDetail.get();
            }
            
            /**
             * Acceder à la propriété
             * @return leDetail
             */
            public StringProperty leDetailProperty(){
                return leDetail;
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
         * Constructeur d'une nourriture
         * @param animal
         * @param texte
         * @param detail
         * @param image 
         */
	public Nourriture(String animal, String texte , String detail, Image image) {
                animalAssocie.set(animal);
		leTexte.set(texte);
                leDetail.set(detail);
                uneImage.set(image);	
        }
}