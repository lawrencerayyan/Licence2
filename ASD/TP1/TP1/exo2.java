
/**
 * Décrivez votre classe exo2 ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.Random ;
import java.util.Scanner;
public class exo2
{
    // varipublic static void main (String[]args){
public static void main (String[]args){

        int n = 1;
        while (n>0){
            Scanner size = new Scanner(System.in);
            System.out.println("Veuillez choisir la taille du tableau : ");
            int x = size.nextInt();
            int [] tab = new int [x];
            
            random(tab);
            affichage(tab);
            System.out.println("__________");
            /*somme(tab);*/
            /*System.out.println("la Somme en Rec : "+sommeRec(tab,tab.length-1));*/
            /*System.out.println(ELtpairTableau(tab));*/
            /*System.out.println(ELtpairTableauRec(tab,0));*/
            /*System.out.println(OccurrenceTableau(tab,21));*/
            /*affichageInve(tab,2);*/
            n-- ;
        }

        
    } 
    
    public static void somme (int []tab){
        int somme = 0;
        for (int i = 0 ; i< tab.length ; i++){
            somme = somme + tab[i] ;
        }
        System.out.println(somme);
    }
    
    public static int sommeRec (int []tab,int index){
        if (index==0) return tab[0] ;
        else { return sommeRec(tab,index -1 ) + tab[index];
    }
}
    public static int ELtpairTableau(int [] tab ) {
        int somme = 0; 
        for (int i = 0 ; i<tab.length;i++){
            if (tab[i]%2 == 0 ) {
                somme = somme +1;
            } 
        }
        return somme ;
    }
    
    public static int OccurrenceTableau  (int [] tab, int elt ) {
        int somme = 0; 
        for (int i = 0 ; i<tab.length;i++){
            if (tab[i] == elt ) {
                somme = somme +1;
            }
        }
        return somme ;
    }
    //non-terminal
    // si on le veut terminal = on ajout un troisiem parametre et on structure le resultat
    // dans le troisieme 
    public static int Eltpair_tab_rec(int []tab ,int taille ){
        if (taille == 0) return 0;
        return((tab[taille -1 ]%2 ==0 ? 1 : 0 ) + Eltpair_tab_rec(tab, taille -1));
        
    }
    
    public static int ELtpairTableauRec(int [] tab, int index ) {
        int somme = 0; 
        if ( index <=tab.length ){
        
            if (tab[index]%2 == 0 ) {
                somme = somme +1;
            } else{
                somme = 0 ;
            }
        }
        return ELtpairTableauRec(tab,index++); 
    }
    
         public static void random(int[]tab){
        for ( int i = 0 ; i< tab.length ; i++ ){
            tab[i] = (int) (Math.random()*100-1)+1;
        }
    }
    
    public static void   affichage( int[]tab){
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i] + " ");
        }
        System.out.println("");
    }
    
     public static void   affichageRec( int[]tab , int n){
       if (n==0 ) return ;
       affichageRec(tab , n-1 ) ;
       System.out.println( tab[n-1] + " " ) ;
    }
    // si n = 0 on inverse le printage et l'appelle Rec
     public static void   affichageRec2( int[]tab , int n){
       if (n==tab.length ) return ;
       
       System.out.println( tab[n] + " " ) ;
       affichageRec(tab , n+1 ) ;
       
    }
    
    
    
    
    /*public static void   affichageInve( int[]tab,int x){
       for ( int i = tab.length - i - 1 ; i > 0; i--) {
            System.out.println(tab[i] + " ");
        }
        System.out.println("");
    }*/
} 

