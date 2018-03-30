
package utiles;

/**
 * Permet de créer des scores
 */
public class FabriqueScore {

    /**
     * Permet de fabriquer un score
     * @return score()
     */
    public static IScore fabriqueScore(){
       return new Score();
    }
    /**
     * Permet de construire un score avec des parametres 
     * @param nom
     * @param VScore
     * @return Score(nom,VScore)
     */
    public static IScore fabriqueScore(String nom, int VScore) throws ScoreException {
        return new Score(nom,VScore);
    }
}