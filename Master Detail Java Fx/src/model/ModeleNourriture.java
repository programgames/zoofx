package model;

import java.io.File;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import utiles.Nourriture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 * Permet de gérer l'ajoue dans la liste des nourritures
 */
public class ModeleNourriture {
    
    /**
    *  Création d'une nouvelle liste observable vide. 
    */
    private ObservableList<Nourriture> nourritureObs = FXCollections.observableArrayList();
    /**
    *  Création d'une simpleListeProperty de nourriture 
    */
    private final ListProperty<Nourriture> nourriture = new SimpleListProperty<>(nourritureObs);
    /**
     * getter de la liste nourriture
     * @return nourriture.get()
     */
    public ObservableList<Nourriture> getNourriture() {
        return nourriture.get();
    }
    
    /**
     * Avoir accès à la propriété 
     * @return nourriture
     */
    public ReadOnlyListProperty<Nourriture> nourritureProperty() {
        return nourriture;
    }
    
    /**
     * Création d'une image à partir des fichiers
     */
    File file = new File ("src/ressource/eau.jpg");
    Image image = new Image (file.toURI().toString());
    File file1 = new File ("src/ressource/lait.jpg");
    Image image1 = new Image (file1.toURI().toString());
    File file2 = new File ("src/ressource/croquette.jpg");
    Image image2 = new Image (file2.toURI().toString());
    File file3 = new File ("src/ressource/herbe.jpg");
    Image image3 = new Image (file3.toURI().toString());
    File file4 = new File ("src/ressource/fruit.jpg");
    Image image4 = new Image (file4.toURI().toString());
    File file5 = new File ("src/ressource/ecorce.jpg");
    Image image5 = new Image (file5.toURI().toString());
          
    /**
     * Constructeur d'un modele nourriture qui fait appel au constructeur d'une nourriture
     * Permet d'ajouter de la nourriture dans la liste
     */
    public ModeleNourriture() {
        nourritureObs.add(new Nourriture("Chat","Eau","1",image));
        nourritureObs.add(new Nourriture("Chat","Lait","2",image1));
        nourritureObs.add(new Nourriture("Chat","Croquette","3",image2));
        nourritureObs.add(new Nourriture("Elephant","Herbe","1",image3));
        nourritureObs.add(new Nourriture("Elephant","Fruits","2",image4));
        nourritureObs.add(new Nourriture("Elephant","Ecorce","3",image5));
        
    }
}
