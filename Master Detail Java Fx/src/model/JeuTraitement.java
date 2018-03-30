package model;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import utiles.NomAnimal;
import utiles.Score;
import utiles.Vie;
import view.DetailAnimauxController;
import view.MenuController;

/**
 * Permett de gérer la fenêtre du jeu
 */
public class JeuTraitement  implements Runnable{
    
    /**
     * Définition des variables
     */
    int posX =  240;
    static final int posY = 350;
    int posXN = 114;
    int posYN =  20;
    int vie = 3;
    int finis = 0;
    public static Stage fenetrejeu;
    /**
     * getteur du NomAnimal pour récupérer le nom de l'animal
     */
    NomAnimal nomAnimal = DetailAnimauxController.getNomAnimal();
    /**
     * getteur du PointVie pour recupérer ca vie
     */
    Vie viePoint = MenuController.getPointVie();
    
    /**
     * Action qui permet de ce lancer quand on lance le controller
     */
    @Override
    public void run(){    
    }
    
    /**
     * Fenêtre de jeu
     * But: ramasser la nouritture avec les touches gauche et droite du clavier
     * @param partie
     * @return partie
     */
    public Score initialisation(Score partie){
        vie= Integer.parseInt(viePoint.getVie());
        partie.setLeScore(0);//on remet le score a zero  a chaque partie
        fenetrejeu = new Stage();
        fenetrejeu.setTitle( "Fenetre du jeu" );
        Group root = new Group();
        Scene sceneJeu = new Scene( root );
        fenetrejeu.setScene( sceneJeu );
        Canvas canvas = new Canvas( 512, 512 );
        root.getChildren().add( canvas );
        Image fond = new Image("/ressource/fond.jpg");
        Image nourriture = new Image("/ressource/fruitjeu.png");
        Image animalchat = new Image("/ressource/chatjeu.png");
        Image animalelephant = new Image("/ressource/elephantjeu.png");
        final long startNanoTime = System.nanoTime();

        ArrayList<String> input = new ArrayList<String>();
        sceneJeu.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    if ( !input.contains(code) )
                        input.add( code );
                }
            });
        
            sceneJeu.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    input.remove( code );
                }
            });  
        GraphicsContext gc = canvas.getGraphicsContext2D();
        new AnimationTimer(){
            public void handle(long currentNanoTime){
                gc.clearRect(0, 0, 512,512);
                gc.drawImage(fond,0,0);
                gc.fillText("Score : " + partie.getScoreProperty(), 400,50);
                gc.fillText("Vie : " + vie, 400,20);
                /**
                 gc.fillText("Temps : " + (int)((currentNanoTime - startNanoTime) / 1000000000.0),400,10);
                 gc.fillText("posX: " + posX, 400,70);
                 gc.fillText("posXN: " + posXN, 400,90);
                 gc.fillText("posX + 120: " + (posX + 120), 400,110);
                 gc.fillText("posXN - 60 : " + (posXN - 60 ), 400,130);   
                **/
                posYN +=4;
                if(posYN > posY){
                    posYN = 20;
                    if(posXN - 60 <= posX && (posXN + 60) >= posX){
                        partie.setLeScore(partie.getScoreProperty() +1 );
                    }
                    else{
                        vie -=1;
                        if(vie == 0){
                            final Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Fin de la partie"); 
                            alert.setHeaderText("Vous avez perdu");
                            alert.setContentText("Vous avez terminé la partie avec un score de " + partie.getScoreProperty());
                            finis = 1;
                            alert.show();
                            this.stop();
                            fenetrejeu.close();
                        }
                    }
                    posXN = 0+ (int)(Math.random() * ((490 - 0) + 1));
                }
                if (input.contains("LEFT")){
                    if(posX > 20)
                    posX-=4;
                }
                if (input.contains("RIGHT")){
                    if (posX < 470)
                    posX +=4;
                }
                if("Chat".equals(nomAnimal.getNomAnimal())){
                    gc.drawImage(animalchat,posX, posY);
                }
                if("Elephant".equals(nomAnimal.getNomAnimal())){
                    gc.drawImage(animalelephant,posX, posY);
                }
                gc.drawImage(nourriture,posXN,posYN);
            }
        }.start();
        fenetrejeu.showAndWait();
        fenetrejeu.close();
        return partie;
    }
}
