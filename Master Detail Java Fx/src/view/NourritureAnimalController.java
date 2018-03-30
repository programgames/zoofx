
package view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utiles.Nourriture;
import model.ModeleNourriture;
import utiles.Vie;

/**
 * Permet de controler le master detail de la nourriture
 * elle controle la listView et les binds
 * les boutons 
 * la selection de la nourriture 
 */
public class NourritureAnimalController {
    
    /**
     * Déclaration des attributs
     */
    @FXML
    private Button CreeNourriture;
    @FXML
    private ListView<Nourriture> listeNourriture;
    @FXML
    private Label animalAssocie;
    @FXML
    private Label nourritureNom;
    @FXML
    private Label detailTexte;
    @FXML 
    private ImageView image;
    @FXML
    private Label viePoint ;
    
    /**
     * Declaration du modele nourriture
     */
    ModeleNourriture nourriture = new ModeleNourriture();
    
    /**
     * Créateur d'un SimpleObjectProperty d'une nourriture
     */
    private final ObjectProperty<ModeleNourriture> leModele = new SimpleObjectProperty<>(nourriture);
        /**
         * getter du modele
         * @return leModele.get()
         */
        public ModeleNourriture getLeModele() {
            return leModele.get();
        }
        
        /**
         * setter du modele
         * @param param 
         */
        public void setLeModele(ModeleNourriture param) {
            leModele.set(param);
        }
        
        /**
         * Acceder à la propriété
         * @return leModele
         */
        public ObjectProperty<ModeleNourriture> leModeleProperty() {
            return leModele;
        }
     
     /**
     * Permet le bind de la listeView et des details
     * Permet d'ajouter les points de vies
     */
    @FXML
    public void initialize() {
        MenuController.setPointVie(new Vie(viePoint.getText()));
        listeNourriture.itemsProperty().bind(nourriture.nourritureProperty());
        // creation de cellule animal 
        listeNourriture.setCellFactory((param) -> {
            return new ListCell<Nourriture>(){
                // permet d'afficher dans la listvieu le nomproperty et le bind permet si il y a des modification
                // dans le textfiel du detail le nom est changer aussi
               @Override
                protected void updateItem(Nourriture item, boolean empty) {
                    super.updateItem(item, empty);
                    if (! empty) {
                        textProperty().bind(item.leTexteProperty());
                        
                    } else {
                        textProperty().unbind();
                        setText("");
                    }
                }  
            };
        });
        // permet d'afficher le detail de la liste view c'est a dire le nom le detail texte et l'image
        listeNourriture.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
            if (oldValue != null) {
                animalAssocie.textProperty().unbindBidirectional(oldValue.animalAssocieProperty());
                nourritureNom.textProperty().unbindBidirectional(oldValue.leTexteProperty());
                detailTexte.textProperty().unbindBidirectional(oldValue.leDetailProperty());
                image.imageProperty().unbindBidirectional(oldValue.uneImageProperty());
            }
            if (newValue != null) {
                animalAssocie.textProperty().bindBidirectional(newValue.animalAssocieProperty());
                nourritureNom.textProperty().bindBidirectional(newValue.leTexteProperty());
                detailTexte.textProperty().bindBidirectional(newValue.leDetailProperty());
                image.imageProperty().bindBidirectional(newValue.uneImageProperty());
                String eau= "Eau";
                if(eau == listeNourriture.getSelectionModel().getSelectedItem().getLeTexte()){
                  viePoint.setText("4");
                }
                
                String lait= "Lait";
                if(lait == listeNourriture.getSelectionModel().getSelectedItem().getLeTexte()){
                     viePoint.setText("5");
                     
                }
                
                String croquette= "Croquette";
                if(croquette == listeNourriture.getSelectionModel().getSelectedItem().getLeTexte()){
                     viePoint.setText("6");
                }
                
                String herbe= "Herbe";
                if(herbe == listeNourriture.getSelectionModel().getSelectedItem().getLeTexte()){
                     viePoint.setText("4");
                }
                
                String fruit= "Fruits";
                if(fruit == listeNourriture.getSelectionModel().getSelectedItem().getLeTexte()){
                      viePoint.setText("5");
                 
                }
                
                String ecorce= "Ecorce";
                if(ecorce == listeNourriture.getSelectionModel().getSelectedItem().getLeTexte()){
                     viePoint.setText("6");
                }
            }
        });
    }
    
    /**
    * Permet de selectionner ca nourriture pour faire augmenter ces points de vies
    */
    @FXML
    public void ClicSelect(){
        System.out.println(viePoint.getText());
        MenuController.setPointVie(new Vie(viePoint.getText()));
        Stage stage = (Stage)CreeNourriture.getScene().getWindow();
        stage.close();
    }
}


