package TP2;

public class Attente
{
    
    private long duree ;
    Chronometre chrono ;
    
    public Attente (long duree){
        this.duree = duree ;
        chrono = new Chronometre();
    }
    
    public boolean tempsDepasse () {
        return (duree <= chrono.dureeMicro());
    }
    
    public void attendFin (){
        if (tempsDepasse() ==  false ) {
        nanosleep((duree-chrono.dureeMicro()*1000 ));
        }
    }
    
    public static void nanosleep(long nanoseconds) {
 try {
 java.util.concurrent.TimeUnit.NANOSECONDS.sleep(nanoseconds);
 }
 catch (java.lang.InterruptedException e) {
 throw new java.lang.AssertionError(e);
 }
 } 
}
