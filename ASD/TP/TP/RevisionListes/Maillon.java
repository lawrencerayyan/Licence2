package RevisionListes;


/**
 * Décrivez votre classe Noeud ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Maillon
{
    int info;
    Maillon succ;
    Maillon pred;
    public Maillon (){
        
    }
    public Maillon(int m){
        this.info=m;
        this.succ=null;
        this.pred=null;
    }
    @Override
    public String toString(){
        return this.info +"";
    }
}
