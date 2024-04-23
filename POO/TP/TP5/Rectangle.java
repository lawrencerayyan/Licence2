package TP5;

import fr.lacl.cpo.Drawing ; 


/**
 * Décrivez votre classe Rectangle ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Rectangle 
{
    public static void main(String[] args){
    Drawing d= new Drawing("test",500,500);
    d.setColor(0.10,1.00,0.25);
    d.setWidth(5.5);
    // line(x1,y1,x2,y2);
    d.line(50,50,50,450);
    d.line(50,50,250,50);
    d.line(250,50,250,450);
    d.line(50,450,250,450);
    }

}
