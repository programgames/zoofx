package view;


import java.io.File;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import model.ModeleAnimal;
import utiles.Animal;
import utiles.NomAnimal;

/**
 * Permet de gérer le master detail d'animaux c'est à dire les personnages du jeu
 * elle controle la listView et les binds
 * les boutons 
 * la selections du personnages
 */

public class DetailAnimauxController {
    
    /**
     * Déclaration des attributs
     */
    @FXML
    private ListView<Animal> listeDesAnimaux;
    @FXML
    private Label detailTexte;
    @FXML
    private TextField nom ;
    @FXML 
    private Button buttonJouer;
    @FXML 
    private Button son; 
    @FXML 
    private Button SelectPerso;
    @FXML
    private Button fermeJeu; 
    @FXML 
    private ImageView image;
    @FXML 
    private MediaView mediaview;
    
    private MediaPlayer mediaplayer;
    
    private Media media;
    
    private Image img_play;
    
    private Image img_pause;
     
    /**
     * Declaration d'un nomAnimal static
     */
    private static NomAnimal nomAnimal;
    /**
     * getter d'un nomAnimal
     * @return nomAnimal
     */
    public static NomAnimal getNomAnimal(){
        return nomAnimal;
    }
    
    /**
     * setter d'un nomAnimal
     * @param valeur 
     */
    public static void setNomAnimal(NomAnimal valeur){
        nomAnimal = valeur;
    }
    
    /**
     * Déclaration du modele Animal
     */
    ModeleAnimal lesAnimaux = new ModeleAnimal();
    
    /**
    *  Création d'une SimpleObjectProperty d'animaux
    */
    private final ObjectProperty<ModeleAnimal> leModele = new SimpleObjectProperty<>(lesAnimaux);
        /**
         * getter du modele 
         * @return leModele.get()
         */
        public ModeleAnimal getLeModele() {
            return leModele.get();
        }
        
        /**
         * setter du modele
         * @param param 
         */
        public void setLeModele(ModeleAnimal param) {
            leModele.set(param);
        }
        
        /**
         * Acceder à la propriété
         * @return leModele
         */
        public ObjectProperty<ModeleAnimal> leModeleProperty() {
            return leModele;
        }
        
    /**
     * Permet le bind de la listeView et des details
     * Permet d'afficher un bouton image qui permet d'écouter le son de l'animal
     */
    @FXML
    public void initialize(){
        // creation de cellule animal 
        listeDesAnimaux.setCellFactory((param) -> {
            return new ListCell<Animal>(){
                // permet d'afficher dans la listview le nomproperty et le bind permet si il y a des modification
                // dans le textfiel du detail le nom est changer aussi
               @Override
                protected void updateItem(Animal item, boolean empty) {
                    super.updateItem(item, empty);
                    if (! empty) {
                        textProperty().bind(item.leNomProperty());
                    } else {
                        textProperty().unbind();
                        setText("");
                    }
                }  
            };
        });
  
        // permet d'afficher le detail de la liste view c'est a dire le nom le detail texte et l'image
        listeDesAnimaux.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
            if (oldValue != null) {
                detailTexte.textProperty().unbindBidirectional(oldValue.leTexteProperty());
                nom.textProperty().unbindBidirectional(oldValue.leNomProperty());
                image.imageProperty().unbindBidirectional(oldValue.uneImageProperty());
            }
            if (newValue != null) {
                detailTexte.textProperty().bindBidirectional(newValue.leTexteProperty());
                nom.textProperty().bindBidirectional(newValue.leNomProperty());
                image.imageProperty().bindBidirectional(newValue.uneImageProperty());
                
                String nomchat = "Chat";
               if(nomchat == listeDesAnimaux.getSelectionModel().getSelectedItem().getLeNom()){
               
                File file = new File ("src/ressource/chat.mp3");
                media = new Media (file.toURI().toString());
               }
                String nomelephant = "Elephant";
               if(nomelephant == listeDesAnimaux.getSelectionModel().getSelectedItem().getLeNom()){
               
                File file = new File ("src/ressource/elephant.mp3");
                media = new Media (file.toURI().toString());
               }
                mediaplayer = new MediaPlayer(media);
                File file1 = new File ("src/ressource/pause.png");
                img_pause = new Image(file1.toURI().toString());
                File file2 = new File ("src/ressource/play.png");
                img_play = new Image (file2.toURI().toString());
                son.setGraphic(new ImageView(img_play));

                son.setCursor(Cursor.HAND);
                //Quand on clique sur le bouton play/pause, on démarre ou on arrête la vidéo
                son.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent me){
                        if(mediaplayer.getStatus() == MediaPlayer.Status.valueOf("PLAYING")){//pause
                            son.setGraphic(new ImageView(img_play));
                            mediaplayer.pause();
                        }
                        else{//play
                            son.setGraphic(new ImageView(img_pause));
                            mediaplayer.play();
                        }
                    }
                });
            }
        });  
    }
    
    /**
     * Permet d'ajoueter un personnage dans la liste d'animaux
     * elle ne sert plus a grand chose dans le contexte du jeu
     */
    @FXML
    public void ClicCreerperso(){
                lesAnimaux.add();
    }
    
    /**
     * Permet de supprimer un personnage dans la liste des animaux
     */
    @FXML
    public void ClicSuppPerso(){
        int selectedIndex = listeDesAnimaux.getSelectionModel().getSelectedIndex();
        listeDesAnimaux.getItems().remove(selectedIndex);
    }
    
    /**
     * Permet de sélectionner un personnage c'est à dire un animal qui
     * sera le personnage du jeu
     */
    @FXML
    public void ClicSelect(){
        System.out.println(nom.getText());
        DetailAnimauxController.setNomAnimal(new NomAnimal(nom.getText()));
        Stage stage = (Stage)SelectPerso.getScene().getWindow();
        stage.close();
       }
}

