package TP1;


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
    public Point (Point p ) {
    x = this.x ;
    y = this.y ;
    }
    @Override
    public boolean equals(Object obj){
    if (this == obj)
    return true ;
    if( obj == null )
    return false ;
    if (this.getClass() != obj.getClass())
    return false ;
    Point other = (Point)obj;
    return(this.x == other.x && this.y == other.y);
}
}
