package TP3;


/**
 * Décrivez votre classe Batiments ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Batiments
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Salle [] salle ;
    private int numero ;
    

    /**
     * Constructeur d'objets de classe Batiments
     */
    public Batiments( Salle [] salle ,int numero)
    {
        // initialisation des variables d'instance
        salle = new Salle [salle.length];
        for(int i = 0 ; i< salle.length; i++ ){
        
        salles[i]= new Salle (salle[i]) ; 
    } 
        this.numero = numero ;
    }

   
}
