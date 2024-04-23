package test;


public class Cc1
{
    public Point p1,p2;
    public Cc1 (Point p1, Point p2 ){
        this.p1 = p1 ;
        this.p2 = p2 ;
    }
    public String toString(){
        return p1 + "->" + p2 ;
    }
    static void main (){
    Point p1= new Point(4,5);
    Point p2= new Point(14,15);
    Point p3= new Point(24,25);
    Cc1 l1 = new Cc1 (p2 , p1 );
    Cc1 l2 = new Cc1 (p2 , p3 );
    l1.p1.SetX(12);
    l1.p1.SetY(13);
    System.out.println(l1);
    System.out.println(l2);
    
    }
}
