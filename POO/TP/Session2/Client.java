package Session2;
import java.util.ArrayList;


public class Client 
{
    private ArrayList<Commande> commandes = new ArrayList<Commande>();
    private final int  maxSize = 20;
     
    public void ajoutCommande( Commande d) throws  CommandeException

    {

        if ( this.commandes.size( ) == maxSize ) throw new CommandeException();

        this.commandes.add( d );

    }
    /*
    public ArrayList<Produit> listeProduitsAlimentaires(Produit a )
    {
        ArrayList<Produit> Alimant = new ArrayList<Produit>();
        for ( int i = 0; i < this.commandes.size(); i++  )
        {
            if (Produit.compare( this.commandes.get(i), a) )Alimant.add( this.commandes.get(i));
        }
        return Alimant ;
    }*/

}
