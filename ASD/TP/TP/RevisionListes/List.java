package RevisionListes;
public class List
{
    Maillon tete;
    public List(){
        
    }
    public List(Maillon m ){
        tete=m;
    }
    public static void afficher(List l){
        Maillon m = l.tete;
        while(m!=null){
            System.out.print(m + "-> ");
            m=m.succ;
        }
        System.out.println("Null");
    }
    public static void afficherRec(List l){
        afficherRec(l.tete);
    }
    private static void afficherRec(Maillon m){
        if (m!=null){
            System.out.print(m.info + "->");
            afficherRec(m.succ);
        }else{
            System.out.println("Null");
        }
    }
    public static void afficherLDC(List l){
        Maillon m = l.tete;
        Maillon prec = m.pred;
        while(m!=null){
            System.out.print("("+prec+ "-> )"+ m + "-> ");
            prec=m;
            m=m.succ;
        }
        System.out.println("Null");
    }
    public static List creerLSC(int n){
        List l = new List();
        l.tete=new Maillon(1);
        l.tete.succ=creerLSC(n,2);
        return l;
    }
    private static Maillon creerLSC(int n , int m){
        if (m<=n){
            Maillon ma = new Maillon (m);
            ma.succ=creerLSC(n,m+1);
            return ma;
        }
        return null;
    }
    public static List syracus_it(int n){
        List l = new List();
        l.tete= new Maillon(n);
        Maillon m = l.tete;
        l.tete.succ=m.succ;
        while(n!=1){
            if(n % 2 ==0){
               m.succ= new Maillon(n/2); 
               n=n/2;
            }else{
                m.succ=new Maillon(3*n+1);
                n=3*n+1;
            }
            m=m.succ;
        }
        return l;
    }
    public static List syracus_rec(int n){
        List l = new List();
        l.tete=new Maillon(n);
        l.tete.succ=syracus_aux(l.tete.succ, n);
        return l;
    }
    private static Maillon syracus_aux(Maillon m , int n){
        if (n!=1){
           if (n%2==0){
               m=new Maillon(n/2);
               m.succ=syracus_aux(m.succ,n/2);
           }else{
               m=new Maillon(3*n+1);
               m.succ=syracus_aux(m.succ,3*n+1);
           }
        }
        return m;
    }
    public static List convertirLSC(int [] tab){
        List l = new List();
        l.tete=new Maillon(tab[0]);
        Maillon m = l.tete;
        l.tete.succ=m.succ;
        for (int i=1; i<tab.length ;i++){
            m.succ=new Maillon(tab[i]);
            m=m.succ;
        }
        return l;
    }
    public static List convertirLDC(int [] tab){
        List l = new List();
        l.tete = new Maillon(tab[0]);
        Maillon m = l.tete;
        Maillon prec = m.pred;
        l.tete.succ=m.succ;
        for (int i=1; i<tab.length ;i++){
            m.succ=new Maillon(tab[i]);
            prec=m;
            m=m.succ;
        }
        return l;
    }
    public static int longueur(List l){
        Maillon m = l.tete;
        int cmp=0;
        while(m!=null){
            cmp++;
            m=m.succ;
        }
        return cmp;
    }
    public static int longueurRec(List l){
        return longueurRec(l.tete);
    }
    private static int longueurRec(Maillon m){
        if (m!=null){
            return 1+longueurRec(m.succ);
        }else{
            return 0;
        }
    }
    public static int position(List l, int e){
        Maillon m = l.tete;
        int cmp=0;
        while(m!=null && m.info!=e){
            cmp++;
            m=m.succ;
        }
        return cmp;
    }
    public static int positionRec(List l , int e){
        return position(l.tete,e);
    }
    private static int positionRec(Maillon m , int e){
        if (m!=null){
            if (m.info!=e){
                return 1+positionRec(m.succ,e);
            }else{
                return 0;
            }
        }
        return -1;
    }
    private static int position(Maillon m , int e){
        if (m==null) return -1;
        if (m.info==e) return 0;
        int pos = 1+position(m.succ,e);
        if (pos>-1)return pos;
        else return -1;
    }
    public static int nbOccurence(List l , int e){
        Maillon m = l.tete;
        int occ=0;
        while (m!=null){
            if (m.info==e){
                occ++;
            }
            m=m.succ;
        }
        return occ;
    }
    public static int nbOccurenceRec(List l , int e){
        return nbOccurenceRec(l.tete,e);
    }
    private static int nbOccurenceRec(Maillon m , int e){
        if (m==null) return 0;
        if (m.info==e) return 1+nbOccurenceRec(m.succ, e);
        return nbOccurenceRec(m.succ, e);
    }
    public static int nbMax(List l){
        Maillon m = l.tete;
        int max =0;
        while (m!=null){
            if (m.info>max){
                max=m.info;
            }
            m=m.succ;
        }
        return max;
    }
    public static int nbMaxRec(List l){
        return nbMaxRec(l.tete);
    }
    private static int nbMaxRec(Maillon m){
        if (m==null) return -1;
        if (m.succ==null) return m.info;
        int max = nbMaxRec(m.succ);
        if (max>m.info) return max;
        else return m.info;
    }
    public static void un_sur_deux(List l){
        Maillon m = l.tete;
        int cmp=0;
        while (m!=null){
            if (cmp%2==0){
                System.out.print(m + "->");
            }
            cmp++;
            m=m.succ;
        }
    }
    public static void un_sur_deuxRec(List l){
        un_sur_deuxRec(l.tete,0);
    }
    private static void un_sur_deuxRec(Maillon m, int cmp){
        if (m!=null){
            if (cmp%2==0){
                 System.out.print(m + "->");
            }
            un_sur_deuxRec(m.succ,cmp+1);
        }
    }
    public static boolean verifierCroissance(List l){
        if (l.tete!=null){
             Maillon m = l.tete;
             int max = 0;
             while (m!=null){
                 if(m.info<max){
                     return false;
                 }
                 max=m.info;
                 m=m.succ;
             }
             return true;
        }
        return false;
    }
    public static boolean verifierCroissanceRec(List l){
        return verifierCroissanceRec(l.tete);
    }
    private static boolean verifierCroissanceRec(Maillon m){
        if (m==null) return true;
        if (m.succ== null) return true;
        if (m.info>m.succ.info) return false;
        return verifierCroissanceRec(m.succ);
    }
    public static void afficherInverseRec(List l){
        afficherInverseRec(l.tete);
    }
    private static void afficherInverseRec(Maillon m){
        if (m!=null){
            afficherInverseRec(m.succ);
            System.out.print(m + "->");
        }
    }
    public void afficherInverse(List l){
        int cmp = longueur(l);
        while (cmp>0){
            int i=0;
            Maillon cour = l.tete;
            Maillon prec = l.tete;
            while (cour!=null && i<cmp){
                i++;
                prec=cour;
                cour=cour.succ;
            }
            System.out.print(prec + "->");
            cmp--;
        }
    }
    public static int rechercheElementNeg(List l ){
        return rechercheTerm(l.tete,1);
    }
    private static int rechercheElementNeg(Maillon m){
        if (m==null) return -1;
        if (m.info<0) return 1;
         int pos = rechercheElementNeg(m.succ);
        if (pos!=-1) return 1+pos;
        return -1;
    }
    private static int rechercheTerm(Maillon m , int pos){
        if (m==null) return -1;
        if (m.info<0) return pos;
        return rechercheTerm(m.succ,pos+1);
    }
    public static List sous_list(List l){
        Maillon m =l.tete;
        List l1 = new List();
        Maillon n = l1.tete;
        while (m!=null){
            if (m.info>0){
                if (l1.tete==null){
                    l1.tete=new Maillon(m.info);
                    n=l1.tete;
                    l1.tete.succ=n.succ;
                }else{
                    n.succ= new Maillon(m.info);
                    n=n.succ;
                }
            }
            m=m.succ;
        }
        return l1;
    }
    public static List sous_list_rec(List l){
        List l1 = new List(sous_list_rec(l.tete));
        return l1;
    }
    private static Maillon sous_list_rec(Maillon m){
        if(m==null) return null;
        if (m.info>0){
            Maillon nouv = new Maillon (m.info);
            nouv.succ=sous_list_rec(m.succ);
            return nouv;
        }
        return sous_list_rec(m.succ);
    }
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
    public static List concatener(List l1 , List l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        Maillon m1 = l1.tete;
        while(m1.succ!=null){
            m1=m1.succ;
        }
        m1.succ=l2.tete;
        return l1;
    }
    public static List concatenerLDC(List l1,List l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        Maillon m1 = l1.tete;
        while(m1.succ!=null){
            m1=m1.succ;
        }
        l2.tete.pred= m1;
        m1.succ=l2.tete;
        return l1;
    }
    public static void ajoutLSC(List l , int p, int e){
        if(p==0){
            Maillon nouv = new Maillon(e);
            nouv.succ=l.tete;
            l.tete=nouv;
        }else if (p<=longueur(l)){
            Maillon m = l.tete;
            Maillon prec = null;
            while (m!=null){
                prec=m;
                if (p==0){
                    Maillon nouv = new Maillon(e);
                    prec.succ=nouv;
                    nouv.succ=m;
                }
                p--;
                m=m.succ;
            }
        }else{
            Maillon m = l.tete;
            Maillon prec = null;
            while (m!=null){
                prec=m;
                m=m.succ;
            }
            Maillon nouv = new Maillon(e);
            prec.succ=nouv;
            nouv.succ=m;
        }
    }
    public static void ajoutLDC(List l , int p, int e){
        if(p==0){
            Maillon nouv = new Maillon(e);
            nouv.pred=null;
            nouv.succ=l.tete;
            l.tete.pred=nouv;
            l.tete=nouv;
        }else if (p<=longueur(l)){
            Maillon m = l.tete;
            Maillon prec = null;
            while (m!=null){
                prec=m;
                if (p==0){
                    Maillon nouv = new Maillon(e);
                    nouv.pred=prec;
                    prec.succ=nouv;
                    nouv.succ=m;
                    m.pred=nouv;
                }
                p--;
                m=m.succ;
            }
        }else{
            Maillon m = l.tete;
            Maillon prec = null;
            while (m!=null){
                prec=m;
                m=m.succ;
            }
            Maillon nouv = new Maillon(e);
            nouv.pred=prec;
            prec.succ=nouv;
            nouv.succ=m;
            m.pred=nouv;
        }
    }
}
