package base_tp_note;

public class Tree
{
    private Node root;

    /**
     * Constructeur d'objets de classe Tree
     */
    public Tree()
    {
        root = null;
    }

    public Tree(Node r)
    {
        root = r;
    }

    public boolean estVide() {
        return (root == null);
    }

    public static Tree new_perfect_tree(int n, int e){
        Tree t = new Tree();
        t.root = new_perfect_tree_aux(n,e);
        return t;
    }

    public static Node new_perfect_tree_aux(int n, int e){
        Node t = new Node(e);
        if (n > 1) {
            t.setLeft(new_perfect_tree_aux(n - 1, 2 * e));
            t.setRight(new_perfect_tree_aux(n - 1, 2 * e + 1));
        }
        return t;
    }


    /**
     * affichage en arborescence (pre-ordre comme etant une méthode d'instance
     */
    public void afficher_arbores()
    {
        afficher_arbores_aux(this.root, 0 );
    }

    public static void afficher_arbores_aux(Node a, int p)
    {
        if (a!=null)
        {
            // afficher le nombre de décalages en fonction de la profondeur p
            for(int i=0; i<p;i++) {System.out.print(" ");}            
            if(p!=0) System.out.print("|-");
            System.out.println (a.getInfo());
            afficher_arbores_aux(a.getLeft(),p+1);
            afficher_arbores_aux(a.getRight(),p+1);
        }
    }


}