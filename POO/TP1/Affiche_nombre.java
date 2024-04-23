
/**
 * Décrivez votre classe Affiche_nombre ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.Scanner;
public class Affiche_nombre
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    
     
    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir un entier : ");
        int x = scanner.nextInt();
        
        System.out.println("Veuillez saisir un entier : ");
        int y = scanner.nextInt();
        
        
        int r = x + y ;
        int d = x - y ;
        int p = x * y ;
        int div = x / y ;
        int reste = x % y ;
        
        System.out.println( "la somme de "+ x + " + " + y + " est = " + r );
        System.out.println( "la différence, de "+ x + " - " + y + " est = " + d );
        System.out.println( "le Produit, de "+ x + " * " + y + " est = " + p );
        System.out.println( "la div, de "+ x + " / " + y + " est = " + div );
        System.out.println( "le reste, de "+ x + " / " + y + " est = " + reste );
                
    }
    /**
     * Constructeur d'objets de classe Affiche_nombre
     */
    public Affiche_nombre()
    {
        // initialisation des variables d'instance
        
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
   
}
