package test;


public class Pile
{
    private static final int taille = 100;
    int[] tab = new int [taille];
    int sommet ; 

    public Pile inisialiserPile(){
        Pile p = new Pile();
        p.sommet = -1;
        return p;
    }

    public boolean estPileVide(Pile p){
        return (p.sommet==-1);
    }

    public void empiler(Pile p ,int x) throws PilePleineException{
        p.sommet++;
        p.tab[p.sommet]=x;

    }

    public void depiler(Pile p, int x)throws PileVideException{

        p.sommet--;

        p.tab[p.sommet+1]= x;

    }
    public int sommet(Pile p) throws PileVideException{
        // if(!estPileVide(p)){
        return p.tab[p.sommet] ;
        // }
        // return -10;
    }

    public void afficherPile(Pile p){
        if(estPileVide(p)) return ;
        for(int i= p.sommet ; i>=0 ; i--){
            System.out.print(p.tab[i]+" ");
        }
    }

    
}
