package TP5;

import fr.lacl.cpo.Drawing ;
import fr.lacl.cpo.Toolkit ;
import java.util.Random;

public class Maison
{
    private double c,d,e,f,h,i;//coordonnées
    private double r,g,b;//couleur
    static Random rand = new Random();
    static Drawing D = new Drawing ("Test",1250,1250);

    public Maison(double c, double d, double e,double f,double h, double i)
    {
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.h = h;
        this.i = i;
        r = rand.nextDouble();
        g = rand.nextDouble();
        b = rand.nextDouble();
    }
    public void draw(Drawing D)
    {
      D.setColor(r,g,b);
      D.setWidth(1 + (double)(Math.random() * 10));
      D.point(c,d);
      D.point(f,d);
      D.point(c,e);
      D.point(f,e);
      D.point(h,i);
      D.setWidth(1 + (double)(Math.random() * 10));
      D.setColor(rand.nextDouble(),rand.nextDouble(),rand.nextDouble());
      D.line(c,d,f,d);
      D.line(f,d,f,e);
      D.line(f,e,c,e);
      D.line(c,d,c,e);
      D.line(c,d,h,i);
      D.line(f,d,h,i);
    }
    
    public static void main (String[]args)
    {
        Maison m = new Maison(300,350,400,500,400,230);
        m.draw(D);
    }
}