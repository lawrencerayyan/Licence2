package TP3;


/**
 * Décrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Main
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    

    public static void main(String[] args ) {
    Personnage p0 = new Personnage ("Hulk", new Arme ("poigne" , 100), new Arme ("coteau" , 150) );
    Personnage p1 = new Personnage ("superman", new Arme ("laser", 120), new Arme("T", 200));
    
    System.out.println(p0.niveauDeVie);
    
    p1.attaque(p0);
    System.out.println(p0.niveauDeVie);
    p1.attaque(p0);
    System.out.println(p0.niveauDeVie);
    p1.attaque(p0);
    p1.attaque(p0);
    p1.attaque(p0);
    p1.attaque(p0);
    
    System.out.println(p0.niveauDeVie);
    
    }
    
    /**
     * Constructeur d'objets de classe Main
     */
    public Main()
    {
        // initialisation des variables d'instance
       
    }

    
}
