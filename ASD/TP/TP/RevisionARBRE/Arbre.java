 
public class Arbre
{
     Noeud racine;
     public Arbre (){
         
     }
     public Arbre(Noeud n){
         this.racine=new Noeud (n.info);
     }
    public static Arbre creerArbreParfait(int n , int val){
        Arbre a = new Arbre();
        a.racine = creerNoeudParfait(n,val);
        return a;
    }
    public static Noeud creerNoeudParfait(int n,int val){
        if (n>0){
            Noeud m = Noeud.CreeNoeud(val);
            m.sag= creerNoeudParfait(n-1,val*2);
            m.sad=creerNoeudParfait(n-1,val*2+1);
            return m;
        }else{
            return null;
        }
    }
    public void afficherPreordre(Arbre a){
        afficherPreordre(a.racine);
        System.out.println();
    }
    private void afficherPreordre(Noeud n){
        if (n!=null){
            System.out.print(n.info +" ");
            afficherPreordre(n.sag);
            afficherPreordre(n.sad);
        }
    }
    public void afficherInordre(Arbre a){
        afficherInordre(a.racine);
        System.out.println();
    }
    private void afficherInordre(Noeud n){
        if (n!=null){
            afficherInordre(n.sag);
            System.out.print(n.info +" ");
            afficherInordre(n.sad);
        }
    }
    public void afficherPostordre(Arbre a){
        afficherPostordre(a.racine);
        System.out.println();
    }
    private void afficherPostordre(Noeud n){
        if (n!=null){
            afficherPostordre(n.sag);
            afficherPostordre(n.sad);
            System.out.print(n.info +" ");
        }
    }
    public void affichage(Arbre a){
        affichage(a.racine,0);
    }
    private void affichage(Noeud n , int p){
        if (n!=null){
            for (int i=0; i<p;i++){
                System.out.print(" ");
                if (i==p-1){
                    System.out.print("|-");
                }
            }
            System.out.println(n.info);
            if (n.sag==null && n.sad!=null){
                for (int i=0; i<p+1;i++){
                    System.out.print(" ");
                    if (i==p){
                        System.out.print("|-");
                    }
                }
                System.out.println("X");
                affichage(n.sad,p+1);
            }else if (n.sad==null && n.sag!=null){
                affichage(n.sag,p+1);
                for (int i=0; i<p+1;i++){
                    System.out.print(" ");
                    if (i==p){
                        System.out.print("|-");
                    }
                }
                System.out.println("X");
            }else if (n.sag!=null && n.sad!=null){
                affichage(n.sag,p+1);
                affichage(n.sad,p+1);
            }
        }
    }
    public static int nbElement(Arbre a){
        return nbElement(a.racine);
    }
    private static int nbElement(Noeud n){
        if (n==null) return 0;
        return 1+ nbElement(n.sag)+nbElement(n.sad);
    }
    public static int nbFeuilles(Arbre a){
        return nbFeuilles(a.racine);
    }
    private  static int nbFeuilles(Noeud n){
        if (n==null) return 0;
        if (n.sag==null && n.sad==null){
            return 1;
        }else{
            return nbFeuilles(n.sad)+nbFeuilles(n.sag);
        }
    }
    public static int nbPointsDouble(Arbre a){
        return nbPointsDouble(a.racine);
    }
    private static int nbPointsDouble(Noeud n){
        if (n==null) return 0;
        if (n.sad!=null && n.sag!=null){
            return 1+ nbPointsDouble(n.sag)+nbPointsDouble(n.sad);
        }else{
            return nbPointsDouble(n.sag)+nbPointsDouble(n.sad);
        }
    }
    public static int nbPointSimple(Arbre a){
        return nbPointSimple(a.racine);
    }
    private static int nbPointSimple(Noeud n){
        if (n==null) return 0;
        if ((n.sag!=null && n.sad==null) ||(n.sag==null && n.sad!=null)){
            return 1+ nbPointSimple(n.sag)+nbPointSimple(n.sad);
        }else{
            return nbPointSimple(n.sag)+nbPointSimple(n.sad);
        }
    }
    public static int Hauteur(Arbre a){
        return Hauteur(a.racine);
    }
    private static int Hauteur(Noeud n){
        if (n==null) return 0;
        
        else{
            if (Hauteur(n.sag)>Hauteur(n.sad)){
                return 1+Hauteur(n.sag);
            }else{
                return 1+Hauteur(n.sad);
            }
        }
    }
    public static boolean rechercheABR(Arbre a, int e){
        return rechercheABR(a.racine,e);
    }
    private static boolean rechercheABR(Noeud n,int e){
        if (n==null) return false;
        if (n.info==e) return true;
        if (e>n.info) return rechercheABR(n.sad,e);
        return rechercheABR(n.sag,e);
    }
    public static Arbre ajout(Arbre a, int e){
        if (a== null){
            a= new Arbre();
            a.racine= Noeud.CreeNoeud(e);
        }else{
            a.racine=ajout(a.racine,e);
        }
        return a;
    }
    private static Noeud ajout(Noeud n , int e){
        if (n==null) return Noeud.CreeNoeud(e);
        if (e>n.info){
             n.sad=ajout(n.sad,e);
        }
        if (e<n.info){
            n.sag=ajout(n.sag,e);
        }
        return n;
    }
    public static int minABR(Arbre a){
        Noeud n = minABR(a.racine); 
        return n.info;
    }
    private static Noeud minABR(Noeud n){
        Noeud m = n;
        while(m.sag!=null){
            m=m.sag;
        }
        return m;
    }
    public static int maxABR(Arbre a){
        Noeud n =maxABR(a.racine); 
        return n.info;
    }
    public static Noeud maxABR(Noeud a){
        Noeud n = a;
        while(n.sad!=null){
            n=n.sad;
        }
        return n;
    }
    public static void echangeMax(Arbre a){
        echangeMax(a.racine);
    }
    private static void echangeMax(Noeud n){
        Noeud max= maxABR(n);
        int temp= n.info;
        n.info=max.info;
        max.info = temp;        
    }
    public static void echangeMax(Arbre a , int e){
        Noeud n = a.racine;
        while (n!=null && n.info!=e){
            if (e>n.info){
                n=n.sad;
            }else{
                n=n.sag;
            }
        }
        echangeMax(n);
    }
    public static void echangeMin(Arbre a){
        echangeMin(a.racine);
    }
    private static void echangeMin(Noeud n){
        Noeud max= minABR(n);
        int temp= n.info;
        n.info=max.info;
        max.info = temp;        
    }
    public static void echangeMin(Noeud a , int e){
        Noeud n = a;
        while (n!=null && n.info!=e){
            if (e<n.info){
                n=n.sad;
            }else{
                n=n.sag;
            }
        }
        echangeMin(n);
    }
    // apres l'échange l'arbre n'est plus un ABR
    public static void supprimerABR(Arbre a, int e){
        a.racine=supprimerABR(a.racine,e);
    }
    public static Noeud supprimerABR(Noeud n, int e){
        if (n!=null){
             if (e>n.info){
               n.sad=supprimerABR(n.sad,e);
            }else if (e<n.info){
                n.sag=supprimerABR(n.sag,e);
            }else{
                if (n.sag==null){
                    n=n.sad;
                }else if (n.sad==null){
                    n=n.sag;
                }else{
                    int temp =n.info;
                    Noeud max = maxABR(n);
                    n.info=max.info;
                    max.info=temp;
                    n.sad=supprimerABR(n.sad,e);
                    return n;
                }
            }
        }
        return null;
    }
    // session 1
    public static void supprimerPetit(Arbre a ){
        a.racine = supprimerPetit(a.racine);
    }
    private static Noeud supprimerPetit(Noeud n){
        if (n!=null){
            if (n.sag!=null){
                n.sag=supprimerPetit(n.sag);
            }else{
                n=null;
            }
        }
        return n;
    }
    // session 1
    public static int nbFe(Arbre a,int p){
        return nbFe(a.racine,p);
    }
    private static int nbFe(Noeud n , int p){
        if (n==null) return 0;
        if (p>0){
            return nbFe(n.sag,p-1)+nbFe(n.sad,p-1);
        }else{
            if(n.sag==null && n.sad==null){ 
              return 1+nbFe(n.sag,p-1)+nbFe(n.sad,p-1);
            }else{
                return nbFe(n.sag,p-1)+nbFe(n.sad,p-1); 
            }
        }
    }
    public static int noeudsFreres(Arbre a , Noeud n1 , Noeud n2){
        return noeudsFreres(a.racine, n1,n2);
    }
    private static int noeudsFreres(Noeud n , Noeud n1, Noeud n2){
        if (n==null) return 0;
        if (n.sag==null || n.sad==null) return 0;
        if ((n.sag.info==n1.info && n.sad.info==n2.info)||(n.sag.info==n2.info && n.sad.info==n2.info)){
            return 1;
        }
        return (noeudsFreres(n.sag,n1,n2)+ noeudsFreres(n.sad,n1,n2));
    }
    public static int somme_pintsDoubles_couche(Arbre a, int c){
        return somme(a.racine,c);
    }
    private static int somme(Noeud n , int c){
        if (n==null) return 0;
        if (n.sag==null || n.sad==null) return 0;
        if (c>=1){
           if (n.sag!=null && n.sad!=null){
               return n.info+somme(n.sag,c-1)+somme(n.sad,c-1);
           }else{
               return somme(n.sag,c-1)+somme(n.sad,c-1);
           }
        }
        return 0;
    }
    // SESSION 2 BONUS
    public static int distance(Arbre a,Noeud n1, Noeud n2){
        return distance(a.racine,n1,n2);
    }
    private static int distance(Noeud n , Noeud n1 , Noeud n2){
        if (n==null) return 0;
        if (n1.info>n.info && n2.info>n.info ){
            return distance(n.sad,n1,n2);
        }else if (n2.info<n.info && n1.info<n.info){
            return  distance(n.sag,n1,n2);
        }else{
            return profondeur(n,n1)+profondeur(n,n2);
        }
    }
    // c'est pour calculer la distance
    private static int profondeur(Noeud racine, Noeud n){
        if (racine==null) return 0;
        if (n.info>racine.info){
            return 1+profondeur(racine.sad,n);
        }
        if (n.info<racine.info){
            return 1+profondeur(racine.sag,n);
        }
        return 0;
    }
    // créé une copie / créé un autre arbre extact pareil 
    public Arbre dupliquerAb(Arbre a){
        Arbre copie = new Arbre();
        copie.racine= dupliquer(a.racine);
        return copie;
    }
    private Noeud dupliquer(Noeud n){
        if (n==null) return null;
        Noeud nouv = new Noeud (n.info);
        nouv.sag=dupliquer(n.sag);
        nouv.sad=dupliquer(n.sad);
        return nouv;
    }
    // supprimer un ABR
    public static void supprimer(Arbre a){
        supprimer(a.racine);
    }
    private static void supprimer(Noeud n){
        if (n!=null){
            supprimer(n.sag);
            supprimer(n.sad);
            n=null;
        }
    }
    // nombre de noeud 
    public static int nbNoeud(Arbre a , int p){
        return nbNoeud(a.racine,p);
    }
    private static int nbNoeud(Noeud n , int p){
        if (n==null) return 0;
        if (p>0){
            return nbNoeud(n.sag,p-1) + nbNoeud(n.sad,p-1);
        }else if (p==0){
            return 1+nbNoeud (n.sag,p-1)+ nbNoeud(n.sad,p-1);
        }else{
            return 0;
        }
    }
    // la profondeur avec la max de noeud 
    public static int nbMaxNoeud(Arbre a){
        int max =0;
        int etage =-1;
        int profondeur=0;
        int cmp=0;
        while (etage!=0){
            etage=nbNoeud(a,profondeur);
            if (max<etage){
                max=etage;
                cmp++;
            }
            profondeur++;
        }
        return cmp;
    }

    //symetrique
    public static Arbre symetrique(Arbre a){
        return new Arbre(symetrique_aux(a.getRacine()));
    }

    public static Noeud symetrique_aux(Noeud noeud){
        if(noeud == null){
            return null;
        }
        else{
            Noeud tmp = noeud.getGauche();
            noeud.setGauche(noeud.getDroite());
            noeud.setDroite(tmp);
            symetrique_aux(noeud.getGauche());
            symetrique_aux(noeud.getDroite());
        }
        return noeud;
    }

    // transpose 
    public static Arbre transpose(Arbre a) {
        transposeAux(a.getRacine(), null);
        return a;
    }

    public static Noeud transposeAux(Noeud noeud,Noeud prec) {
        if(noeud == null){
            return null;
        } else if(noeud.getGauche() == null && noeud.getDroite() == null){
            Noeud b = prec.getGauche();
            prec.setGauche(prec.getDroite());
            prec.setDroite(b);
        } else if (noeud.getGauche().getGauche() == null || noeud.getDroite().getDroite() == null){
            transposeAux(noeud.getGauche(),noeud);
        } else {
            transposeAux(noeud.getGauche(),noeud);
            transposeAux(noeud.getDroite(),noeud);
        }
        return noeud;
    }
}
