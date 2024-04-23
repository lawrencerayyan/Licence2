package Session_2;



public class Contenance
{
    public static boolean contient(List l1,List l2){
        Maillon m1 = l1.tete;
        Maillon m2= l2.tete;
        while(m1!=null && m2!=null){
            if (m1.info==m2.info){
                m2=m2.succ;
            }
            m1=m1.succ;
        }
        if (m2==null){
            return true;
        }
        return false;
    }
}
