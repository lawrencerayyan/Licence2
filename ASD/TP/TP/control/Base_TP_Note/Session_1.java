public class Session_1 {
    public static void sub_list_aux(Maillon e, Maillon m){
        if( e == null)return;
        if(e.getInfo()<0){
            m.setSucc(new Maillon(e.getInfo()));
    
        }
        sub_list_aux(e.getSucc(),m.getSucc());
    }

    public static List sub_list(List l){
        if(l == null) return null;
        List list_pos = new List(new Maillon());
        sub_list_aux(l.getList(),list_pos.getList());
        if(list_pos.getList().getSucc()!=null)
            list_pos.setList(res.getList().getSucc());
            return list_pos;
    }


    // la min d'un AB
    public static int minAB(Arbre a){
        Noeud n = minAB(a.root); 
        return n.info;
    }
    private static Noeud minAB(Noeud n){
        Noeud m = n;
        while(m.left!=null){
            m=m.left;
        }
        return m;
    }


    // le max d'un AB
    public static int maxABR(Arbre a){
        Noeud n =maxABR(a.root); 
        return n.info;
    }
    public static Noeud maxABR(Noeud a){
        Noeud n = a;
        while(n.right!=null){
            n=n.right;
        }
        return n;
    }


    // public difference(Noeud a){return  max(Noeud a)-min(Noued a);}

    public static int différence(Arbre a, arbre b){
        return différence(a.root,b.root);
    }
    private static int différence(Noeud n , Noeud b){
        if (n==null) return -1;
        if (n.left==null || n.right==null) return 0;
        else{
           if (n.left!=null && n.right!=null){
               return n.info-max(n.right)-min(n.left);
           }else{
               return max(n.right)-min(n.left);
           }
        }
        return 0;
    }

    public static int nb_simple_couche(Tree t, int c)
    {
        return nb_simple_couche_aux(t.root, c);
    }

    public static int nb_simple_couche_aux(Node a, int c)
    {
        if (a== null) return 0;
        if(c>1){
        if (a.getLeft()!=null && a.getRight()!= null)
            return nb_simple_couche_aux(a.getLeft()) 
            + nb_simple_couche_aux(a.getRight());
        if (a.getLeft() != null) 
            return 1 + nb_simple_couche_aux(a.getLeft()) ;
        if (a.getRight()!= null) 
            return 1 + nb_simple_couche_aux(a.getRight());
        }
        return 0;
    }

    public void parcourInordre(Arbre a){
        parcourInordre(a.root);
        System.out.println();
    }
    private void parcourInordre(Noeud n){
        if (n!=null){
            parcourInordre(n.left);
            System.out.print(n.info +" ");
            parcourInordre(n.right);
        }
    }
    public static Liste liste_ord_ABR(int tableau[])
    {
    Tree arbre= Tree.new_perfect_tree(tableau,0);
    return(parcourInordre(arbre));
    }

let rec fu n = match n with 
  | 0 -> (2.,-1.)
  |1 -> (1.,2.)
  |n-> let (u,v) = fu(n-1) in
      let fn = (u/.((v)+.8.))in
      (fn,u)
let f n = fst (fu n)

let rec fu n = match n with 
 |0->(1,0,0)
 |1-> (1,1,0)
 |2-> (1,1,1)
 |n -> let (x,y,z) = fu (n-1) in 
  let fn = x+3*y+z in 
  (fn,u, v)
let f n = fst(  fu n)

let rec fu n = match n with 
  |0->(1,0,0)
  |1-> (1,1,0)
  |2-> (1,1,1)
  |n -> let (x,y,z) = fu (n-1) in 
      let fn = x+3*y+z in 
      (fn,x,y)
let f n = fst(  fu n)

let rec fu n = match n with 
  |0->(1,0,0)
  |1-> (1,1,0)
  |2-> (1,1,1)
  |n -> let (x,y,z) = fu (n-1) in 
      let fn = x+3*y+z in 
      (fn,x,y)

let f n = match fu n with 
  |(x,,) -> x


  let  g f b c = f c b
  let g f a = (f a,a)
  let g f x  = f (x)

let rec f_aux =function 
|0 -> (1,-1)
|1->(1,1)
|n -> let (gn_1,gn_2) = f_aux(n-1) in 
let gn = ((n-1)* gn_1 -3 + gn_2) in 
(gn, gn_1)
let g n = fst (f_aux n)

}
