package utiles;

/**
 * Permet d'afficher une exception en console
 * @author julie
 */
public class ScoreException extends Exception{ 
  public ScoreException (){
    System.out.println("Score negatif!");
  }  
}