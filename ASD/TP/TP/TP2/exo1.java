package TP2;


public class exo1
{
    
    public exo1()
    {
        
        }
    public static int somme_recusif(int n ){
        if (n == 0 ){
            return 0;
        }
        else{
            return  n + somme_recusif(n-1) ;
        }
    }
       
    public static int somme_recusif_bis(int n, int res ){
          if (n>0 ){
            return somme_recusif_bis(n-1, n + res) ;
        }
        else{
            return res ;
        }  
        
        }
        
}
