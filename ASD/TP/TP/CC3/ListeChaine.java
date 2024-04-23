package CC3;

/**
 * ListeChaine
 */
public class ListeChaine {
    private Maillon first;

    public ListeChaine() {
        // initialisation des variables d'instance
        first = null;
    }

    public List (Maillon m ) {
        first = m ;
    }

    // liste vide
    public boolean estVide() {
        return first == null;
    }

    /**
     * ajouter à la tete de la liste
     */
    public static void ajout_debut (List l ,int val) 
    {
        Maillon lastF = l.first;
        l.first = new Maillon(val, lastF);
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

    


}