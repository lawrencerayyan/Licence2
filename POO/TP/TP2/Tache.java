package TP2;


/**
 * Décrivez votre classe Tache ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Tache
{
    public long DateLimite;
    public String Description ;
    
    public Tache(long date ,String Description )
    {
        this.DateLimite = date +System.nanoTime();
        this.Description = Description ;
    }
    
    public boolean estFini (){
        return System.nanoTime() > DateLimite;
    }
    public String printTache () {
        return String.format("-> %s - temps restant %fs", Description,tempsRestantenscd());
    }
    public double tempsRestantenscd(){
        return (double)(DateLimite - System.nanoTime())/(double)1_000_000_000L;
    }
    public double tempsRestantenmin(){
        return tempsRestantenscd()/60;
    }
    public double tempsRestantenh(){
        return tempsRestantenmin()/60;
    }
    
    public double tempsRestantenjour(){
        return tempsRestantenh()/24;
   
}

}
