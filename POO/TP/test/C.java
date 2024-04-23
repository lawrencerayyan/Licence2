package test;


public class C
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
  public static int i ;
public int j;
    public C()
    {
        // initialisation des variables d'instance
        i++;
        j=i;
    }

    public static void main (String[] args) {
        C x = new C();
    C y = new C();
    C z=x;
    System.out.println(z.i +" " + z.j);
}
}
