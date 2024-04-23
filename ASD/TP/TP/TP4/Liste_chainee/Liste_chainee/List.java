package Liste_chainee;

public class List
{
    private Maillon first;

    public List()
    {
        first = null;
    }

    public List(Maillon m)
    {
        first = m;
    }

    public boolean estVide() {
        return (first == null);
    }

    public Maillon getPremier()
    {
        return first;
    }

    public static Maillon supprimer_first(List l)
    {
        Maillon temp=null;
        if  (l.first != null)
        {
            temp = l.first;
            l.first = l.first.getNext();              
        }
        return temp;
    }

    public static void ajout_debut (List l ,int val) 
    {
        Maillon lastF = l.first;
        l.first = new Maillon(val, lastF);

        /*Maillon c = new Maillon(val);
        if(l.first == null) l.first = c;
        else {c.setNext(l.first);
        l.first = c;}*/
    }

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
    
    public static int getLongueur(List l) {
        return l.getLongueur_aux(l.first);
    }

    private int getLongueur_aux(Maillon e) {
        if (e == null)
            return 0;
        else
            return 1 + getLongueur_aux(e.getNext());
    }

    // Algos de création de la liste

    /**
     * Création de liste 1,2,3, ...n en itératif V1
     * la liste est passée en param
     */ 

    public static void creer_1n_list(List l , int n)
    {
        l.first = new Maillon(1);
        Maillon courant = l.first;
        for(int i=2;i<=n;i++)
        {
            courant.setNext(new Maillon(i));
            courant = courant.getNext();            
        }
    }

    /**
     * Création de liste 1,2,3, ...n en itératif V2
     * la liste est retournée
     */ 
    public static List new_1n_list(int n) {

        if (n<=0) return null;
        List res = new List();
        int i = 1;
        Maillon tete = res.first = new Maillon(1);
        while (i < n)
        {
            tete.setNext (new Maillon(++i));
            tete = tete.getNext();
        }
        return res;
    }

    /**
     * Création de liste 1,2,3, ...n en récursif 
     */ 
    public static List new_1n_list_r(int n)
    {
        List l = new List();
        l.first = new_1n_list_aux(n, 1);
        return l;
    }

    public static Maillon new_1n_list_aux(int n, int i)
    {
        Maillon m;
        if (i>n) return null;
        m = new Maillon(i);
        m.setNext(new_1n_list_aux (n, i+1));
        return m;
    } // liste ()

    /**
     * création de la liste décroissante à n éléments en récursif *
     */
    public static List create_n1_r(int n){
        List l = new List();
        l.first = create_n1_aux(n);
        return l;
    }

    public static Maillon create_n1_aux(int n) {
        if (n == 0) return null;
        Maillon m = new Maillon(n);
        m.setNext(create_n1_aux(n - 1));
        return m;
    }

    /**
     * retourne la suite de Syracuse de terme initial s
     */ 
    public static List syrac_iter(int s) {
        if (s<=0) return null;
        List l = new List();
        Maillon q = l.first = new Maillon(s);

        while (s != 1)
        {
            if (s % 2 == 0) s = s / 2;
            else s = 3 * s + 1;
            q.setNext(new Maillon(s));
            q = q.getNext();
        }
        q.setNext(null);
        return l;
    }

    public List syrac_r (int s)
    {
        this.first = syrac_rec(s);
        return this;
    }

    private static Maillon syrac_rec(int s)
    {
        if(s<=0) return null;
        Maillon m = new Maillon (s);
        if(s==1) m.setNext(null);
        else{
            if (s % 2 == 0) s = s / 2;
            else s = 3 * s + 1;
            m.setNext(syrac_rec(s));
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

