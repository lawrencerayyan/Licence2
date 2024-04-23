package Session_2;


public class SommeEleDouble
{
    public static int somme_pintsDoubles_couche(Arbre a, int c){
        return somme(a.racine,c);
    }
    private static int somme(Noeud n , int c){
        if (n==null) return 0;
        if (n.sag==null || n.sad==null) return 0;
        if (c>=1){
           if (n.sag!=null && n.sad!=null){
               return n.info+somme(n.sag,c-1)+somme(n.sad,c-1);
           }else{
               return somme(n.sag,c-1)+somme(n.sad,c-1);
           }
        }
        return 0;
    }
}
