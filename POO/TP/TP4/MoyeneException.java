package TP4;

/**
 * Décrivez votre classe MoyeneException ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MoyeneException
{

    public static void main(String[] argv)
    {
        
        try{ 
            int moyenne = moyenne(argv);
            System.out.println("La moyenne est " + moyenne);
        }
        catch(NumberFormatException e){
            System.out.println("Exception incorrect format " + e); 
            
        }
        catch(ArithmeticException e){
            System.out.println("Division par Zero " + e); 
            
        }finally{
            System.out.println("erreur de calcule de moyenne");
        }
        
        
    }

    public static int moyenne(String[] argv) throws NumberFormatException, 
    ArithmeticException
    {
        int somme = 0;
        int cpt = 0;
        for (int i = 0; i < argv.length; i++)
        {
            somme += Integer.parseInt(argv[i]);
            cpt++;
        }
        return somme / cpt;
    }
} 

