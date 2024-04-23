package Session_2;


public class NouedFrere
{
    public static int noeudsFreres(Arbre a , Noeud n1 , Noeud n2){
        return noeudsFreres(a.racine, n1,n2);
    }
    private static int noeudsFreres(Noeud n , Noeud n1, Noeud n2){
        if (n==null) return 0;
        if (n.sag==null || n.sad==null) return 0;
        if ((n.sag.info==n1.info && n.sad.info==n2.info)||(n.sag.info==n2.info && n.sad.info==n2.info)){
            return 1;
        }
        return (noeudsFreres(n.sag,n1,n2)+ noeudsFreres(n.sad,n1,n2));
    }
}
