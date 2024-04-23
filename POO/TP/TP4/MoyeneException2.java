package TP4;

/**
 * Décrivez votre classe MoyeneException2 ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MoyeneException2
{

    public static void main(String[] argv)
    {
        if (argv.length < 0)
        {
            System.out.println("Il n'y a pas d'arguments");
            System.exit(1);
        }
        Integer moyenne = moyenne(argv);
        if (moyenne != null) {
        System.out.println("La moyenne est " + moyenne);}
        else {System.out.println("erreur");}
    }

    public static Integer moyenne(String[] argv)
    {
        int somme = 0;
        int cpt = 0;
        for (int i = 0; i < argv.length; i++)
        {
            try{
                somme += Integer.parseInt(argv[i]);
                cpt++;
            }
            catch(NumberFormatException e){
                System.out.println("Exception incorrect format " + e);
            }
        }

        
        try{
        return somme / cpt;
        }
        catch(ArithmeticException e){
        System.out.println("Division par Zero " + e); 
        }
        return null;

        //return somme / cpt;
    }
}
// { "1","2","a","6"}
