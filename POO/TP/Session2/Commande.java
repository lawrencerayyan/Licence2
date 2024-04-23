package Session2;
import java.util.ArrayList;

public class Commande
{
    private ArrayList<Produit> listeDeProduit = new ArrayList<Produit>();
    private int numero;

    
    public Commande (ArrayList<Produit> d,int ms) {}

    public Commande (ArrayList<Produit> d) {}
    
     public Commande () {}

    public void ajoutProduit(Produit d) 
    {
        this.listeDeProduit.add(d);
    }

    @Override
    public String toString()
    {
        String r = "";
        for ( int i = 0; i < this.listeDeProduit.size(); i++  ) { r+=this.listeDeProduit.get(i).getNom();}
        return r;
    }

}
