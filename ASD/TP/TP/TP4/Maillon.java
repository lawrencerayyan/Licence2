package TP4;


/**
 * Décrivez votre classe Maillon ici.
 *
 * @author (lawrence)
 * @version (09/11/2022 12:44:05)
 */
public class Maillon
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int info ;
    private Maillon next ;
    // private Maillon precedent ;

    /**
     * Constructeur d'objets de classe Maillon
     */
    public Maillon(int val)
    {
        // initialisation des variables d'instance
        this.info = val ;
        this.next= null ;
    }
    
    public Maillon(int val, Maillon next)
    {
        // initialisation des variables d'instance
        this.info = val ;
        this.next= next;
        // this.precedent = null;
    }

    /**
     * 
     * Les accesseur
     */
    
    public Maillon getNext (){ return next ;  }
    public int getInfo(){ return info ; }
    public void setNext (Maillon next){this.next = next ;}
    @Override 
    public String toString(){return "->" + this.info ;}
}
