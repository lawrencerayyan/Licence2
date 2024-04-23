package Liste_chainee;
public class Main
{
    public static void main()
    {
        List l = new List();

        List.ajout_debut(l,3);
        List.ajout_debut(l,1);
        List.ajout_debut(l,2);
        List.ajout_debut(l,1);
        List.ajout_fin(l,4);
        List.ajout_fin(l,1);
        List.ajout_debut(l,1);

        System.out.println(l);
        List.supprimer_tte_occ_rec(l, 1);
        System.out.println("liste apres suppression : " + l);
        
        
        System.out.println(l.getPremier());
        List.afficher_list(l);
        List.ajout_debut(l,1);
        List.ajout_fin(l,1);        
        List.ajout_fin(l,5);
        List.afficher_list(l); 

        List.supprimer_tte_occ_it(l,1);
        List.afficher_list(l); 
       
   
        System.out.println(l);
        System.out.println(List.getLongueur(l));

        List ll = new List();

        List.ajout_fin(ll,11);
        List.ajout_fin(ll,12);
        List.ajout_fin(ll,13);
        List.ajout_fin(ll,14);

        System.out.println(ll);

        List.concatener_it(l,ll);
        System.out.println(l);


        System.out.println(ln);

        // test algos création de liste 
        System.out.println("\ntest algos création de liste");
        List l120 = List.new_1n_list_r(20);
        System.out.println("liste rec 1à20 : " + l120);
        List l115 = List.new_1n_list(15);
        System.out.println("liste it 1à15 : " + l115);  

        List ls =  List.syrac_iter(10);
        System.out.println("liste syrac it s=10 : " + ls); 

        List lsr =  List.syrac_iter(15);
        System.out.println("liste syrac rec s=15 : " + lsr); 


        
    }
}