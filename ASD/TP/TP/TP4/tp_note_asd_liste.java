package TP4;


public class tp_note_asd_liste
{
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
     * Supprimer la tete d'une liste
     */    
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
    
    /**
     * Supprimer un element à une position donnée 
     */
    public void supprimer(int position){
        if (taille == 0){
            System.out.println("liste est vide, operation impossible");
        }
        else if(position> taille || position < 1){
            System.out.println("position n'existe pas");
        }
        else if(taille == 1){
            System.out.println("\n\n" + premier.getInfo() + "\" est supprimé");

            premier = null;
            dernier = null;
            taille = 0;
        }
        else if(position == 1){
            System.out.println("\n\n" + premier.getInfo() + "\" est supprimé");

            premier = premier.getSuivant();
            --taille;
        }
        else{
            Maillon pointeur = premier;
            for(int z = 1; z < (position - 1); ++z){
                pointeur = pointeur.getSuivant();
            }
            pointeur.setSuivant(pointeur.getSuivant().getSuivant());
            --taille;
        }
    }
    
    /**
     * supprimer un element d'une liste doublement chainée
     */
    public static void supprimeRecursifAux( Maillon b, Maillon m, Maillon a, int target, boolean est2Chainee )
    {
        if ( m == null ) return;
        if ( m.getInfo() == target )
        {
            if ( a == null )
            {
                b.setSucc( null );
                return;
            }
            b.setSucc( a );
            if ( est2Chainee ) a.setPred( b );
            supprimeRecursifAux( a, a.getSucc(), a.getSucc().getSucc(), target, est2Chainee );
        }
        else
        {
            supprimeRecursifAux( m, a, ( a == null ) ? null : a.getSucc() , target, est2Chainee );
        }
    }
    public static void supprimeRecursif( List l, int target, boolean est2Chainee )
    {
        if ( l == null ) return;
        supprimeRecursifAux( l.getFirst(), l.getFirst().getSucc(), l.getFirst().getSucc().getSucc(), target, est2Chainee );
    }
    
