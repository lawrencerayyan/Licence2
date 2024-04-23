package Session_2;



public class SuppressionABRmin
{
    public static void supprimerPetit(Arbre a ){
        a.racine = supprimerPetit(a.racine);
    }
    private static Noeud supprimerPetit(Noeud n){
        if (n!=null){
            if (n.sag!=null){
                n.sag=supprimerPetit(n.sag);
            }else{
                n=null;
            }
        }
        return n;
    }
}
