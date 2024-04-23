package TP4;


/**
 * Décrivez votre classe UtiliseRacine ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class UtiliseRacine
{
   public static void main(String[] argv)
    {

        Racine extracteur = new Racine(0.01);
        double operande = (Double.valueOf(argv[0])).doubleValue(); double valeurRacine;
        try{
            valeurRacine = extracteur.racine(operande);
            System.out.println(valeurRacine);
            System.out.println("precision " + extracteur.getPrecision() + " , erreur =" +  (valeurRacine - Math.sqrt(operande)));
            extracteur.setPrecision(0.00001);
            valeurRacine = extracteur.racine(operande);
            System.out.println(valeurRacine);
            System.out.println("precision " + extracteur.getPrecision() + " , erreur =" +  (valeurRacine - Math.sqrt(operande)));
        } 

        catch(NegatifException e){
            System.out.println("erreur de calcule "+e);
        }
    }
}