    /**
     * Supprimer un element d'une liste simplement chianée
     */
    public static void suppressionRecursifAux( List l, int stop )
    {
        if ( stop <= 0 ) return;
        int r = 0;
        Maillon t = l.getFirst();
        while ( r != stop )
        {
            r++; t = t.getSucc();
        }
        t = null;
        suppressionRecursifAux( l, stop - 1 );
    }
    public static void suppressionRecursif( List l )
    {
        if ( l == null ) return;
        suppressionRecursifAux( l, getLengthIteratif( l ) );
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
     * Changer la valeur d'un Maillon
     */
    public void changeInfo(int info, int position) {
        if (taille == 0) {
            System.out.println("liste est vide, operation impossible");
        }
        else if(position > taille || position < 1) {
            System.out.println("position n'existe pas");
        } else {
            Maillon pointeur = premier;
            
            for(int z = 1 ; z < position ; ++z) {
                pointeur = pointeur.tirerSuivant();
            }
            pointeur.changerInfo(info);
        }
    }
    
    /**
     * Trier une liste Croissante
     */
    public void trierCroissant(Liste liste){
        if(liste == null || liste.tirerTaille() <=1 ){
            return;
        }
        Maillon courant = liste.premier;
        boolean trie = false;
        while(!trie){
            boolean swapped = false;
            while(courant.suivant != null){
                Maillon suiv = courant.suivant;
                if(courant.valeur > suiv.valeur){
                    int temp = courant.valeur;
                    courant.valeur = suiv.valeur;
                    suiv.valeur = temp;
                    swapped = true;
                }
                courant = suiv;
            }
            if(!swapped){
                trie = true;
            }
        }

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
    
    
    /**
     * concatenation version recursive
     */ 
    public static void concatener_rec(List l1, List l2)
    {
        if(l1.estVide()) l1.first = l2.first;
        else concatener_aux(l1.first, l2.first);           
    }
    private static void concatener_aux(Maillon m1, Maillon m2)
    {
        if(m1.getNext() == null) m1.setNext(m2);
        else concatener_aux(m1.getNext(), m2);
    }

    
     /**
     * suppression de toutes les occurences de e dans la liste l 
     * version itérative
     */ 
    public static void supprimer_tte_occ_it( List l, int e)
    {
        Maillon cour  = l.first;
        Maillon prec = null;
        while (cour !=null)
        {
            if(cour.getInfo()==e)
            {// suppression de la tete
                if(cour == l.first) l.first = cour.getNext();
                else prec.setNext(cour.getNext());
                cour = cour.getNext();
            }
            else {
                prec = cour;
                cour = cour.getNext();
            }
        }
    }
    
    /**
     * suppression de toutes les occurences de e dans la liste l 
     * version récursive
     */ 

    public static void supprimer_tte_occ_rec(List l, int e)
    {
        if (l.estVide()) return;
        if(l.first.getInfo()==e)
        {
            l.first = l.first.getNext();
            supprimer_tte_occ_rec(l, e);// cas de liste : 1->1->2->3->1->4
        }
        else {
            l.first =  supprimer_tte_occ_aux(l.first,e);
        }
    }
    private static Maillon supprimer_tte_occ_aux(Maillon m, int e)
    {
        if(m==null) return null;
        if(m.getInfo()==e)
        {
            m = m.getNext();
        }
        if(m!=null) m.setNext(supprimer_tte_occ_aux(m.getNext(), e));
        return m;
    }
    
    /**
     * Convertit un tableau d'entiers en une liste simplement ou doublement
     * chaînée, linéaire ou circulaire.
     *
     * @param t : tableau d'entiers à convertir.
     * @return : la liste équivalente à t.
     */
    public static List listet(int[] t) {
        int n = t.length;
        if (t==null || n==0) return null;// si le tableau est vide, on retourne la liste vide
        Maillon m = new Maillon(t[0]);      // création du maillon de tête de liste avec pour valeur t0
        List l = new List();
        l.first = m;            // on mémorise la tête de liste, puisque c'est elle qu'on retourne à la fin
        int i;
        for (i = 1; i < n; i++) {   // création et insertion en queue du reste de la liste
            m.setNext(new Maillon(t[i]));   // ajout d'un maillon supplémentaire
            m = m.getNext();
        }
        m.setNext(null);                // si la liste est linéaire, successeur de la queue null, sinon la tête de liste
        return l;                   // on retourne la liste représentée par un pointeur sur son maillon de tête
    }
    
    /**
     * Recherche de la position d'un element
     */
    public static int getPosElemIteratif( List l, int m )
    {
        if ( l == null ) return -1;
        Maillon t = l.getFirst();
        int pos = 0;
        while ( t != null )
        {
            if ( m == t.getInfo() ) return pos;
            pos++;
            t = t.getSucc();
        }
        return -1;
    }

    public static int getPosElemRecursifAux( Maillon l, int m, int pos )
    {
        if ( l == null ) return -1;
        if ( l.getInfo() == m ) return pos;
        return getPosElemRecursifAux( l.getSucc(), m, pos + 1 );
    }
    public static int getPosElemRecursif( List l, int m )
    {
        if ( l == null ) return -1;
        return getPosElemRecursifAux( l.getFirst(), m, 0 );
    }
    
    /**
     * Sous list de nombre positifs
     */
    public static void sub_list_aux(Maillon e, Maillon m){
    if( e == null)return;
    if(e.getInfo()>0){
        m.setSucc(new Maillon(e.getInfo()));

    }
    sub_list_aux(e.getSucc(),m.getSucc());

}
public static List sub_list(List l){
    if(l == null) return null;
    List list_pos = new List(new Maillon());
    sub_list_aux(l.getList(),list_pos.getList());
    if(list_pos.getList().getSucc()!=null)
        list_pos.setList(res.getList().getSucc());
        return list_pos;
}

/**
 * Affiche 1 sur 2 LSC
 */
public static void printlsEvenIteratif( List l )
	{
		if ( l == null ) return;
		Maillon temp = l.getFirst();
		int v = 0;
		while ( temp != null )
		{
			if ( v % 2 == 0 ) System.out.print( temp.getInfo() + " -> " );
			v++;
			temp = temp.getSucc();

		}
		System.out.println( " X " );
	}
    /**
     * Verification de Croissance d'une LSC
     */
    public static boolean isGrowingIteratif( List l )
	{
		if ( l == null ) return false;
		Maillon temp = l.getFirst();
		int v = temp.getInfo();
		while ( temp != null )
		{
			if ( v > temp.getInfo() ) return false;
			v = temp.getInfo();
			temp = temp.getSucc();
		}
		return true;
	}
    
    /**
     * Supprimer une LSC (libérer l’espace mémoire réservé).
     */
    public static void suppressionIteratif( List l )
    {
        if ( l == null ) return;
        Maillon temp;
        int length = getLengthIteratif( l );
        for ( int i = 0; i < length; i++ )
        {
            temp = l.getFirst();
            while ( temp.getSucc() != null ) { temp = temp.getSucc(); }
            temp = null;
        }
    }
    
    /**
     * Afficher une LSC dans l’ordre inverse. 
     */
    public static void printlnReverseIteratif( List l )
	{
		if ( l == null ) return;
		int size = getLengthIteratif( l );
		int r = 0;
		Maillon t;
		for ( int i = size - 1; i >= 0; i-- )
		{
			r = 0;
			t = l.getFirst();
			while( r != i )
			{
				r++;
				if ( t.getSucc() == null ) break;
				t = t.getSucc();
			}
			System.out.print( ( t == null ) ? "X" : t.getInfo() + " -> " );
		}
		System.out.println( "X" );
	}
	
        /**
         * valeur max
         */
        
	public static int getMaxOfListeIteratif( List l )
	{
		if ( l == null ) return 0;
		int max = l.getFirst().getInfo();
		Maillon temp = l.getFirst();
		while ( temp != null )
		{
			if ( temp.getInfo() > max ) max = temp.getInfo();
			temp = temp.getSucc();
		}
		return max;
	}

	public static int getMaxOfListeIteratifAux( Maillon m, int max )
	{
		if ( m == null ) return max;
		return getMaxOfListeIteratifAux( m.getSucc(), ( m.getInfo() > max ) ? m.getInfo() : max );
	}

	public static int getMaxOfListeRecursif( List l )
	{
		if ( l == null ) return 0;
		return getMaxOfListeIteratifAux( l.getFirst(), l.getFirst().getInfo() );
	}
}
