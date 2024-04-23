
import java.util.Random ;
import java.util.Scanner;
public class exo1
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre

    public static void main (String[]args){

        int n = 1;
        while (n>0){
            Scanner size = new Scanner(System.in);
            System.out.println("Veuillez choisir la taille du tableau : ");
            int x = size.nextInt();
            int [] tab = new int [x];
            
            random(tab);
            /*affichage(tab);*/
            System.out.println("__________");
            affichageRec(tab,0);
            System.out.println("__________");
            /*affichageInve(tab);*/
            affichageInveRec(tab,tab.length-1);
            n-- ;
        }

        
    } 

    public static void ex1( int n , int[]tab ){

        for (int i= 0 ; i<tab.length ; i++ ) {
            Scanner size = new Scanner(System.in);
            System.out.println("Veuillez remplir : ");
            n = size.nextInt();
            tab[i] = n ;

        }

    }
    
    public static void random(int[]tab){
        // Random r = new Random()
        for ( int i = 0 ; i< tab.length ; i++ ){
            //tab[i]= r.nextInt(100);
            tab[i] = (int) (Math.random()*100-1)+1;
        }
    }

    public static void   affichageInve( int[]tab){
        for (int i = tab.length - 1 ; i >= 0; i--) {
            System.out.println(tab[i] + " ");
        }
        System.out.println("");
    }

    public static void   affichageRec( int[]tab, int indexe){
        if( indexe != tab.length){
            System.out.println(tab[indexe]+ " ");
            indexe++;
            affichageRec(tab,indexe);
        }

    }

    public static void   affichageInveRec( int[]tab, int indexe){
        if(indexe >= 00){
            System.out.println(tab[indexe]+ " ");
            indexe--;
            affichageRec(tab,indexe);
        }

    }

    public static void   affichage( int[]tab){
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i] + " ");
        }
        System.out.println("");
    }

    public exo1()
    {
        // initialisation des variables d'instance
        ;
    }
}

/**
 * Un exemple de méthode - remplacez ce commentaire par le vôtre
 *
 * @param  y   le paramètre de la méthode
 * @return     la somme de x et de y
 */

