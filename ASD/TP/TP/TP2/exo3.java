package TP2;


public class exo3
{

    public int recherche_max_recusif(int [] tab , int n)
    {
        int m = tab[n-1];
     
         
        if(n == 1) return tab[0] ;
        else if (m<=tab[n-2]) return recherche_max_recusif(tab, n-1);
        else return m;
        
    }
    
    public static int somme_recusif(int[]tab , int n ) {
        
        if (n == 0 ){
            return 0;
        }
        else{
            return tab[n] + somme_recusif(tab , n-1 ) ;
        }
    }
       
    public static int somme_recusif_terminal(int[]tab , int n,int res ) {
        if (n == 0 ){
            return res;
        }
        else{
            return somme_recusif_terminal(tab , n-1, res + tab[n] ) ;
        }
    }
}
