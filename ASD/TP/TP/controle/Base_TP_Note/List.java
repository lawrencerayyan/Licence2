package base_tp_note;

public class List
{
    private Maillon first;

    public List()
    {
        first = null;
    }

    public boolean estVide() {
        return (first == null);
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



}