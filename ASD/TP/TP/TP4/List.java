package TP4;


/**
 * Décrivez votre classe List ici.
 *
 * @author (lawrence)
 * @version (09/11/2022 12:44:05)
 */
public class List
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Maillon first ;

    /**
     * Constructeur d'objets de classe List
     */
    public List()
    {
        // initialisation des variables d'instance
        first = null ;
    }
    
    public List (Maillon m ) {
        first = m ;
    }

    public boolean estVide(){
        return first == null ;
    } 
    
    /**
     * ajouter à la tete de la liste
     */
    public static void ajout_debut (List l ,int val) 
    {
        Maillon lastF = l.first;
        l.first = new Maillon(val, lastF);

        Maillon c = new Maillon(val);
        if(l.first == null) l.first = c;
        else {c.setNext(l.first);
        l.first = c;}
    }
    /**
     * ajouter à la fin de la liste
     */
    public static void ajout_fin (List l, int val) 
    {
        Maillon c = new Maillon(val);
        if(l.estVide()) 
            l.first = c;

        else {
            Maillon last = l.first;
            // On parcourt la liste jusqu’au dernier élément, 
            // celui dont le suivant est null.
            while(last.getNext() != null)
                last = last.getNext();            
            last.setNext(c);
        }
    }
    /**
     * afficher la liste
     */
    public static void afficher_list(List l)
    {
        Maillon cour = l.first;
        while(cour!=null)
        {
            System.out.print(cour);
            cour = cour.getNext();            
        }    
        System.out.println();
    }

    @Override
    public String toString()
    {
        String s="";
        Maillon cour = this.first;
        while(cour!=null)
        {
            s += cour;
            cour = cour.getNext();            
        }
        s+="\n";
        return s;
    }
    /**
     * avoir la longueur 
     */
    public static int getLongueur(List l) {
        return l.getLongueur_aux(l.first);
    }

    private int getLongueur_aux(Maillon e) {
        if (e == null)
            return 0;
        else
            return 1 + getLongueur_aux(e.getNext());
    }
    
     /**
     * Création de liste 1,2,3, ...n en itératif 
     * la liste est passée en param
     */ 
    
    public static void cree_list_n(List l , int n ){
        l.first = new Maillon(1);
        Maillon courant = l.first ;
        for(int i = 2 ;i <=n ;i++){
            courant.setNext(new Maillon (i)) ;
            courant = courant.getNext();
        }
    } 
    
    /**
     * Création de liste 1,2,3, ...n en Rec
     */ 
    
    public static List cree_list_n_rec (int n ) {
        List l = new List ();
        l.first = new_list_aux(n , 1 );
        return l ;
    }
    
    public static Maillon new_list_aux(int n , int i ) {
        Maillon m ;
        if (i>n) return null ;
        m = new Maillon (i);
        m.setNext(new_list_aux ( n , i+1));
        return m;
    }
    /**
     * la suite de Syracuse iteratif
     */
    
    public static List syracuse(int s ) {
        if (s<=0 ) return null; 
        List l = new List();
        Maillon x = l.first = new Maillon(s);
        
        while(s != 1){ 
            if (s % 2 == 0 ) s = s/ 2;
            else s = 3 * s + 1 ;
            x.setNext(new Maillon(s));
            x = x.getNext();
        }
        x.setNext(null);
        return l ;
    }
    
    /**
     * la suite de Syracuse Rec
     */
    public  List syracuse_r(int s){
        this.first= syracuse_rec(s);
        return this;
    }
    public static Maillon syracuse_rec(int s ){
        if (s<=0)return null; 
        Maillon m = new Maillon (s);
        if(s == 1 ) m.setNext(null);
        else{
            if (s % 2 == 0) s = s/ 2 ;
            else s= 3 * s + 1;
            m.setNext(syracuse_rec(s));
        }
        return m;
    }
    
    /**
     * concatenation version iterative
     * le resultat de la concatenation sera stocké dans l1
     */ 
    public static void concatener_it(List l1, List l2)
    {
        if(l1.estVide()) l1.first = l2.first;
        // On parcourt la liste jusqu’au dernier élément, 
        // celui dont le suivant est null.
        else if (!l2.estVide())
        { Maillon dernier = l1.first;
            while(dernier.getNext() !=null)
                dernier = dernier.getNext();
            dernier.setNext(l2.first);
        }
    }
    
}
