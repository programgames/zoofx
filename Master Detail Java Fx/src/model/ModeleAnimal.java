package model;

import java.io.File;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import utiles.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/** 
 * Permet de gérer l'ajoue dans la liste des animaux 
 */
public class ModeleAnimal {
    
    /**
    *  Création d'une nouvelle liste observable vide. 
    */
    private ObservableList<Animal> lesAnimauxObs = FXCollections.observableArrayList();
    /**
    *  Création d'une simpleListeProperty d'animaux. 
    */
    private final ListProperty<Animal> lesAnimaux = new SimpleListProperty<>(lesAnimauxObs);
    /**
     * getter de la liste lesAnimaux 
     * @return lesAnimaux.get()
     */
    public ObservableList<Animal> getLesAnimaux() {
        return lesAnimaux.get();
    }
    
    /**
     * Avoir accès à la propriété
     * @return lesAnimaux
     */
    public ReadOnlyListProperty<Animal> lesAnimauxProperty() {
        return lesAnimaux;
    }
     
    /**
     * Creation d'une image à partir des fichiers
     */
    File file = new File ("src/ressource/chat.jpg");
    Image image = new Image (file.toURI().toString());
    File file1 = new File ("src/ressource/elephant.jpg");
    Image image1 = new Image (file1.toURI().toString());
    File file2 = new File ("src/ressource/aucune.png");
    Image image2 = new Image (file2.toURI().toString());
    
    /**
     * Constructeur d'un modele animal qui fait appel au constructeur d'un animal
     * Permet d'ajouter des animaux dans la liste
     */
    public ModeleAnimal() {
        lesAnimauxObs.add(new Animal("Chat","Eau, lait, croquette",image));
        lesAnimauxObs.add(new Animal("Elephant","Herbe, fruits, ecorce",image1));
    }
    
    /**
     * Permet d'ajouter des animaux dans la liste
     * Add est utilisé à l'appel d'un bouton qui ne sert plus à grand chose dans l'application
     */
    public void add(){
      lesAnimauxObs.add(new Animal("Nom ","Description ",image2));  
    }
}
