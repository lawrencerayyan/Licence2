package TP5;

/**
 * Décrivez votre classe Arbre ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Arbre
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    Noeud racine ;
    
    public Arbre()
    {
        racine = null ;
    }

    public Arbre( Noeud r ){
        racine = r ;
    }

    public boolean estVide(){
        return ( racine==null ); 
    }

    public void CreeNoeud (int e){
        Noeud m = new Noeud(e);
    }

    /**
     * Nombre D'element en recurisf
     */

    public static int nb_elm(Arbre a ) {
        return nb_elm_aux(a.racine);
    }

    public static int nb_elm_aux(Noeud n ) {
        if (n==null) return 0 ;
        return 1 + nb_elm_aux(n.getSag())+nb_elm_aux(n.getSad()) ;
    }

    /**
     * Arbre parfait
     */
    public static Arbre NewArbreParfait(int n , int e ){
        Arbre t = new Arbre();
        t.racine = NewArbreParfait_aux(n,e);
        return t;
    }

    public static Noeud NewArbreParfait_aux(int n , int e )
    {
        Noeud t = new Noeud (e);
        if (n > 1 ){
            t.setSag(NewArbreParfait_aux(n -1 ,2 * e ));
            t.setSad(NewArbreParfait_aux(n - 1 ,2 * e + 1));
        }
        return t;
    }

    /**
     * Affichage en pre ordre
     */

    public static void afficher_pre_ordre(Arbre a ){
        afficher_pre_ordre_aux(a.racine );
    }

    public static void afficher_pre_ordre_aux(Noeud a ){
        if (a != null){
            System.out.println(a.getInfo());
            afficher_pre_ordre_aux(a.getSag());
            afficher_pre_ordre_aux(a.getSad()); 
        }
    }

    /**
     * le plus grand ABR
     */
    public static Noeud plusGrand(Arbre a){
        return plusGrandABR(a.racine);
    }

    public static Noeud plusGrandABR(Noeud a){
        while ( a.getSad() != null){
            a = a.getSad();
        }
        return a; 
    }

    /**
     * le plus petit Abr
     */
    public static Noeud plusPetit(Arbre a){
        return plusGrandABR(a.racine);
    }

    public static Noeud plusPetitABR(Noeud a){
        while ( a.getSag() != null){
            a = a.getSag();
        }
        return a; 
    }

    /**
     * Verifier si un arbre est un ABR
     */

    public static boolean EstABR(Arbre a){
        return EstABR(a.racine);
    }

    private static boolean EstABR(Noeud n){
        if(n == null ){
            return true;
        }
        if ( n.getSag() == null && n.getSad() == null ) return true ;
        boolean resultat = true;
        if (n.getSag()!= null ){
            resultat = plusGrandABR(n.getSag()).getInfo() > n.getInfo()  && EstABR(n.getSag());
            
        }
        if (n.getSag()!= null ){
            resultat = resultat && plusPetitABR(n.getSag()).getInfo() > n.getInfo()  && EstABR(n.getSad());
            
        }
        return resultat ;
    }
}
