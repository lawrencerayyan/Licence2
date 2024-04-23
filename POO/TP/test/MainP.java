package test;

public class MainP
{
     public static void main(String[]args){
       Pile p = new Pile();
        Pile a =p.inisialiserPile();

        try {
            for (int i = 1; i <= 100; i++) {
            a.empiler(a, i);
            a.afficherPile(a);
            System.out.println("ici on empile ||||||||||||||||||||||||||");
            }
            
        } catch (PilePleineException e) {
            System.out.println("PilePleineException");
        }


        try{
            System.out.println("ici on depile ---------------");
            for (int i = 1; i <= 100; i++) {
                a.depiler(a, i);
                a.afficherPile(a);
                System.out.println("ici on depile ---------------");
            }

        }
        catch (PileVideException e) {
            System.out.println("PileVideException"+ e );
        }
        
        
    }
}
