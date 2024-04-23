package test;


/**
 * Décrivez votre classe Point ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Point
{
      // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;
    private int y ;
    
    public int GetX(){ return x ;}
    public int GetY(){ return y ;}
    public void SetX(int x){this.x=x ;}
    public void SetY(int y){this.y=y ;}
    
    public Point(int x , int y){
        //this(x,y);
        this.x = x ;
        this.y = y ;
    }
    
    public static void main (String[] args ){
        Point p = new Point (3,2);
        Point q = p ;
        Point r = new Point (3,2);
        q.x=5;
        r.x=p.x;
        p.x=10;
        System.out.println(p.x+" " + q.x + " " + r.x ) ;
    }
}
