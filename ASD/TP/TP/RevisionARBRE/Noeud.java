package RevisionARBRE;

public class Noeud
{
     int info;
     Noeud sag, sad;
     public Noeud(int val){
         this.info=val;
     }
     public Noeud(){
         
     }
    public static Noeud CreeNoeud(int valeur){
        Noeud n = new Noeud ();
        n.sag=null;
        n.sad=null;
        n.info=valeur;
        return n;
    }
    @Override
    public String toString(){
        return info  + " ";
    }
}
