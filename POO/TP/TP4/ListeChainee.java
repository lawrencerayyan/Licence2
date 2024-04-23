package TP4;

/**
 * Décrivez votre classe ListeChainee ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ListeChainee
{
    private Chainon first ;
    private Chainon last ;
    private int taille = 0 ;

    public void insere (String x)throws IllegalArgumentException{
        if(x.equals(null))throw new IllegalArgumentException("l'élément inséré ne peut être null") ;
        else if (first == null ){new Chainon (x); }
        else{last = first ;
            first = new Chainon(x); 
        }
    }

    public void ajouter (String y) throws IllegalArgumentException{
        if(y.equals(null)) throw new IllegalArgumentException("l'élément inséré ne peut être null");
        else if(first == null ) { first = new Chainon(y) ;}
        else if (first.Getsuiv() == null ) { last = first.Setsuiv(y);}
        else {Chainon A = last.Setsuiv(y);
            last = A ;}
    }

    public String supprime(){
        // il faut traiter les cas particulier si y'a 0 element ou 1 ou 2 ...
        if(first.Getsuiv() == null ) {return null ;}
        else {
            Chainon temp = first ;
            first = first.Getsuiv();
            return temp.Getinfo();
        }
    }

    public String premier (){
        return first.Getinfo();}

    public String dernier (){
        return last.Getinfo();
    }
}
