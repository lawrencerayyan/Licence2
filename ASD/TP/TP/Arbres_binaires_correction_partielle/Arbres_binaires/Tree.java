package Arbres_binaires;

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

    /**
     * Nombre d'éléments en récursif
     */
    public static int nb_elmts(Tree t)
    {
        return nb_elmts_aux(t.root);
    }

    public static int nb_elmts_aux(Node n)
    {if(n==null) return 0;
        return 1 + nb_elmts_aux(n.getLeft()) + nb_elmts_aux(n.getRight());
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

    public static void afficher_pre_ordre(Tree a)
    {
        afficher_pre_ordre_aux(a.root);
    }

    public static void afficher_pre_ordre_aux (Node a)
    {
        if (a!=null)
        {
            System.out.println (a.getInfo());
            afficher_pre_ordre_aux (a.getLeft());
            afficher_pre_ordre_aux (a.getRight());
        }
    }


    /**
     *nombre de points doubles
     */ 
    public static int nbre_point_double(Tree t)
    {
        return nbre_point_double_aux(t.root);
    }

    public static int nbre_point_double_aux(Node a)
    {
        int d = 0;
        if(a==null) return 0;
        if(a.getLeft()!=null && a.getRight()!=null) d= 1;

        return d + nbre_point_double_aux (a.getLeft()) 
        +nbre_point_double_aux(a.getRight());
    }

    /**
     * nombre de point avec un seul fils
     */ 
    public static int nbre_point_mono(Tree t)
    {
        return nbre_point_mono_aux(t.root);
    }

    public static int nbre_point_mono_aux(Node a)
    {
        if (a== null) return 0;
        if (a.getLeft()!=null && a.getRight()!= null)// cas d'un point double
            return nbre_point_mono_aux(a.getLeft()) 
            + nbre_point_mono_aux(a.getRight());
        if (a.getLeft() != null) // point mono gache
            return 1 + nbre_point_mono_aux(a.getLeft()) ;
        if (a.getRight()!= null) //point mono droit
            return 1 + nbre_point_mono_aux(a.getRight());
        return 0;// cas d'une feuille
    }

    public Node minABR()
    {
        Node cour = this.root;
        while (cour.getLeft()!= null)
            cour = cour.getLeft();
        return cour;
    }

    

    /**
     * Recherche d'un éléments dans un ABR (bst)
     * version itérative
     */
    public static boolean bst_search_it(Tree a, int e) {
        Node t = a.root;
        while (t!=null) {
            if (t.getInfo() == e) return true;
            t = e < t.getInfo() ? t.getLeft() : t.getRight();
        }
        return false;
    }

    /**
     * Recherche d'un éléments dans un ABR (bst)
     * version récursive
     */
    public static boolean bst_search_rec(Tree a, int e) {
        return bst_search_aux(a.root, e);
    }

    public static boolean bst_search_aux(Node t, int e) {
        if (t==null) return false;
        if (t.getInfo() == e) return true;
        return bst_search_aux(e < t.getInfo() ? t.getLeft() : t.getRight(), e);
    }

    /**
     * ajout dans un ABR 
     * version itérative
     */
    public static void bst_add(Tree t, int e)
    {
        if(t.estVide()) t.root = new Node(e);
        else{
            Node r = t.root;
            Node p=null;
            while(r!=null){
                p =r;
                r=e<r.getInfo()?r.getLeft():r.getRight();
            }
            r = new Node(e);
            if(e<p.getInfo())p.setLeft(r);
            else p.setRight(r);
        }

    }

    /**
     * ajout dans un ABR 
     * version récursive
     */
    public static void bst_add_r(Tree t, int e)
    {
        t.root = bst_add_aux(t.root,e);
    }

    public static Node bst_add_aux(Node r, int e)
    {
        if(r==null) r = new Node(e);
        else{
            if(e<r.getInfo()) r.setLeft(bst_add_aux(r.getLeft(),e));
            else r.setRight(bst_add_aux(r.getRight(),e));
        }
        return r;
    }

    /**
     * Algorithmes nécessaires pour la suppression d'un élément dans un ABR
     */
    public Node plusPetit()
    {
        Node cour = this.root;
        while(cour.getLeft()!=null)
        {
            cour=cour.getLeft();
        }
        return cour;
    }

    public static Node plusGrand(Node a)
    {
        Node cour = a;
        while(cour.getRight()!=null)
        {
            cour=cour.getRight();
        }
        return cour;
    }


    public static void suppABRrec(Tree tree, int value)
    {
        tree.root = suppABRrec(tree.root, value);
    }

    private static Node  suppABRrec(Node tree, int value) {
        if (tree == null)
            return tree;
        if (value > tree.info) 
            tree.right = suppABRrec(tree.right, value);
        else if (value < tree.info)
            tree.left = suppABRrec(tree.left, value);
        else { // value = tree->data
            if (tree.left == null)
                tree= tree.right;
                
            else if (tree.right == null)
                tree = tree.left;

            else {
                int tmp = tree.info;
                Node max = plusGrand(tree.left);
                tree.info = max.info;
                max.info = tmp;
                tree.left = suppABRrec(tree.left,tmp);
            }
        }
        return tree;
    }

           

}
