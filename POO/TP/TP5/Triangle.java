package TP5;

import fr.lacl.cpo.Drawing ;
import fr.lacl.cpo.Toolkit ;
import java.util.Random;

public class Triangle
{
      private double x;
      private double y;
      private double z;
      private double r;
      private double g;
      private double b;
      static Random rand = new Random();
      static Drawing D = new Drawing ("Test",1250,1250);

    public Triangle()
    {
        x = 1 + (double)(Math.random() * 300);
        y = 1 + (double)(Math.random() * 300);
        z = 1 + (double)(Math.random() * 300);
        r = rand.nextDouble();
        g = rand.nextDouble();
        b = rand.nextDouble();
    }
    

    public Triangle(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        r = rand.nextDouble();
        g = rand.nextDouble();
        b = rand.nextDouble();
    }

    public void draw(Drawing d)
    {
      d.setColor(r,g,b);
      d.setWidth(1 + (double)(Math.random() * 10));
      d.point(x,y);
      d.point(z,y);
      d.point(x,z);
      d.setWidth(1 + (double)(Math.random() * 10));
      d.setColor(rand.nextDouble(),rand.nextDouble(),rand.nextDouble());
      d.line(x,y,z,y);
      d.line(z,y,x,z);
      d.line(x,z,x,y);
    }
    public static void main (String[]args)
    {
        Triangle t = new Triangle();
        t.draw(D);
    }
}