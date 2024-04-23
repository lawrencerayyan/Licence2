package TP2;



public class Casillo
{
    
    long Vdefaut=1000;
    
    public Casillo()
    {
        }
    
    public Chronometre chronometre () {
        return new Chronometre() ;
    }
    
    public Attente attente(long duree){
        return new Attente(duree);
    }
       
    public Attente attenteDefaut(){
        return new Attente(Vdefaut);
    }
    
    public void changeDefaut(long defaut ){
        Vdefaut= defaut ;
    }
    
}
