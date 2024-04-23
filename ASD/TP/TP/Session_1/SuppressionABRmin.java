package Session_1;



public class SuppressionABRmin
{
   public static void suppPetit(Arbre a ){
        a.racine = supprPetit(a.racine);
    }
    private static Noeud suppPetit(Noeud n){
        if (n!=null){
            if (n.sag==null) {
                n=null;
            }
            else{
                n.sag=suppPetit(n.sag);
            }
            return n;
        }
        return null;
    } 
}
