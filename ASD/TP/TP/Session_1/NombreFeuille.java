package Session_1;


public class NombreFeuille
{
    public static int nbFe(Arbre a,int p){
        return nbFe(a.racine,p);
    }
    private static int nbFe(Noeud n , int p){
        if (n==null) return 0;
        if (p>0){
            return nbFe(n.sag,p-1)+nbFe(n.sad,p-1);
        }else {
            if(n.sag==null && n.sad==null){ 
              return 1+nbFe(n.sag,p-1)+nbFe(n.sad,p-1);
            }else{
                return nbFe(n.sag,p-1)+nbFe(n.sad,p-1); 
            }
        } 
    }
}
