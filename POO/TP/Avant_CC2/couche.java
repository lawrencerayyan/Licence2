package Avant_CC2;


/**
 * Décrivez votre classe couche ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class couche
{
   public static int tailleCouche(Arbre a , int n){
        return tailleCouche(a.racine , n,0);
    }
    private static int tailleCouche(Noeud n , int e,int acc){
        if (n==null) return acc;
        else{
            if (e>acc){
                return tailleCouche(n.sag,e,acc+1)+tailleCouche(n.sad,e,acc+1);
            }else{
                if (n.info % 2 ==0){
                    return 1;
                }
                return 0;
            }
        }
    }
}
