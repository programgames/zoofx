
package utiles;

import java.util.List;

/**
 * Interface qui permet de gérer la persistance
 */
public interface DataManager {

   /**
    * Recupère la liste des scores chargé en memoire
    */
    public List<IScore> chargeScore();

    /**
     * Permet de sauvegarder les données
     * @param score
     */
    public void sauveScore(List<IScore> score);

}