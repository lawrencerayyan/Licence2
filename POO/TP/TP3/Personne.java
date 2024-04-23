package TP3;


/**
 * Décrivez votre classe Personne ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Personne
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private final String nom ;
    private final String Date ;

    /**
     * Constructeur d'objets de classe Personne
     */
    public Personne(String nom, String Date)
    {
        // initialisation des variables d'instance
        this.nom = nom ;
        this.Date = Date ;
    }
    
    public String getName() {
        return nom;
    }


    public String getanniversaire() {
        return Date;
    }
    
}
