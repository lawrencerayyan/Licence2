package Session_1;


public class Recherche
{
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
    /**
     * rec
     */
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
}
