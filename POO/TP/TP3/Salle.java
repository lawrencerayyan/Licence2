package TP3;


/**
 * Décrivez votre classe Salle ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Salle
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int capacite ;

    /**
     * Constructeur d'objets de classe Salle
     */
    public Salle(int capacite)
    {
        // initialisation des variables d'instance
        this.capacite = capacite ;
    }
    
    public Salle ( Salle s ){
    this.capacite = s.capacite;
    }
     public int getcapacite() {
        return capacite;
    }
}
