package TP5;


/**
 * Décrivez votre classe Noeud ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Noeud
{
    private int info ;
    private Noeud sag ;
    private Noeud sad ;
    public Noeud(int val)
    {
       this.info= val ; 
    }

    public Noeud getSag(){
    return sag ;}
    
    public Noeud getSad(){
    return sad; }
    
    public int getInfo(){
    return info ;}
    
    public void setInfo(int val ) {
    this.info = val ;
    }
    
    public void setSag(Noeud l ){
    sag= l ;}
    
    public void setSad(Noeud r ){
    sad= r ;}
    
    @Override
    public String toString(){
    return "->" + this.info ;}
    
}
