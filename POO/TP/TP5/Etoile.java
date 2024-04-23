package TP5;

/**
 * Décrivez votre classe Etoile ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import fr.lacl.cpo.Toolkit;
import fr.lacl.cpo.Drawing ; 
public class Etoile
{
    public static void main(String[] args){
        Drawing d= new Drawing("test",500,500);
        d.setColor(0.10,1.00,0.25);
        d.setWidth(5.5);
        // int i = 2;
        int xCentre = 200;
        int rayon = 100 ;
        int yCentre = 200 ;
        int j = 0 ;
        for(int i = 0 ; i<= 4 ; i++ ){
            /* d.point(xCentre+rayon*Math.cos(i*2*Math.PI/5)
            ,yCentre+rayon*Math.sin(i*2*Math.PI/5));*/

            d.line(xCentre+rayon*Math.cos(i*2*Math.PI/5)
            ,yCentre+rayon*Math.sin(i*2*Math.PI/5),
                xCentre+rayon*Math.cos((i+2)*2*Math.PI/5)
            ,yCentre+rayon*Math.sin((i+2)*2*Math.PI/5));
        }
        d.clear();
        while(true){
            for(int i = 0 ; i<= 4 ; i++ ){
                d.line(xCentre+rayon*Math.cos((i*2*Math.PI/5)+0.2*j)
                ,yCentre+rayon*Math.sin((i*2*Math.PI/5)+0.2*j),
                    xCentre+rayon*Math.cos(((i+2)*2*Math.PI/5)+0.2*j)
                ,yCentre+rayon*Math.sin(((i+2)*2*Math.PI/5)+0.2*j));
            }
            j++;
            Toolkit.sleep(100);
            d.clear();
        }
    }
}
