package Session2;
import java.util.Date;
import java.util.*;

class Produit <T>
{
    private String Nom ;
    private int pérem;
    /*private T ALIMENTAIRE,MAISON,VETEMENT;*/
    public Produit(String Nom , int pérem){
        this.Nom = Nom ; this.pérem = pérem ;}

    public String getNom(){return this.Nom;}

    public int getDate(){return this.pérem ;}

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ( obj == null ||this.getClass() != obj.getClass()) return false ;
        
        Produit o1 =(Produit) obj ;
        return this.Nom.equals(o1.Nom)
        && this.pérem == o1.pérem
       /* && this.ALIMENTAIRE == o1.ALIMENTAIRE 
        && this.MAISON == o1.MAISON 
        && this.VETEMENT == o1.VETEMENT*/ ;
    }
}
