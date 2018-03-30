
package persistance.persXML;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utiles.DataManager;
import utiles.IScore;

/**
 * Chargement et Sauvegarde d'un nouveau fichier sous forme d'objet
 */
public class XMLDataManager implements DataManager {

    /**
     * Permet d'enregistrer les scores
     * @return result
     */
    @Override
    public List<IScore> chargeScore() {
        List<IScore> result = null;
        try (XMLDecoder ois = new XMLDecoder(new FileInputStream("score.xml"))) {
           result = ((ArrayList<XMLScore>) ois.readObject()).stream().map(n->n.getModel()).collect(Collectors.toList());
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Permet de reconstruire le modele grâce aux données brute que nous avons créé à la serialisation
     * @param score 
     */
    @Override
    public void sauveScore(List<IScore> score) {
        System.out.println("taille " + score.size());
        try (XMLEncoder oos = new XMLEncoder(new FileOutputStream("score.xml"))) {
            List<XMLScore> bn = score.stream().map(n -> new XMLScore(n)).collect(Collectors.toList());
            oos.writeObject(bn);
        }
        catch (IOException e) {
            e.printStackTrace();
        }      
    }
}