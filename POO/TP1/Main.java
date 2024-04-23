
/**
 * Décrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.ArrayList ;
public class Main
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    public static void main (String[]args) {
    /*
    Point p = new Point(5,4);
    p.SetY(6);
    System.out.println(p.GetX()+" , "+ p.GetY()); 
    */
    Point p1 = new Point(1,2);
    Point p2 = p1;
    Point p3 = new Point(1,2);
    ArrayList<Point> list = new ArrayList();
    list.add(p1);
    
    System.out.println(list.indexOf(p2));
    System.out.println(list.indexOf(p3)); 
}
}
