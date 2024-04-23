package TP5;

 import fr.lacl.cpo.Drawing ;

/**
 * La class Point est pour présenter un point .
 * elle contient les coordonnées, la couleur et l'epaisseur
 * @author (AL RAYYAN Lawrence)
 * @version (18/11/2022 à 14h00)
 */
public class Point
{
    // les coordonnées de point x et y 
    // initialisation des variables d'instance
    private double x;
    private double y;
    private double r, g, b;
    private double epaisseur;
    static Drawing D = new Drawing ("Test",1250,1250);
   
    /**
     * Constructeur d'objets de classe Point
     */
    public Point(double x, double y, double r,double g,double b, double epaisseur){
        // initialisation des variables d'instance
        this.x = x;
        this.y = y;
        this.r=r;
        this.g=g;
        this.b=b;
        this.epaisseur = epaisseur;
    }
    /**
     * Initialiser un point à l'origine
     */
    
     public void draw(Drawing d){
        d.setColor(r,g,b);
        d.setWidth(epaisseur);
        d.point(x,y);
    }

    /**
     * Initialiser un point à x et y
     */
    public Point(double x , double y) {
        this.x=x ; this.y = y ;
    }

    /**
     * Methode qui affecte la valeur de son paramètre 
     * au Point this.
     */    
    public void setX(int p) {
        x = p;
    }

    public void setY(int p) {
        y = p;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    
    public static void main(String[]args)
        {
            Point p1 = new Point(500,500,0.5,1,1,10);
            Point p2 = new Point(200,300,0.5,1,1,10);
            Point p3 = new Point(300,500,0.5,1,1,10);
            p1.draw(D);
            p2.draw(D);
            p3.draw(D);
        }
}
