package Arbres_binaires;

public class TestTree
{
    public static void main()
    {
        Tree t = Tree.new_perfect_tree(3, 1);
        t.afficher_arbores();
        	
		
        System.out.println(Tree.bst_search_it(t, 1));
        System.out.println(Tree.bst_search_rec(t, 3));
        System.out.println("nb_elm " + Tree.nb_elmts(t));
		
		// test suppression
		
		Tree tt = new Tree();
        Tree.bst_add_r(tt, 10);
        Tree.bst_add_r(tt, 5);
        Tree.bst_add_r(tt, 20);
        Tree.bst_add_r(tt, 11);
        Tree.bst_add_r(tt, 3);

        Tree.afficher_pre_ordre(tt);
        Tree.suppABRrec(tt, 10);
		System.out.println ("affichage arbre apres suppression");
        Tree.afficher_pre_ordre(tt);
        

    }
}
