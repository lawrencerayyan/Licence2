package TP4;

/**
 * Décrivez votre classe Chainon ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Chainon
{
    private Chainon suiv ;
    private String info ;

    public Chainon (String val, Chainon suiv){
        this.info = val ;
        this.suiv = suiv ;
    }

    public Chainon(String val) {
        info =  val ;
        this.suiv = null; 
    }

    public void Setinfo(String s ){
        this.info= s ;
    }

    public String Getinfo (){
        return info ;
    }

    public Chainon Getsuiv (){
        return suiv ;
    }

    public Chainon Setsuiv(String s ) {
        suiv = new Chainon(s);
        return suiv ; 
    }

}
