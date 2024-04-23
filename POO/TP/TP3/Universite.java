package TP3;


/**
 * Décrivez votre classe Universite ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Universite
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private final Batiments [] t ;
    private final Personne personne ;

    /**
     * Constructeur d'objets de classe Universite
     */
    public Universite(Batiments [] t, Personne personne)
    {
        // initialisation des variables d'instance
        personne = new Personne ("personne", "né le 1975");
        t = new Batiments (t[t], 200);       
    }
    
    public Personne getpersonne() {
        return personne;
    }

    public Batiments[] getBatiments() {
        return t;
    }
    
}
