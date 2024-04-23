package TP3;


/**
 * Décrivez votre classe Marionnettiste ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Marionnettiste
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    Personnage personne ;
    
    public void attaquer(Personnage ennemy){
    personne.attaque(ennemy);
    }

    /**
     * Constructeur d'objets de classe Marionnettiste
     */
    public Marionnettiste(Personnage personne )
    {
        // initialisation des variables d'instance
       this.personne = personne ;
    }

    
}
