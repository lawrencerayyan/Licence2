package TP3;


/**
 * Décrivez votre classe Arme ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Arme
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    String nom ;
    int force ;
    int nombre_utilisation ;
    
    // public String Getnom(){
        // return this.nom ;
    // }
    
    public Arme (String nom,int force ){
        this.nom = nom ;
        this.force = force ;
        this.nombre_utilisation = 7 ;
    }
    
    public int getForce(){
    return this.force; 
    }
    
    public int Getnombre_utilisation(){
    return this.nombre_utilisation;
    }
    
    public void Setnombre_utilisation(int nombre_utilisation ){
        this.nombre_utilisation = nombre_utilisation ;
    }
    
    public String toString(){
    return ( "L'arme :" + this.nom + ", sa force :" + this.force + ", le nombre de l'utiistation "
    + this.nombre_utilisation ) ;
    }
    
    /**
     * Constructeur d'objets de classe Arme
     */
    public Arme()
    {
        // initialisation des variables d'instance
       
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    
}
